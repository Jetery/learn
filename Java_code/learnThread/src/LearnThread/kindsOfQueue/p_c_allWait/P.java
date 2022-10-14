package LearnThread.kindsOfQueue.p_c_allWait;

import LearnThread.kindsOfQueue.p_r_test.ValueObject;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class P {
    private Object locker;

    public P(Object p) {
        this.locker = p;
    }

    public void setValue() {
        try {
            synchronized (locker) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 "
                            + Thread.currentThread().getName() + " WAITING ★");
                    locker.wait();
                }
                System.out.println("生产者 "
                        + Thread.currentThread().getName() + " RUNNABLE");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                locker.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
