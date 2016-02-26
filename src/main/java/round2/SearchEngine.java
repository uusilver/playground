package round2;

/**
 * @author Vani Li
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.*;
import java.util.*;

public class SearchEngine {

    static String pattern = "大金牙";

    static int totalTimes = 0;
    public static void main(String args[]) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedReader in2 = new BufferedReader(new InputStreamReader(SearchEngine.class.getResourceAsStream("/book_ghost.txt")));

        String y = "";

        while ((y = in2.readLine()) != null) {//一行一行读
            SundySearch sundySearch = new SundySearch();
            ArrayList<Integer> index = sundySearch.QfindChr(y, pattern);
            if(index != null){
                totalTimes += index.size();
            }
        }

        System.out.println(pattern+"出现的次数:"+totalTimes);
        System.out.println("执行时间:"+(System.currentTimeMillis()-startTime)+"毫秒");

    }

    private static class SundySearch {

        public ArrayList QfindChr(String str, String Sfind){
            int str_length = 0;
            int fin_length = 0;

            int find_count = 0;
            int start = 0;
            int moveNum = 0;
            ArrayList<Integer> index = new ArrayList<Integer>();


            if(Sfind.length() == 0 || str.length() == 0){
                return null;
            }

            if (str.length() < Sfind.length()){
                return null;
            }

            str_length = str.length();
            fin_length = Sfind.length();


            while (start + fin_length <= str_length)
            {
                moveNum++;
                boolean isfind = false;// 是否在这次移动中找到
                String s_temp = str.substring(start, start + fin_length);
                if (Sfind.equals(s_temp)) {
                    index.add(start);//记录匹配字符的位置的第一个字符坐标
                    find_count++;
                    start = start + fin_length;
                    isfind = true;
                }
                if (isfind == false)// 如果没找到计算下次移动位置
                {
                    int forwardPos = QfindPos(str, Sfind, start, fin_length);
                    start = forwardPos;
                }
            }
            return  index;
        }

        //找字符在字符串(不算最后一个字符)的位置(倒数)
        //没找到返回fin_length,找到返回位置
        /// 找字符在字符串(不算最后一个字符)的位置(倒数);没找到返回str.length,找到返回位置
        public int QfindPos(String str, String find, int pos, int fin_length){
            int returnPos = str.length();
            char[] Schr = str.toCharArray();
            char[] Sfin = find.toCharArray();

            if ((pos + fin_length) < str.length())
            {
                char chrFind = Schr[pos + fin_length];//要找的字符
                if (fin_length >= 1)
                {
                    if (find.lastIndexOf(chrFind) > -1)//如果find里存在chrFind字符
                    {
                        returnPos = pos + fin_length - find.lastIndexOf(chrFind);
                    }
                    else{//如果find里不存在chrFind字符
                        returnPos = pos + fin_length + 1;
                    }
                }
            }
            return returnPos;
        }
    }

}
