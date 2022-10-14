package LearnThread.kindsOfQueue.p_c_allWait;

import LearnThread.kindsOfQueue.p_c_allWait.ThreadC;
import LearnThread.kindsOfQueue.p_c_allWait.ThreadP;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.13
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        P p = new P(locker);
        C c = new C(locker);
        ThreadP[] threadPS = new ThreadP[2];
        ThreadC[] threadCS = new ThreadC[2];

        for (int i = 0; i < 2; i++) {
            threadPS[i] = new ThreadP(p);
            threadPS[i].setName("生产者" + (i + 1));

            threadCS[i] = new ThreadC(c);
            threadCS[i].setName("消费者" + (i + 1));

            threadPS[i].start();
            threadCS[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);

        for (Thread elem : threads) {
            System.out.println(elem.getName() + " " + elem.getState());
        }

        /**
         * 不可保证 notify 唤醒的是异类
         * 如果 "生产者" 唤醒 "生产者"
         *     "消费者" 唤醒 "消费者"
         * 就会导致所有线程都进入 waiting 状态
         * 程序会呈现 "假死" 状态
         */
    }
}
