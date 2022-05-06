/**
 * Created with IntelliJ IDEA.
 * Description
 * User: chen
 * Date: 2022 -03 -12
 * Time: 17:41
 */
public class TestDemo {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addFirst(5);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(1);
        doubleLinkedList.display();

        doubleLinkedList.addIndex(0,0);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(6,80);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(1,50);
        doubleLinkedList.display();
        /*
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);
        doubleLinkedList.addLast(6);
        doubleLinkedList.display();
        doubleLinkedList.removeAllKey(6);
        doubleLinkedList.display();
         */
        /*
        doubleLinkedList.remove(1);
        doubleLinkedList.display();
        doubleLinkedList.remove(6);
        doubleLinkedList.display();
        doubleLinkedList.remove(3);
        doubleLinkedList.display();
        doubleLinkedList.remove(35);
        doubleLinkedList.display();
         */
    }

    public static void main3(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(1);
        //System.out.println(myLinkedList.chkPalindrome());
    }

    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.display();

        myLinkedList.addLast(0);
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.display();

        System.out.println(myLinkedList.contains(99));

        myLinkedList.addIndex(0,100);
        myLinkedList.addIndex(3,99);
        myLinkedList.addIndex(7,88);
        myLinkedList.addIndex(17,88);
        myLinkedList.display();

        myLinkedList.remove(2);
        myLinkedList.remove(0);
        myLinkedList.remove(88);
        myLinkedList.remove(199);
        myLinkedList.display();

        myLinkedList.removeAllKey(1);
        myLinkedList.display();

        myLinkedList.clear();
        System.out.println("djxasncijn");
        myLinkedList.display();

    }

    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.remove(4);
        myArrayList.add(0, 1);
        myArrayList.add(1, 2);
        myArrayList.add(2, 3);
        myArrayList.add(3, 4);
        myArrayList.add(4, 5);
        myArrayList.add(5, 6);
        myArrayList.display();

        System.out.println(myArrayList.contains(2));
        System.out.println(myArrayList.search(5));
        System.out.println(myArrayList.getPos(4));

        myArrayList.setPos(2, 123);
        myArrayList.display();
        myArrayList.remove(4);
        myArrayList.display();
    }
}
