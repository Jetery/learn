package LearnThread;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.09.29
 */
public class firstSightOfJoin {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < 5) {
                    System.out.println("thread is running");
                    count++;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // run the thread
        t.start();

        try {
            //暂停七秒是为了: 确保 t 被唤醒时, t 已经执行完毕
            //Thread.sleep(7000);
            System.out.println("join start");
            t.join();  //如果 t 没有执行完, 就会组赛等待
            System.out.println("join end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 1. join() 无参数 : 一直等, 死等, 十分危险
     * 2. join(一个参数) : 参数为 最大等到时间
     */
}
