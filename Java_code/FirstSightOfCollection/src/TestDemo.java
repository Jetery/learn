import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * 1. 类名后面有  <T>  :   代表这是一个泛型类, T为占位符
 * 2. new T[10];    不可以 new 泛型类型的数组
 *
 * 3. 泛型的意义:
 *            1.存储数据时 自动进行 类型检查
 *            2.获取数据时 自动进行 类型转换
 * 4. 泛型的参数不能是简单类型
 * 5. 泛型类型的参数，不参与类的组成
 *
 *
 * Question:
 *        泛型是如何编译的？
 *           1， 泛型只在编译期有作用(check and get)，运行时，没有泛型的概念
 *           2. 泛型的编译使用的是  擦除机制     <T>  -->  Object
 * User: Jetery
 * Date: 2021.05.30
 */

class A<T> {
    T value;
    A(T value) {
        this.value = value;
    }
    T get() {
        return value;
    }
}

public class TestDemo {

    public static void main(String[] args) {
        A<Integer> a = new A<>(1);
        System.out.println(a.get());

        A<String> a2 = new A<>("张天瑞");
        System.out.println(a2.get());
    }

    public static void main3(String[] args) {
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("bit");
        collection2.add("cake");
        System.out.println(collection2);
        func(collection2);
    }

    public static void func(Collection<? extends Object> list){
        System.out.println("hhh");
    }

    public static void main2(String[] args) {
        //考题
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);  // true
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);  // false
        //数字  [-128,127)  范围中(缓存数组)，直接返回，否则返回 new Integer(n);  即一个新对象
    }

    public static void main1(String[] args) {
        //< >中写包名
        Collection<Integer> collection = new ArrayList<>();
        collection.add(123);
        collection.add(111);
        collection.remove(123);
        System.out.println(collection);
        collection.add(222);
        /**
         * 返回装有所有集合元素的数组:
         *          集合名.toArray();
         *
         * 注意：不可以对数组进行整体强制类型转换（数组中的值不同）
         */
        Object[] arr = collection.toArray();
        System.out.println(Arrays.toString(arr));


        //不同类型存不同
        Collection<String> collection2 = new ArrayList<>();
        collection2.add("bit");
        collection2.add("cake");
        System.out.println(collection2);

    }
}
