package LearnThread;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: JeffRay
 * Date: 2022.10.12
 */
public class IsInterrupted {
    public static void main(String[] args) throws InterruptedException{
        TestThread thread = new TestThread(10_0000);
        thread.start();
        Thread.sleep(300);
        thread.interrupt();
        // 将输出保存到txt文件中去查找
        System.out.println("是否停止 1? = " + thread.isInterrupted());
        System.out.println("是否停止 2? = " + thread.isInterrupted());


        /**
         * isInterrupted 是普通方法
         * 作用于__调用这个方法的对象__
         * 不会清除标志值
         */
    }
}
