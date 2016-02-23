import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Cindy on 16/2/13.
 */
public class Hongbao {

    private static final Random random = new Random();

    /**
     * 题目要求：
     * 1，红包金额不超过200
     * 2，红包个数不超过100
     */
    public void generate() throws NullPointerException{
        try{
            double sum = (int)(random.nextDouble() * 200 * 100) / 100.00;
//            int ranSumInt = random.nextInt(20000);
//            if(ranSumInt == 0){
//                ranSumInt = 20000;
//            }
//            double sum = ranSumInt / 100.00;

            //红包个数
            int amount = random.nextInt(10);
            //默认分成10个红包
            if(amount == 0){
                amount = 10;
            }

            if(sum*100 < amount){
                sum = sum + amount * 0.01;
            }

            //存储红包数值，单位为元
            double[] hongbaoArr = new double[amount];

            //可分配的红包总金额，单位为分。默认每人最少金额1分，需提前从总金额中减去。
            int newSum = (int)(sum * 100) - amount;

            //发出的红包总额，单位为分
            int sentHongbaoTotal = 0;

            //开始发红包
            for(int i=0; i<amount-1; i++){
                int ranInt = (int)(random.nextDouble() * newSum);
//                if(newSum <= 0){
//                    newSum = 1;
//                }
//                int ranInt = random.nextInt(newSum);
                hongbaoArr[i] = new Double(ranInt + 1) / 100;
//                newSum = newSum - ranInt;
                if(newSum <= ranInt){
                    newSum = 1;
                }else{
                    newSum = newSum - ranInt;
                }

                sentHongbaoTotal += (ranInt + 1);
            }
            //从分转换到元
            hongbaoArr[amount-1] = Math.round(sum * 100 - sentHongbaoTotal) / 100.00;

//          System.out.println("红包个数：" + amount + "，金额：\t" + sum + "\t， 内容：" + Arrays.toString(hongbaoArr).replaceAll(",", "\t").replace("[", "\t").replace("]","\t"));

        }catch (NullPointerException ne){
            throw new NullPointerException(ne.toString());
        }
    }

    /**
     * 发1,0000,0000次红包
     */
    public static void main(String[] args) {
        int div = 10000000;
//        int div = 1;
        int max = div * 10;

        Hongbao hb = new Hongbao();

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
//                        System.out.println("发了个"+i+"红包，用时：\t" + ((endTime-curTime)/1000) + "\t s");
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
