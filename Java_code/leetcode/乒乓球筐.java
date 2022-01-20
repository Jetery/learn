/*

nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？

输入描述:
	输入有多组数据。

	每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，

	每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。

	字符串长度不大于10000。


输出描述:
	每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
示例1
	输入
		ABCDFYE CDE
		ABCDGEAS CDECDE
	输出
		Yes
		No

*/

import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           String A = sc.next();
           String B = sc.next();
           char[] a = A.toCharArray();
           HashMap<Character, Integer> aMap = new HashMap<>();
           for (char e : a){
               aMap.put(e, aMap.getOrDefault(e, 0) + 1);
           }
           char[] b = B.toCharArray();
           HashMap<Character, Integer> bMap = new HashMap<>();
           boolean flag = false;
           for (char e : b){
               if (!aMap.containsKey(e)){
                   System.out.println("No");
                   flag = true;
                   break;
               }
               bMap.put(e, bMap.getOrDefault(e, 0) + 1);
           }
           if (flag) continue;
           for (char e : bMap.keySet()){
               if (aMap.get(e) < bMap.get(e)){
                   System.out.println("No");
                   flag = true;
                   break;
               }
           }
           if (flag) continue;
           System.out.println("Yes");
       }
   }
}