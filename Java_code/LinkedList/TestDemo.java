/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.15
 */
public class TestDemo {
    public static void main(String[] args) {
        TestLinkedList linkedList = new TestLinkedList();
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addLast(5);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(6);
        linkedList.addLast(8);
        linkedList.addLast(9);
        linkedList.addFirst(3);
        linkedList.display();
        linkedList.addIndex(0,1);
        linkedList.addIndex(9,90);
        linkedList.addIndex(9,3);
        linkedList.addIndex(5,50);
        linkedList.display();
        linkedList.addLast(3);
        linkedList.remove(9);
        linkedList.removeAllKey(3);
        linkedList.display();
        linkedList.clear();
        System.out.println("==============");
        linkedList.display();

    }
}
