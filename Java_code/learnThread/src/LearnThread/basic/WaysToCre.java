package LearnThread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.02
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("t3");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("t4");
    }
}

// 实现Callable接口
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "create by Callable";
    }
}

public class WaysToCre {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("t2");
            }
        };
        Thread t3 = new MyThread();
        Runnable myRunnable = new MyRunnable();
        Thread t4 = new Thread(myRunnable);
        // use Lambda
        Thread t5 = new Thread(() -> System.out.println("t5"));

        MyCallable myCallable = new MyCallable();
        FutureTask<String> task = new FutureTask<>(myCallable);
        Thread t6 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println("t6 :" + task.get());
    }
}
