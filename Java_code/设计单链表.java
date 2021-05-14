/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.14
 */
class MyLinkedList {

    private class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        if(index >= this.size || index < 0)
            return -1;
        Node cur = head;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node temp = new Node(val, this.head);
        this.head = temp;
        this.size++;
    }

    public void addAtTail(int val) {
        if(this.size == 0){
            head = new Node(val);
        } else {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > this.size){
            return;
        }
        if(index <= 0){
            addAtHead(val);
        } else {
            Node cur = head;
            for(int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node newNode = new Node(val, cur.next);
            cur.next = newNode;
            this.size++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index >= this.size || index < 0){
            return;
        }
        if(index == 0){
            head = head.next;
        } else {
            Node cur = head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        this.size--;
    }
}
