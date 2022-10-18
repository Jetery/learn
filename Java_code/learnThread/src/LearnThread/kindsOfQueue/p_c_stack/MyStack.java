package LearnThread.kindsOfQueue.p_c_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.17
 */
public class MyStack {
    private final List<String> list = new ArrayList<>();

    synchronized public void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyNumber = " + Math.random());
            System.out.println("push ::" + list.size());
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop() {
        String ret = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop action :: " + Thread.currentThread().getName() + " is waiting");
                this.wait();
            }
            ret = list.get(0);
            list.remove(0);
            System.out.println("pop :: " + list.size());
            this.notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
