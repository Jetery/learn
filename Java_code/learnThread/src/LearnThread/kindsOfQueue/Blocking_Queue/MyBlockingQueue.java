package LearnThread.kindsOfQueue.Blocking_Queue;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.14
 */
public class MyBlockingQueue {

    int[] arr = new int[1000];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    Object locker = new Object();

    public void put(int val) throws InterruptedException {
        synchronized (locker) {
            while (this.isFull()) {
                locker.wait();
            }
            arr[tail++] = val;
            tail %= arr.length;
            size++;
            locker.notify();
        }
    }

    public int take() throws InterruptedException {
        synchronized (locker) {
            while (this.isEmpty()) {
                locker.wait();
            }
            int ret = arr[head++];
            head %= arr.length;
            size--;
            locker.notify();
            return ret;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == arr.length;
    }


    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread p = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        queue.put(i + 1);
                        System.out.println("生产者: " + (i + 1));
                        i++;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        p.start();

        Thread c = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("消费者: " + queue.take());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        c.start();

        p.join();
        c.join();

    }

}
