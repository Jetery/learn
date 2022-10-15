package LearnThread.kindsOfQueue.Blocking_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class p_r_model {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int elem = queue.take();
                        System.out.println("消费者: " + elem);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();

        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        queue.put(i + 1);
                        System.out.println("生产者: " + (i + 1));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        try {
            consumer.join();
            producer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
