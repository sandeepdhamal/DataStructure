package linklist;

public class LinkedList {

    private static Node head = null;

    public void insertAtBeginning(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;

            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void insertAtEnd(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;


    }
    public void insertAtPosition(int item,int position) {

        if (position<0){
            System.out.println("Invalid Position!");
            return;
        }

        Node newNode = new Node(item);
        if (position==0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp=head;

        int index =0;

        while (temp.next!=null){

            temp=temp.next;
            index++;

            if (index==position-1){

                break;
            }
        }

        newNode.next=temp.next;
        temp.next=newNode;
    }

    // Depends on the length of the list.
    // O(n)
    public void printData() {
        if (head == null) {
            System.out.println("LinkedList is empty!");
            return;
        }

        Node temp = head;
        while (temp != null) {

            if (temp.next == null) System.out.print(temp.data);
            else System.out.print(temp.data + " => ");

            temp = temp.next;
        }
        System.out.println();

    }
}
