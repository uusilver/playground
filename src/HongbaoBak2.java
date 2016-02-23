import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Cindy on 16/2/13.
 */
public class HongbaoBak2 {

    private static final Random random = new Random();

    public HongbaoBak2(){
    }

    private int roundType = 0;

    /**
     * 保留两位小数点
     * roundType == 1, String截取进行格式化
     * roundType == 2, DecimalFormat
     * else no format
     */
    private double roundTo2Decimals(double doubleValue){
        if(roundType == 1){
            String doubleStr = String.valueOf(doubleValue);
            if(doubleStr.indexOf(".") > -1){
                return new Double(doubleStr.substring(0, doubleStr.indexOf(".")+3));
            }else{
                return doubleValue;
            }
        }else if(roundType == 2){
            DecimalFormat df = new DecimalFormat("#.00");
            return new Double(df.format(doubleValue));
        }else{
            return doubleValue;
        }
    }

    /**
     * 题目要求：
     * 1，红包金额不超过200
     * 2，红包个数不超过100
     */
    public void generate() throws NullPointerException{
        try{

            //红包金额
            double sum = random.nextDouble() * 200;

            //红包个数
            int amount = random.nextInt(100);
            //默认分成10个红包
            if(amount == 0){
                amount = 10;
            }

            //存储红包数值
            double[] hongbaoArr = new double[amount];

            //默认每人最少金额0.01，从总金额中减去
            double newSum = sum - 0.01*amount;

            //发出的红包总额
            double sentHongbaoTotal = 0.00;

            //开始发红包
            for(int i=0; i<amount-1; i++){
                double ranDouble = random.nextDouble() * newSum;
                hongbaoArr[i] = roundTo2Decimals(ranDouble + 0.01);
                newSum = newSum - ranDouble;
                sentHongbaoTotal += hongbaoArr[i];
            }
            hongbaoArr[amount-1] = roundTo2Decimals(sum - sentHongbaoTotal);

//          System.out.println("红包个数：" + amount + "，金额：\t" + roundTo2Decimals(sum) + "\t， 内容：" + Arrays.toString(hongbaoArr).replaceAll(",", "\t").replace("[", "\t").replace("]","\t"));

        }catch (NullPointerException ne){
            throw new NullPointerException(ne.toString());
        }
    }

    /**
     * 发1,0000,0000次红包
     */
    public static void main(String[] args) {
        int div = 10000000;
        int max = div * 10;

        HongbaoBak2 hb = new HongbaoBak2();

        for(int r=0; r<5; r++){
            try{
                System.out.println("Round[" + r + "]:开始发红包......");

                long startTime = System.currentTimeMillis();
                long endTime = 0;
                long curTime = startTime;

                for(int i=0; i<max; i++){
                    hb.generate();
                    if(i>0 && i % div*2 == 0){
                        endTime = System.currentTimeMillis();
                        System.out.println("发了个"+i+"红包，用时：\t" + ((endTime-curTime)/1000) + "\t s");
                        curTime = System.currentTimeMillis();
                    }
                }

                endTime = System.currentTimeMillis();
                System.out.println(max + "\t个红包发完，耗时：\t" + ((endTime-startTime)/1000) + "\t s.");

            }catch (NullPointerException ne){
                continue;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
