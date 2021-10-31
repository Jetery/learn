/*

问题描述：
        在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
要求：
        实现如下2个通配符：
        *：
          匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
        ？：
          匹配1个字符

注意：
    匹配时不区分大小写。

输入：
通配符表达式；
一组字符串。

输出：
返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
注意：本题含有多组样例输入！ 

*/


//  此方法只能通过92%
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            boolean ans = true;
            String request = sc.nextLine();
            String target = sc.nextLine();
            char[] req = request.toLowerCase().toCharArray();
            char[] tar = target.toLowerCase().toCharArray();
            Stack<Character> r = new Stack<>();
            Stack<Character> t = new Stack<>();
            for (char c : req){
                r.push(c);
            }
            for (char c : tar){
                t.push(c);
            }
            while (!r.isEmpty() && !t.isEmpty()){
                char a = r.peek();
                char b = t.peek();
                if (a == b){
                    t.pop();
                    r.pop();
                } else if (a == '*'){
                    while ((b >= '0' && b <= '9') || (b >= 'a' && b <= 'z')){
                        t.pop();
                        if (t.isEmpty()){
                            break;
                        }
                        b = t.peek();
                        if (t.size() < r.size()){
                            break;
                        }
                    }
                    r.pop();
                } else if (a == '?'){
                    if ((b >= '0' && b <= '9') || (b >= 'a' && b <= 'z')){
                        t.pop();
                        r.pop();
                    } else {
                        ans = false;
                        break;
                    }
                } else {
                    ans = false;
                    break;
                }
            }
            if (!t.isEmpty()){
                ans = false;
            }
            System.out.println(ans);
        }
    }
}