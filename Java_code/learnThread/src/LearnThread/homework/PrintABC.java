package LearnThread.homework;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.11`
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread all = new Thread(() -> {
                try {
                    Thread a = new Thread(() -> System.out.print("A"));
                    a.start();
                    a.join();
                    Thread b = new Thread(() -> System.out.print("B"));
                    b.start();
                    b.join();
                    Thread c = new Thread(() -> System.out.println("C"));
                    c.start();
                    c.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            all.start();
            all.join();
        }
    }
}
