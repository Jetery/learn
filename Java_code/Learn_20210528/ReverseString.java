/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.28
 */
import java.util.*;

public class Main {

    public static void reversSentence(char[] ch,int left,int right) {
        while (left < right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();
        if (str == null){
            return;
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        n %= len;
        reversSentence(chars,0,n - 1);
        reversSentence(chars,n,len - 1);
        reversSentence(chars,0,len - 1);
        String s = new String(chars);
        System.out.println(s);
    }
}