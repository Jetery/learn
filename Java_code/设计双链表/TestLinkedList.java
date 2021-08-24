/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.15
 */
public class TestLinkedList {
    public ListNode head = new ListNode(-1);
    public ListNode last;


    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if (this.head.next == null){
            this.last = node;
            this.head.next = node;
            node.pre = this.head;
            return;
        }
        node.next = this.head.next;
        this.head.next.pre = node;
        node.pre = this.head;
        this.head.next = node;
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head.next == null){
            this.head.next = node;
            node.pre = this.head;
            this.last = node;
            return;
        }
        this.last.next = node;
        node.pre = this.last;
        this.last = node;
    }

    // 任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()){
            return;
        }
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size()){
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = this.head.next;
        while (index > 0){
            cur = cur.next;
            index--;
        }
        node.next = cur;
        cur.pre.next = node;
        node.pre = cur.pre;
        cur.pre = node;
    }

    // 查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.val == key){
                cur.pre.next = cur.next;
                if(cur.next != null){
                    cur.next.pre = cur.pre;
                } else {
                    cur.pre = null;
                }
                return;
            }
            cur = cur.next;
        }
    }

    // 删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null){
            if(cur.val == key){
                cur.pre.next = cur.next;
                if(cur.next != null){
                    cur.next.pre = cur.pre;
                } else {
                    cur.pre = null;
                }
            }
            cur = cur.next;
        }

    }

    // 得到单链表的长度
    public int size(){
        ListNode cur = this.head.next;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 打印链表
    public void display(){
        ListNode cur = this.head.next;
        while (cur != null){
            System.out.print(cur.val +" ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 清空链表
    public void clear(){
        ListNode cur = this.head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.pre = null;
            cur.next = null;
            cur = temp;
        }
        this.last = null;
    }
}
