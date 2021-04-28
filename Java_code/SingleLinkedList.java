/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.28
 */
public class SingleLinkedList {
    public ListNode head;

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印单链表所有值
    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
        listNode.next = this.head;
        this.head = listNode;
    }

    //尾插法
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        ListNode cur = this.head;
        if(cur == null) {
            this.head = listNode;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = listNode;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if (index < 0 || index > size()) {
            System.out.println("位置非法！！");
            return;
        }
        if (index == 0) {
            this.addFirst(data);
            return;
        }

        if (index == this.size()) {
            this.addLast(data);
            return;
        }

        ListNode listNode = new ListNode(data);
        ListNode cur = findIndexSubOne(index);
        listNode.next = cur.next;
        cur.next = listNode;
    }

    public ListNode findIndexSubOne(int index) {
        ListNode cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int findKey(int key) {
        int index = 0;
        ListNode cur = this.head;
        while (cur.val != key) {
            cur = cur.next;
            index++;
            if (cur == null) {
                return -1;
            }
        }
        return index;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        int index = findKey(key);
        if (-1 == index) {
            System.out.println("该数字不存在！！");
            return;
        }
        ListNode cur = this.head;
        if (0 == index) {
            this.head = cur.next;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        while (-1 != findKey(key)) {
            remove(key);
        }
    }

    //清空链表
    public void clear() {
        this.head = null;
    }

}
