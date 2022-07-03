package com.example.Thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsync {
    private static void delay(int sec){
        try{
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        Supplier<String> supplier = () -> {
            delay(1);
            System.out.println("I am in supplier "+ Thread.currentThread().getName());
            return "Hello from supplier ";
        };
        CompletableFuture<String> complete = CompletableFuture.supplyAsync(supplier);
        System.out.println("I am in thread  "+ Thread.currentThread().getName());
        String value = complete.join();
        System.out.println("Value --- "+value);

    }
}
