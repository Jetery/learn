/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.22
 */

class Chinese {
    private String name;
    private String sex;
    private int age;
    public static int count;
    public final double pai = 3.14;

    public static void func() {
        System.out.println(count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public void life() {
        System.out.println("吃饭、睡觉、打豆豆");
    }

    Chinese() {
        this.life();
    }

}

class Person{
    String name;
    int age;
    Person() {
        System.out.println("调用构造方法Person()！！");
    }
    Person(String name,int age) {
        this();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Tset {
    {
        System.out.println("调用实例代码块");
    }

    static {
        System.out.println("调用静态代码块");
    }

    Tset() {
        System.out.println("调用构造方法");
    }


}

 public class Learning {

     public static void main(String[] args) {
         Tset test = new Tset();
         System.out.println("=============");
         Tset test2 = new Tset();
     }

     public static void main6(String[] args) {
         Chinese chinese = new Chinese();
     }

     public static void main5(String[] args) {
         Person person1 = new Person("ZTR",21);
         System.out.println(person1);
     }

     public static void main4(String[] args) {
         Chinese p = new Chinese();
         p.setName("xiaoming");
         p.setAge(10);
         p.setSex("man");
         System.out.println(p);
         System.out.println(p.getName());
     }

     public static void main3(String[] args) {
         //final不可更改
         Chinese p = new Chinese();
         System.out.println(p.pai);
     }

     public static void main2(String[] args) {
         //Chinese.func();
         //普通方法却可以使用静态的成员与方法
         Chinese p = new Chinese();
         p.life();
     }

     public static void main1(String[] args) {
         Chinese p1 = new Chinese();
         Chinese.count++;
         System.out.println(Chinese.count);
         Chinese p2 = new Chinese();
         Chinese.count++;
         System.out.println(Chinese.count);
         Chinese.count++;
         System.out.println(Chinese.count);
     }

    public static void main0(String[] args) {
        Chinese p = null;
        System.out.println(Chinese.count);
        System.out.println(Chinese.count);
    }
}

