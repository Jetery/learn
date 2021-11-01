//  可借瓶子
import java.util.*;
public class Main{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       while (sc.hasNext()){
           int bottle = sc.nextInt();
           int drink = bottle / 3;
           int left = drink + bottle % 3;
           while (left > 1){
               bottle = left;
               drink += bottle / 3;
               left = bottle / 3 + bottle % 3;
               // case to borrow the bottle (borrow one and break)
               if (left == 2){
                   drink++;
                   break;
               }
           }
           System.out.println(drink);
       }
   }
}