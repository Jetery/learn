package LearnThread.learnSingleton;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.10.09
 */

/*
public class SingletonLazy {
    private static  SingletonLazy instance = null;

    private SingletonLazy() { }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
*/
// todo :: 使懒汉模式线程安全
public class SingletonLazy {
    private volatile static SingletonLazy instance = null; // 保证变量可变性 且 防止代码重排序

    private SingletonLazy() { }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
