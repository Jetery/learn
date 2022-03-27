/*

https://www.nowcoder.com/questionTerminal/f72adfe389b84da7a4986bde2a886ec3

求字典序在 s1 和 s2 之间的，长度在 len1 到 len2 的字符串的个数，结果 mod 1000007

输入描述:
	每组数据包涵s1（长度小于50），s2（长度小于50），len1（小于50），len2（大于len1，小于50）


示例1
	输入
		ab ce 1 2
	输出
		56

*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            long countA = help(chars1, chars1.length, len1, len2);
            long countB = help(chars2, chars2.length, len1, len2);
            long ans = (countA - countB - 1) % 1000007;
            System.out.println(ans);
        }
    }

    private static long help(char[] chars, int strLen, int len1, int len2){
        long count = 0;
        for (int len = len1; len <= len2; len++){
            for (int i = 0; i < strLen && i < len; i++){
                count += (26 - (chars[i] - 'a' + 1) * (long)Math.pow(26, len - i - 1));
            }
            if (len > strLen){
                count += Math.pow(26, len - strLen);
            }
        }
        return count;
    }
}