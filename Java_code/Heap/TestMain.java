/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.07.24
 */
public class TestMain {
    public static void main(String[] args) {
        int[] arr = new int[]{27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        TestHeap heap = new TestHeap();
        heap.createHeap(arr);
        heap.push(80);
        System.out.println(heap.pop());
        System.out.println(heap.peek());
        heap.heapSort();
        System.out.println("asdfasd");
    }
}
