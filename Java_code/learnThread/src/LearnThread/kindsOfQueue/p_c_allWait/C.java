package LearnThread.kindsOfQueue.p_c_allWait;

import LearnThread.kindsOfQueue.p_r_test.ValueObject;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class C {
    private Object locker;

    public C(Object locker) {
        this.locker = locker;
    }

    public void getValue() {
        try {
            synchronized (locker) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者 " +
                            Thread.currentThread().getName() + " WAITING ☆");
                    locker.wait();
                }
                System.out.println("消费者 " +
                        Thread.currentThread().getName() + " RUNNABLE");
                ValueObject.value = "";
                locker.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
