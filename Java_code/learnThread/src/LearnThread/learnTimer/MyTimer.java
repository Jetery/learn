package LearnThread.learnTimer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.15
 */
public class MyTimer {

    private static class Task implements Comparable<Task> {
        // task 为需要执行的任务
        private final Runnable command;
        // time 为传入的时间差, 当前时间 + 时间差 = 执行任务的时间
        private final long time;

        public Task(Runnable command, long time) {
            this.command = command;
            this.time = System.currentTimeMillis() + time;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int)(this.time - o.time);
        }
    }

    private static class Timer {
        private final Object locker = new Object();
        BlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        public void schedule (Runnable command, long time) throws InterruptedException {
            Task task = new Task(command, time);
            queue.put(task);
            synchronized (locker) {
                locker.notify();
            }
        }

        public Timer() {
            Thread scan = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Task task = queue.take();
                            long cur = System.currentTimeMillis();
                            if (task.time > cur) {
                                queue.put(task);
                                synchronized(locker) {
                                    locker.wait(task.time - cur);
                                }
                            } else {
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
            };
            scan.start();
        }

        public static void main(String[] args) throws InterruptedException {
            Timer timer = new Timer();
            timer.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("3000");
                }
            }, 3000);
            timer.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("1000");
                }
            }, 1000);
        }
    }
}
