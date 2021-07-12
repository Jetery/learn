import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 求一个数组中前k个最小的数字
 * User: Jetery
 * Date: 2021.07.12
 */
public class FifthDay {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,6,0,2,5,4,2};
        System.out.println(Arrays.toString(minArray(arr, 5)));
    }

    public static int[] minArray (int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] ret = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(ret, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < ret[0]) {
                ret[0] = arr[i];
                heap(ret, 0, k);
            }
        }
        return ret;
    }

    private static void heapInsert(int[] heap, int value, int index) {
        heap[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] < heap[index]) {
                swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void heap(int[] heap, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (heap[left] > heap[index]) {
                largest = left;
            }
            if (right < heapSize && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(heap, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    private static void swap(int[] heap, int parent, int index) {
        int tmp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = tmp;
    }




    //worst way
    public static int[] minArray1 (int[] arr, int k) {
        //Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int[] ret = new int[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }
}
