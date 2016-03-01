package algorithm;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

import java.util.Random;

/**
 * @author Vani Li
 */
public class GuessNumber {
       static int targetNumber = new Random().nextInt(100);

       static int steps = 0;

    public static void main(String args[]){
         int startNumber = new Random().nextInt(100);
         System.out.println("startNumber:"+startNumber);
         System.out.println("Steps:"+guessNumber(startNumber));
    }

    public static int guessNumber(int guessNumber){
        steps++;
        if(targetNumber>guessNumber)  return guessNumber(guessNumber+1);
        if(targetNumber<guessNumber)  return guessNumber(guessNumber/-1);
        if(targetNumber==guessNumber){
            System.out.println("Hit:"+targetNumber);
            return steps;
        }
        return steps;
    }
}
