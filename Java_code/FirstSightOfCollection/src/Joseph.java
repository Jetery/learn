import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.12
 */
public class Joseph {
    public int getResult(int n) {
        LinkedList<Integer> arr=new LinkedList<>();
        LinkedList<Integer> res=new LinkedList<>();
        for(int i = 1;i <= n;i++) {
            res.add(i);
        }
        int m = 2;
        while(true){
            if(arr.size()==0){
                if (change(arr, res, m)) return arr.pop();
            }else if(res.size() == 0){
                if (change(res, arr, m)) return res.pop();
        }
            m++;
        }
    }

    public boolean change(LinkedList<Integer> arr, LinkedList<Integer> res, int m) {
        for(int i = 0; i < res.size(); i++){
            if(i % m == 0) arr.add(res.get(i));
        }
        if(arr.size() == 1) return true;
        res.clear();
        arr.addFirst(arr.removeLast());
        return false;
    }
}