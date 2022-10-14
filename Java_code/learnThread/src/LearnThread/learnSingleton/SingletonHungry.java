package LearnThread.learnSingleton;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.11
 */
public class SingletonHungry {
    private static final SingletonHungry instance = new SingletonHungry();

    // 防止在类外调用构造方法,使得调用者
    private SingletonHungry(){ }

    public static SingletonHungry getInstance(){
        return instance;
    }

}
