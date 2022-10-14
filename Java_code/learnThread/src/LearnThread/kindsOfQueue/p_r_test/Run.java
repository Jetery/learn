package LearnThread.kindsOfQueue.p_r_test;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class Run {
    public static void main(String[] args) {
        Object locker = new Object();

        P p = new P(locker);
        C c = new C(locker);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);

        threadP.start();
        threadC.start();
    }
}
