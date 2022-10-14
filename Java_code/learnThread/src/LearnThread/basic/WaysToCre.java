package LearnThread.basic;

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

public class WaysToCre {
    public static void main(String[] args) {
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
        Thread t5 = new Thread(() -> System.out.println("5"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
