import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.03
 */
public class TheCollectionOfCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            StringBuilder str = new StringBuilder(sc.nextLine());
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(!ret.toString().contains(str.charAt(i) + "")){
                    ret.append(str.charAt(i));
                }
            }
            System.out.println(ret);
        }

    }
}
