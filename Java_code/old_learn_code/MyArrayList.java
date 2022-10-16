import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.25
 */
public class MyArrayList {
    private int[] elem;
    private int usedSize;

    public int[] getElem() {
        return elem;
    }

    public void setElem(int[] elem) {
        this.elem = elem;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }


    // 创建五个空位
    public MyArrayList() {
        this.elem = new int[5];
    }

    // 判断满了没有
    private boolean isFull(int pos) {
        return this.elem.length == pos;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull(pos)) {
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        if (pos < 0 || pos > usedSize) {
            System.out.println("添加位置错误！！");
        } else {
            for (int i = this.usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            elem[pos] = data;
            usedSize++;
        }
    }


    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) return true;
        }
        return false;
    }


    // 查找某个元素对应的位置
    public int search(int toFind) {
        if (toFind > 0 && toFind < this.usedSize) {
            for (int i = 0; i < usedSize; i++) {
                if (toFind == this.elem[i]) return i;
            }
        }
        return -1;
    }


    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (pos > 0 && pos < this.usedSize) return this.elem[pos];
        return -1;
    }


    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        this.elem[pos] = value;
    }


    //删除第一次出现的关键字key
    public void remove(int key) {
        int index = this.search(key);
        if (index == -1) {
            System.out.println("没有找到这个数字！！");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }


    // 获取顺序表长度
    public int size() {
        return usedSize;
    }


    // 清空顺序表
    public void clear() {
        usedSize = 0;
    }

}
