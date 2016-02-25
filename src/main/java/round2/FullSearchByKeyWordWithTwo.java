package main.java.round2;

import java.io.*;

/**
 * Created by Cindy on 16/2/23.
 * 需要查找的文档在doc下
 */
public class FullSearchByKeyWordWithTwo {

    public int searchByKerWord(int searchType, String fileName, String searchWord){
        if(searchType == 1){
            return this.searchByKerWordByline(fileName, searchWord);
        } else {
            return this.searchByKerWordByTwoLine(fileName, searchWord);
        }
    }

    /**
     * 逐行读取
     * @param fileName
     * @param searchWord
     * @return
     */
    private int searchByKerWordByline(String fileName, String searchWord){
        int shownCount = 0;

        FileReader fr = null;
        BufferedReader bf = null;

        try{
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);

            String valueString = null;
            while ((valueString=bf.readLine())!=null){
                while(valueString.indexOf(searchWord) != -1){
                    shownCount ++;
//                    System.out.println(">>"+shownCount+":\t"+valueString);
                    valueString = valueString.substring(valueString.indexOf(searchWord)+searchWord.length(), valueString.length());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return shownCount;
    }

    /**
     * 按指定长度读取
     * @param fileName
     * @param searchWord
     * @return
     */
    private int searchByKerWordByTwoLine(String fileName, String searchWord){
        int shownCount = 0;

        FileReader fr = null;
        BufferedReader bf = null;

        try{
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);

            String valueString = null;
            String preValueString = "";
            String curValueString = "";
            while ((curValueString=bf.readLine())!=null){
                valueString = preValueString + curValueString;
                while(valueString.indexOf(searchWord) != -1){
                    shownCount ++;
//                    System.out.println(">>"+shownCount+":\t"+valueString);
                    valueString = valueString.substring(valueString.indexOf(searchWord)+searchWord.length(), valueString.length());
                }
                preValueString = valueString;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return shownCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String searchStr = "大金牙";
        String fileName = "doc/鬼吹灯II.txt";

        FullSearchByKeyWordWithTwo fsbk = new FullSearchByKeyWordWithTwo();

        //searchType=1:逐行读取； 其他：按照2行读取
        int searchType = 2;
        System.out.println("开始 " + (searchType==1?"逐行":"每两行") + " 搜索......");

        long startTime = System.currentTimeMillis();
//        long curTime = startTime;
        long endTime = 0;

        int round = 10;
        int shownCount=0;

        for(int i=0; i<round; i++){
            shownCount = fsbk.searchByKerWord(searchType, fileName, searchStr);
//            endTime = System.currentTimeMillis();
//            System.out.println("Round[" + i + "]: \"" + searchStr + "\" 共出现了 " + shownCount + " 次，耗时：" + (endTime-curTime)  + " ms");
//            curTime = System.currentTimeMillis();
        }

        endTime = System.currentTimeMillis();
        System.out.println("关键字 \"" + searchStr + "\" 出现了 " + shownCount + " 次。");
        System.out.println("Run " + round + " 轮，共耗时 " + (endTime-startTime)  + " ms，平均每次耗时 " + ((endTime-startTime)/round) + " ms.");
    }
}
