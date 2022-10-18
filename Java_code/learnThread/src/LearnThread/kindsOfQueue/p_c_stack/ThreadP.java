package LearnThread.kindsOfQueue.p_c_stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.pushService();
        }
    }
}
