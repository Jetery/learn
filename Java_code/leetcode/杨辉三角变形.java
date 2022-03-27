//   杨辉三角变形
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            //  找规律
            if (n <= 2){
                System.out.println(-1);
            } else {
                n -= 2;
                if (n % 4 == 1 || n % 4 == 3){
                    System.out.println(2);
                } else if (n % 4 == 2){
                    System.out.println(3);
                } else {
                    System.out.println(4);
                }
            }
            //  直接模拟会超时
//            int len = 2 * n + 1;
//            int[] arr = new int[len];
//            arr[n] = 1;
//            while (n-- > 1){
//                int[] temp = Arrays.copyOf(arr, arr.length);
//                for (int i = 1; i < len - 1; i++){
//                    arr[i] = temp[i - 1] + temp[i] + temp[i + 1];
//                }
//            }
//            int ans = -1;
//            for (int i = 1; i < len / 2; i++){
//                if (arr[i] % 2 == 0){
//                    ans = i;
//                    break;
//                }
//            }
//            System.out.println(ans);
        }
    }
}