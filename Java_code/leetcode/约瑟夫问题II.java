import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.12
 */
public class Joseph {
    public int getResult(int n) {

        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();

        for(int i = 1;i <= n;i++) {
            listA.add(i);
        }

        int m = 2;

        while(true) {
            if(listB.size()==0) {

                for(int i = 0; i < listA.size(); i++) {
                    if(i % m == 0) listB.add(listA.get(i));
                }
                if(listB.size() == 1) return listB.pop();
                listA.clear();
                listB.addFirst(listB.removeLast());

            } else if (listA.size() == 0) {

                for(int i = 0; i < listB.size(); i++) {
                    if(i % m == 0) listA.add(listB.get(i));
                }
                if(listA.size() == 1) return listA.pop();
                listB.clear();
                listA.addFirst(listA.removeLast());

            }

            m++;
            
        }
    }
}