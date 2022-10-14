package LearnThread.learnSingleton;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.11
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(SingletonHungry.getInstance().hashCode());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(SingletonLazy.getInstance().hashCode());
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t3.start();
        t1.start();
        t2.start();

        Thread t11 = new Thread(new MyRunnable());
        Thread t12 = new Thread(new MyRunnable());
        Thread t13 = new Thread(new MyRunnable());
        t12.start();
        t11.start();
        t13.start();

    }
}
