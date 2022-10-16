import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.19
 */
class Person {
    // 字段 -> 成员变量 -> 属性
    // 定义在类的内部，方法的外部


    //          1. 普通成员变量
    // 成员变量
    //          2. 静态成员变量
    public String name;
    public int age;
    public String sex;


    //              1.普通成员方法
    //  方法 -> 函数
    //              2.静态成员方法
    public void eat() {
        System.out.println(name + " eat()");
    }

    //alt + fn + PrtSc(Ins)
    @Override   //注解:重写(确保重写方法名和被替代的的一样)
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    //如果类重新实现toString方法，会自动调用重写过的
}
public class Learn_20210419 {

    /**
     * 类与对象
     */
    public static void main(String[] args) {
        //匿名对象
        System.out.println(new Person());   //把对象变成字符串，为序列化
        new Person().age = 10;
        //当前对象只使用一次
    }

    public static void main7(String[] args) {
        Person p = new Person();
        Person p2 = p;
        //p2 引用了p指向的对象
        //      即为 堆 上的同一块区域
    }

    public static void main6(String[] args) {
        Person p = new Person();    //通过new来实例化
        p.name = "Jetery";  //引用不一定都在栈上，也可以在堆上
        p.age = 10;
        p.sex = "man";
        p.eat();
        System.out.println(p);
    }

    /**
     * 数组内容
     */
    public static void main5(String[] args) {
        //二维数组
        int[][] arr = {{1,2,3,4},
                {1,2},
                {3,4}
        };
        int[][] arr1 = new int[1][1];
        int[][] arr2 = new int[2][];    //不规则二维数组
        int[][] arr3 = new int[][] {{1},{2}};
        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========foreach=============");
        //foreach
        // 第一个参数为使用对象
        // 第二个参数为遍历对象
        for (int[] tmp : arr) {
            for (int x: tmp) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main4(String[] args) {
        int[] arr = new int[2];
        Arrays.fill(arr,666);
        System.out.println(Arrays.toString(arr));
        //Arrays.fill   也有四个参数的，用法类似（左闭右开）
    }

    public static void main3(String[] args) {
        //Arrays.equals
        //比较数组是否相同
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = new int[3];
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr2, arr3));
    }

    public static void main2(String[] args) {
        //Arrays.binarySearch参数：
        //1.  查找数组
        //2.3.  在[x,y)区间内查找
        //4.  查找目标
        int[] arr = new int[] {1,2,3,4,5,6,7};
        int ret = Arrays.binarySearch(arr, 2, 5, 4);
        System.out.println(ret);
        //如果查找不到，返回值为负数
    }

    public static void main1(String[] args) {
        //二分查找,前提是有序数组
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.binarySearch(arr, 3));
    }

}
