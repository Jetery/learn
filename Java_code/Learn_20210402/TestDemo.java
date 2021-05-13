/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.02
 */
public class TestDemo {

    public static void main(String[] args) {
        //出数组中只出现一次的数字，其它数字都出现了两次
        //进阶版本：出现了两次的数字为 2个
        int[] arr = new int[] { 1, 1, 3, 4, 8, 8 };
        int temp = 0;
        for(int i = 0;i<arr.length;i++)
            temp ^= arr[i];
        //get  3^4
        //divide into two groups
        int[] res = new int[2];
        temp &= -temp;    //得出两个数异或结果的最右边的一个1，其他的为零，这样进行&操作就可以将两个不同的数分到不同的两组去
        for(int i=0;i<arr.length;i++){
            if((temp&arr[i])==0)
                res[0] ^= arr[i];
            else
                res[1]^=arr[i];
        }
        for(int i=0;i<res.length;i++){
            System.out.printf("%d ",res[i]);
        }

    }


    public static void main1(String[] args) {
        //出数组中只出现一次的数字，其它数字都出现了两次
        //普通版本：出现了两次的数字为 1个
        int[] arr = new int[] { 1, 1, 3, 8, 8 };
        int temp = 0;
        for(int i = 0;i<arr.length;i++)
            temp ^= arr[i];
        System.out.println(temp);//结果为3
    }
}
