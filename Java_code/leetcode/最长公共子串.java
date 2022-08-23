import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            //  make sure to let b is longest
            if (a.length() > b.length()){
                String temp = a;
                a = b;
                b = temp;
            }
            String ans = "";
            for (int i = 0; i < a.length(); i++){
                for (int j = i + 1; j <= a.length(); j++){
                    String sub = a.substring(i, j);
                    System.out.println(sub);
                    if (b.contains(sub)){
                        if (sub.length() > ans.length()){
                            ans = sub;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}


import java.util.Scanner;

public class Main {
    
    public static String solution(String s1, String s2) {
    
        if(s1 == null || s1 == null || 
           "".equals(s1) || "".equals(s2)) {
            return "";
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        
        // 最长公共子串的长度
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        
        // 找到最长公共子串
        String s;
        int k = Math.min(m, n);
        for(int i = 0; i <= k - max; i++) {
            if(k == m) {
                s = s1.substring(i, i + max);
                if(s2.contains(s)) {
                    return s;
                }   
            }else if(k == n) {
                s = s2.substring(i, i + max);
                if(s1.contains(s)) {
                    return s;
                }
            }
            
        }
        return "";   
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String result = solution(s1, s2);
            System.out.println(result);
        }
        sc.close();
    }
}
