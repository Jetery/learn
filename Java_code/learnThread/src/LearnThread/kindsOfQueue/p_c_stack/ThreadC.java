package LearnThread.kindsOfQueue.p_c_stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class ThreadC extends Thread{
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }

}
