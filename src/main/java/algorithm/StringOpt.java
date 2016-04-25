package algorithm;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

/**
 * @author Vani Li
 */
public class StringOpt {

    public static void main(String args[]){
        String s = "abc111111abvc";
        System.out.println(convertTarget(s));
    }

    public static String convertTarget(String target) {
        String streetName = null;
        if(target != null){
            streetName = target;
            if(streetName.length()>10)
                streetName = streetName.substring(10, streetName.length());
        }
        return streetName;
    }
}
