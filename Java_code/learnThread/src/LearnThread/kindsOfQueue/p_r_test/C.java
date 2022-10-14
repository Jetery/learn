package LearnThread.kindsOfQueue.p_r_test;

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
                if (ValueObject.value.equals("")) {
                    locker.wait();
                }
                System.out.println("get the value:" + ValueObject.value);
                ValueObject.value = "";
                locker.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
