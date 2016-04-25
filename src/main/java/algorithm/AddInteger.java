package algorithm;/**
 * @COPYRIGHT (C) 2016 Schenker AG
 * <p/>
 * All rights reserved
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
      @Author: Junying Li
 */
public class AddInteger {
    private int total;
    private int player1;
    private int player2;
    private volatile boolean runFlag =true;

    public static void main(String args[]){
        try {
            new AddInteger();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AddInteger() throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.execute(runner1);
        executors.execute(runner2);
        Thread.sleep(1000);
        runFlag = false;
        System.out.println((player1+player2) == total);
        executors.shutdown();
    }

    private Runnable runner1 = new Runnable() {
        public void run() {
            while(runFlag){
                total++;
                player1++;
            }
        }
    };

    private Runnable runner2 = new Runnable() {
        public void run() {
            while(runFlag){
                total++;
                player2++;
            }
        }
    };
}


