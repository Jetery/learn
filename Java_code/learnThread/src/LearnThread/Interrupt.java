package LearnThread;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.12
 */

class TestThread extends Thread {
    int n;
    public TestThread(int n) {
        this.n = n;
    }
    public TestThread() {}
    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("i = " + (i + 1));
        }
        /** 如何停止线程就不再运行后面的代码
         * try {
         *             for (int i = 0; i < n; i++) {
         *                 if (this.interrupted()) {
         *                     System.out.println("thread is stopped, exit now!");
         *                     throw new InterruptedException();
         *                 }
         *                 System.out.println("i = " + (i + 1));
         *             }
         *         } catch (InterruptedException e) {
         *             e.printStackTrace();
         *         }
         */
    }

}
public class Interrupt {

    public static void main(String[] args) {
        try {
            TestThread thread = new TestThread(100000);
            thread.start();
            Thread.sleep(100);
            /**
             *  thread.interrupted() 指的是当前 main 线程
             *  main 是没有中断过的, 所以一直为 false
             *
             *  interrupted() 测试的是__当前线程__
             */
//            thread.interrupt();
//            System.out.println("是否停止 1?" + thread.interrupted());
//            System.out.println("是否停止 2?" + thread.interrupted());
            Thread.currentThread().interrupt();
            // 将输出保存到txt文件中去查找
            System.out.println("是否停止 1? = " + Thread.interrupted());
            System.out.println("是否停止 2? = " + Thread.interrupted());
            /**
             * interrupted 是静态 static 方法
             * 具有清除标志值的效果
             */
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
