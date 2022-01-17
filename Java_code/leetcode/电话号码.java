// 电话号码
import java.util.*;
public class Main{
   public static void main(String[] args){

       // preparations
       HashMap<Character, Integer> map = new HashMap<>();
       char a = 'A';
       int num = 2;
       for (int i = 0; i < 8; i++){
           if (i == 5 || i == 7) {
               for (int j = 0; j < 4; j++){
                   map.put(a, num);
                   a++;
               }
           } else {
               for (int j = 0; j < 3; j++){
                   map.put(a, num);
                   a++;
               }
           }
           num++;
       }

       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           String first = sc.nextLine();
           int n = Integer.parseInt(first);
           TreeSet<String> set = new TreeSet<>();
           int times = 0;
           while (times < n){
               StringBuilder stringBuilder = new StringBuilder();
               String str = sc.nextLine();
               for (int i = 0; i < str.length(); i++){

                   char c = str.charAt(i);
                   if (c == '-'){
                       continue;
                   } else if ('0' <= c && c <= '9'){
                       stringBuilder.append(c);
                   } else {
                       stringBuilder.append(map.get(c));
                   }
                   if (stringBuilder.length() == 3) {
                       stringBuilder.append('-');
                   }

               }

               set.add(String.valueOf(stringBuilder));
               times++;
           }
           
           List<String> list = new ArrayList<>(set);
           Collections.sort(list);
           for (String s : list) {
               System.out.println(s);
           }
           System.out.println();

       }
   }
}
