package LearnThread.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.27
 */
public class MyThreadPool {
    static class Worker extends Thread {
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class ThreadPool {
        //  queue 来描述任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //  list 来存放工作线程
        private List<Thread> list = new ArrayList<>();
        //  最大线程数
        private static final int MAX_SIZE = 10;

        public void submit(Runnable command) throws InterruptedException {
            if (list.size() < MAX_SIZE) {
                Worker worker = new Worker(queue);
                worker.start();
                list.add(worker);
            }
            queue.put(command);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

}
