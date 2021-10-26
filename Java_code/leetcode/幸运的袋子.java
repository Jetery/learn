/*

一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。

如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。

例如如果袋子里面的球的号码是{1, 1, 2, 3}, 这个袋子就是幸运的，因为1 + 1 + 2 + 3 >  1 * 1 * 2 * 3

你可以适当从袋子里移除一些球(可以移除0个, 但是别移除完) 要使移除后的袋子是幸运的。

现在让你编程计算一下 你可以获得的多少种不同的幸运的袋子。

*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int ans = dfs(arr, 0, 0, 1);
            System.out.println(ans);
        }
    }
    private static int dfs(int[] arr, int index, long sum, long mul){
        int cnt = 0;
        for (int i = index; i < arr.length; i++){
            sum += arr[i];
            mul *= arr[i];
            if (sum > mul){
                cnt += 1 + dfs(arr, i+1, sum, mul);
            } else if (arr[i] == 1){
                cnt += dfs(arr, i+1, sum, mul);
            } else {
                break;
            }
            sum -= arr[i];
            mul /= arr[i];
            while (i + 1 < arr.length && arr[i] == arr[i+1]){
                i++;
            }
        }
        return cnt;
    }
}





