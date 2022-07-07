package com.example.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Completeasync {

    private static void delay(int sec){
        try{
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        Runnable run = () -> {
            delay(1);
            System.out.println("Running a job with thread "+Thread.currentThread().getName());
        };
        CompletableFuture<Void> complete = CompletableFuture.runAsync(run);
        System.out.println("I am in main thread "+Thread.currentThread().getName());
        complete.join();


    }
}
