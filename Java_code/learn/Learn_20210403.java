/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.03
 */
public class Learn_20210403 {

    public static void main(String[] args) {
        //打印 1 - 100 之间所有的素数
        System.out.print("1 "+"2 ");
        for (int i = 3; i < 101; i+=2) {
            //排除偶数
            boolean flag = true;
            for (int j = 3; j <= Math.sqrt(i); j+=2) {
                //缩小被除数范围
                if (i % j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.printf("%d ",i);
            }
        }
    }

    public static void main2(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        for (int i = 1000; i <=2000 ; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)
                System.out.printf("%d ",i);
        }
    }

    public static void main1(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 10 == 9)
                count++;
            if (i / 10 == 9)
                count++;
        }
        System.out.println(count);
    }
}
