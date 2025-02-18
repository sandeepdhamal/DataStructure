package linklist;

public class LinkListTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtBeginning(3);
        list.insertAtBeginning(4);
        list.insertAtEnd(6);
        //list.insertAtEnd(9);
        list.printData();
     list.insertAtPosition(19,2);
        list.printData();
//        list.insertAtBeginning(12);
//        list.insertAtPosition(192,0);
//        list.printData();
    }
}
