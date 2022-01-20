import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           String before = sc.nextLine();
           String[] words = before.split("_");
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append(words[0]);
           for (int i = 1; i < words.length; i++){
               stringBuilder.append(words[i].replaceFirst(String.valueOf(words[i].charAt(0)), String.valueOf(words[i].charAt(0)).toUpperCase()));
           }
           System.out.println(stringBuilder);
       }
   }

}