package LearnThread.kindsOfQueue.p_c_stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class C {
    private MyStack stack;

    public C(MyStack stack) {
        this.stack = stack;
    }

    public void popService() {
        System.out.println(stack.pop());
    }
}
