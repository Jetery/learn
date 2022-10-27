package LearnThread.homework;

/**
 * Created with IntelliJ IDEA
 * Description:
           有三个线程，线程名称分别为：a，b，c。
           每个线程打印自己的名称
           需要让他们同时启动，并按 c，b，a的顺序打印
 * User: JeffRay
 * Date: 2022.10.27
 */
public class PrintByOrder {
    private static class PrintRun implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintRun printRun = new PrintRun();
        Thread a = new Thread(printRun, "a");
        Thread b = new Thread(printRun, "b");
        Thread c = new Thread(printRun, "c");

        c.start();
        c.join();

        b.start();
        b.join();

        a.start();
        a.join();
    }
}
