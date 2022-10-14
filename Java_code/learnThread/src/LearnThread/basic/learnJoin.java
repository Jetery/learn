package LearnThread.basic;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.03
 */

/*
* 有20个线程，需要同时启动。
* 每个线程按 0 - 19 的序号打印, 如第一个线程需要打印 0
* 请设计代码, 在main主线程中
* 等待所有子线程执行完后
* 再打印 ok
* */
public class learnJoin {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 20; i++){
            final int j = i;
            Thread t = new Thread(){
                @Override
                public void run() {
                    System.out.println(j);
                }
            };
            t.start();
            t.join();
        }
        System.out.println("ok");
    }
}
