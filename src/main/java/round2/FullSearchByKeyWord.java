package main.java.round2;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Cindy on 16/2/23.
 * 需要查找的文档在doc下
 */
public class FullSearchByKeyWord {

    /**
     * 逐行读取
     * @param fileName
     * @param searchWord
     * @return
     */
    private int searchByKerWord(String fileName, String searchWord){
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

    public static void main(String[] args) throws FileNotFoundException {
        String searchStr = "大金牙";
        String fileName = "doc/鬼吹灯II.txt";

        FullSearchByKeyWord fsbk = new FullSearchByKeyWord();

        long startTime = System.currentTimeMillis();
        long endTime = 0;

        int round = 100;
        int shownCount=0;

        for(int i=0; i<round; i++){
            shownCount = fsbk.searchByKerWord(fileName, searchStr);
        }

        endTime = System.currentTimeMillis();
        System.out.println("关键字 \"" + searchStr + "\" 出现了 " + shownCount + " 次。");
        System.out.println("Run " + round + " 轮，共耗时 " + (endTime-startTime)  + " ms，平均每次耗时 " + ((endTime-startTime)/round) + " ms.");
    }
}
