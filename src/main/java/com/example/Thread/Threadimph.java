package com.example.Thread;

import java.util.stream.IntStream;

public class Threadimph  {

     public static void main(String[] args){
         MultithreadingThread th = new MultithreadingThread(1);
         MultithreadingThread th2 = new MultithreadingThread(2);
         MultithreadingRun th3 = new MultithreadingRun(3);
         Thread t = new Thread(th3);
         t.start();
        //If you use run it will use main thread
         th.start();
         th2.start();

     }

}

class MultithreadingThread extends Thread {
    int threadNumber;
    public MultithreadingThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        IntStream.range(0,5)
                .forEach(x->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x +"from thread "+threadNumber +"  "+ Thread.currentThread().getName());
                });
    }
}

class MultithreadingRun implements Runnable {
    int threadNumber;
    public MultithreadingRun(int threadNumber) {
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        IntStream.range(0,5)
                .forEach(x->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x +"from thread "+threadNumber +"  "+ Thread.currentThread().getName());
                });
    }
}
