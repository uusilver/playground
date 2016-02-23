import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Main {

    private String roundTo2Decimals(double doubleValue){
        String doubleStr = String.valueOf(doubleValue);
        if(doubleStr.indexOf(".") > -1){
            return doubleStr.substring(0, doubleStr.indexOf(".")+3);
        }else{
            return doubleStr;
        }
    }

    private String roundTo2Decimals2(double doubleValue){
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(doubleValue);
    }

    /**
     * 发1,0000,0000次红包
     */
    public static void main(String[] args) {
        int div = 10000;
        int max = div * 10;

        System.out.println("开始发红包......");

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        long curTime = startTime;

        Main main = new Main();
        for(int i=0; i<max; i++){
            main.roundTo2Decimals2(123.456);
        }

        endTime = System.currentTimeMillis();
        System.out.println(max + "耗时：\t" + (endTime-startTime) + "\tms.");
        System.out.println(new Float(12.01));

    }
}
