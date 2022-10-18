package LearnThread.kindsOfQueue.p_c_stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class P {
    private MyStack stack;

    public P(MyStack stack) {
        this.stack = stack;
    }

    public void pushService() {
        stack.push();
    }
}
