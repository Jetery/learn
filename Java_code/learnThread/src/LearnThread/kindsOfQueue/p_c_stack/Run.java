package LearnThread.kindsOfQueue.p_c_stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class Run {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        ThreadP[] ps = new ThreadP[3];
        ThreadC[] cs = new ThreadC[3];
        for (int i = 0; i < 3; i++) {
            ps[i] = new ThreadP(new P(myStack));
            ps[i].start();
            cs[i] = new ThreadC(new C(myStack));
            cs[i].start();
        }
    }
}
