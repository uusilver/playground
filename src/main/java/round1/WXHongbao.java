import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Vani Li
 */
public class WXHongbao {

    private static final Random random = new Random();

//    private static final DecimalFormat dcmFmt = new DecimalFormat("0.00");

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
//        System.out.println("CPU数:"+cpu);
        for(int i=0;i<100000000;i++){ //1亿次
            float f = random.nextFloat() * 200;
//            f = Float.valueOf(dcmFmt.format(f)); //红包金额
            int totalNum = random.nextInt(100); //红包个数
            int countTotalMoney = (int) (f*100); //用于计算的红包个数
            if((totalNum<countTotalMoney)){    //确保每个人至少分到 0.01元，因为利用DOUBLE需要乘100，所以 0.01*100 = 1，这里就不再需要乘了
                double[] pool = new double[totalNum]; //初始化红包的容器数据大小[根据红包的个数]
                for(int times = totalNum;times>0;times--){
                    int currentRoundMoney = 0; //本轮红包金额
                    int avaiableProcessMoney = countTotalMoney-times; //可以用来随机的金额(减去轮数以保证每个人至少可以分到0.01元)
                    if(times==1){
                        currentRoundMoney = avaiableProcessMoney+1; //最后一轮无需随机，直接获取(加1来过滤,double计算的精度缺失)
                    }else{
                        currentRoundMoney = random.nextInt(avaiableProcessMoney/times+1)+1; //本轮金额(为了防止金额分布不均，每次会再除以当前的轮数,为了防止余数为0的情况，+1)
                        countTotalMoney -= currentRoundMoney; //总额递减
                    }
                    double keepInArray =(Math.round(currentRoundMoney)/100.0); //因为金额乘了100，这里要除100
                    pool[times-1] = keepInArray;//将金额放入数组
                }
//                    System.out.println("本轮:"+i+"生成金额:"+f+" 红包数:"+totalNum+ " 红包的内容:"+ Arrays.toString(pool));
//                    if(pool.length == totalNum && checkPoolNumber(checkPool)==(f*100)){
//                        System.out.println("合法");
//                    }else{
//                        System.out.println("数组长度:"+pool.length + "总金额:"+checkPoolNumber(checkPool));
//
//                    }
            }//if
        }//for

        long endTime = System.currentTimeMillis();
        System.out.println(((endTime-startTime)/1000)+" 秒");
    }

    public static int checkPoolNumber(int[] pool){
        int total = 0;
        for(int i:pool){
            total += i;
        }
        return total;
    }
}
