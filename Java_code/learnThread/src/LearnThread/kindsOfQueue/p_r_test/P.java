package LearnThread.kindsOfQueue.p_r_test;
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class P {
    private Object locker;

    public P (Object locker) {
        this.locker = locker;
    }

    public void setValue() {
        try {
            synchronized (locker) {
                if (!ValueObject.value.equals("")) {
                    locker.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set the value:" + value);
                ValueObject.value = value;
                locker.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
