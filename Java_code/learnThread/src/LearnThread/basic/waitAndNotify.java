package LearnThread.basic;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.10.09
 */
public class waitAndNotify {

    static class WaitTask implements Runnable {
        private Object locker = null;

        public WaitTask(Object loader) {
            this.locker = loader;
        }

        @Override
        public void run() {
            // todo :: 进行 wait 的线程
            synchronized (locker) {
                System.out.println("wait 开始");
                /**
                 * 直接调用 wait, 相当于this.wait(), 是针对 WaitTask 对象的
                 * 但是在 NotifyTask 中, 需要对 WaitTask 的对象进行通知
                 * 但是在 NotifyTask 中, 不容易获得 WaitTask 实例
                 *   故通过 locker 使 Wait 和 Notify 获得同一个 locker 对象
                 *   都 针对 locker 来加锁和解锁
                 */
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wait 结束");
            }
        }
    }

    static class NotifyTask implements Runnable {
        private Object locker = null;

        public NotifyTask(Object locker) {
            this.locker = locker;
        }

        @Override
        public void run() {
            // todo :: 进行 notify 的线程
            synchronized (locker) {
                System.out.println("notify 开始");
                locker.notify();
                System.out.println("notify 结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Object locker = new Object();
        Thread t1 = new Thread(new WaitTask(locker));
        Thread t2 = new Thread(new NotifyTask(locker));
        t1.start();
        Thread.sleep(3000);
        t2.start();
    }
}
