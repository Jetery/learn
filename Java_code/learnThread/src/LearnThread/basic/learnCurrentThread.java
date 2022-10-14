package LearnThread.basic;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.09.30
 */
public class learnCurrentThread {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                System.out.println(this.getId()); // 和上一句一样 只限于使用继承 Thread 并且重写run方法
            }
        };
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                // System.out.println(this.getId());
                // 这里无法编译 , 因为 this 指向的是Runnable实例, 所以没有getId()方法
            }
        });
        t2.start();
    }
    // this 指向谁, 区分好
    // 简言之, currentThread() 比 this要稳健
}
