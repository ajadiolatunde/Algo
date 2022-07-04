package com.example.Thread;

import java.util.Random;
import java.util.concurrent.*;

public class Thread1 {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer>  future = service.submit(new Task());
        System.out.println("Thread - "+Thread.currentThread().getName());
        try{
            Integer result = future.get(2, TimeUnit.SECONDS);
            System.out.println("Result----"+result);

        }catch (InterruptedException e){
              e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch(TimeoutException e){
            System.out.println("Couldnt complete the task before timeout");
        }
    }
}
class Task implements Callable<Integer> {
    public Task() {
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return new Random().nextInt();
    }
}
