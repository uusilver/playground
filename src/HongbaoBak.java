import java.util.Random;

/**
 * Created by Cindy on 16/2/13.
 */
public class HongbaoBak {

    public HongbaoBak(){
    }

    /**
     * 题目要求：
     * 1，红包金额不超过200
     * 2，红包个数不超过100
     */
    public void generate(){
//        DecimalFormat df = new DecimalFormat("#.00");
        Random random = new Random();

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
//        for(int i=0; i<amount; i++){
//            if(i == amount - 1){
////                hongbaoArr[i] = new Double(df.format(sum - sentHongbaoTotal));
//                hongbaoArr[i] = sum - sentHongbaoTotal;
//                hongbaoArr[i] = new Double(roundTo2Decimals(sum - sentHongbaoTotal));
////            }else{
//                double ranDouble = random.nextDouble() * newSum;
////                hongbaoArr[i] = new Double(df.format(ranDouble + 0.01));
//                hongbaoArr[i] = ranDouble + 0.01;
////                hongbaoArr[i] = new Double(roundTo2Decimals(ranDouble + 0.01));
//
//                newSum = newSum - ranDouble;
//                sentHongbaoTotal += hongbaoArr[i];
//            }
//        }
        for(int i=0; i<amount-1; i++){
            double ranDouble = random.nextDouble() * newSum;
//                hongbaoArr[i] = new Double(df.format(ranDouble + 0.01));
//                hongbaoArr[i] = new Double(roundTo2Decimals(ranDouble + 0.01));

            hongbaoArr[i] = ranDouble + 0.01;
            newSum = newSum - ranDouble;
            sentHongbaoTotal += hongbaoArr[i];
        }
//        hongbaoArr[amount-1] = new Double(df.format(sum - sentHongbaoTotal));
//        hongbaoArr[amount-1 = new Double(roundTo2Decimals(sum - sentHongbaoTotal));
        hongbaoArr[amount-1] = sum - sentHongbaoTotal;
//        System.out.println("红包个数：" + amount + "，金额：\t" + roundTo2Decimals(sum) + "\t， 内容：" + Arrays.toString(hongbaoArr).replaceAll(",", "\t").replace("[", "\t").replace("]","\t"));
    }

    private String roundTo2Decimals(double doubleValue){
        String doubleStr = String.valueOf(doubleValue);
        if(doubleStr.indexOf(".") > -1){
            return doubleStr.substring(0, doubleStr.indexOf(".")+3);
        }else{
            return doubleStr;
        }
    }

    /**
     * 发1,0000,0000次红包
     */
    public static void main(String[] args) {
        int div = 10000000;
        int max = div * 10;

        for(int r=0; r<5; r++){
            System.out.println("Round[" + r + "]:开始发红包......");

            long startTime = System.currentTimeMillis();
            long endTime = 0;
            long curTime = startTime;

            HongbaoBak hb = new HongbaoBak();
            for(int i=0; i<max; i++){
                hb.generate();
                if(i>0 && i % div == 0){
                    endTime = System.currentTimeMillis();
//                    System.out.println("发了个"+i+"红包，用时：\t" + ((endTime-curTime)/1000) + "\tms");
                    curTime = System.currentTimeMillis();
                }
            }

            endTime = System.currentTimeMillis();
            System.out.println(max + "\t个红包发完，耗时：\t" + ((endTime-startTime)/1000) + "\tms.");
        }
    }
}
