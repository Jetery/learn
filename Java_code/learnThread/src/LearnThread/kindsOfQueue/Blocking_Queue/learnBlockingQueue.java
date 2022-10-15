package LearnThread.kindsOfQueue.Blocking_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
// java.util.concurrent --> JUC

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.12
 */
public class learnBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        // put 带有阻塞功能
        // offer 没有阻塞功能
//        queue.offer("hello");
        queue.put("hello");
        String elem = queue.take();
        System.out.println(elem);
        queue.take();
        // 代码会在 take() 阻塞
        System.out.println(elem);
    }
}
