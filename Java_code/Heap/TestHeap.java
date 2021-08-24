import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.07.24
 */
public class TestHeap {

    private int[] elem;
    private int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void heapSort(){
        int end = this.usedSize - 1;
        while (end > 0){
            int temp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] =temp;
            adjustDown(0, end--);
        }
    }

    public void adjustDown(int parent, int len){
        int child = parent * 2 + 1;
        while (child < len) {
            //确保child所指下标为最大
            if (child + 1 < len && this.elem[child] < this.elem[child + 1]) {
                child++;
            }
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = parent * 2 + 1;
            } else {
                //已经是大根堆，跳出循环
                break;
            }
        }
    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap Is Null!");
        }
        return this.elem[0];
    }

    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("Heap Is Null!");
        }
        int temp = this.elem[0];
        this.elem[0] = this.elem[usedSize - 1];
        this.elem[usedSize - 1] = temp;
        adjustDown(0, --this.usedSize);
        return temp;
    }

    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize++] = val;
        adjustUp(usedSize - 1);
    }

    public void createHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
        // i 是每次调整的父亲节点
        for (int i = (arr.length -1 -1) / 2; i >= 0; i--) {
            adjustDown(i, this.usedSize);
        }
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    public boolean isFull(){
        return this.elem.length == usedSize;
    }
}
