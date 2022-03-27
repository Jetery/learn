import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           String string = sc.nextLine();
           StringBuilder stringBuilder = new StringBuilder();
           for (int i = 0; i < string.length(); i++){
               char c = string.charAt(i);
               if ('A' <= c && c <= 'z'){
                   stringBuilder.append(c);
               } else {
                   stringBuilder.append(" ");
               }
           }
           String[] strs = String.valueOf(stringBuilder).split(" ");
           for (int i = strs.length - 1; i >= 0; i--){
               if (i != 0){
                   System.out.print(strs[i] + " ");
               } else {
                   System.out.println(strs[0]);
               }
           }
       }
   }

}