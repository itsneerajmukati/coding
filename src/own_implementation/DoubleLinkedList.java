package own_implementation;

public class DoubleLinkedList {

    public static void main(String[] args) throws Exception {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(4);
        doubleLinkedList.addFirst(6);
        doubleLinkedList.addFirst(10);
        doubleLinkedList.addFirst(12);
        doubleLinkedList.addFirst(7);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addFirst(2);
        sortBiotonic();
        Node node = head;
        while(node !=null) {
            System.out.println(node.data);
            node=node.next;
        }
    }
    
    static Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            this.data = d;
        }
    }

    public void addFirst(int data) {
        Node newNode  = new Node(data);
        if(head == null) {
            newNode.next=null;
            newNode.prev=null;
            head = newNode;
            return;
        }
        //making head to next of new node
        newNode.next=head;
        head.prev=newNode;
        // making new node as head
        head=newNode;
    }

    public static void sortBiotonic() {
        Node last = head;
        Node first = head;
        while(last.next != null) {
            last = last.next;
        }
        Node result = new Node(0);
        Node secondLast, front= result ;
        while(first!=null && last!=null && first != last) {
            if(first.data >= last.data) {
                //means data is smaller at last so need to add last node before first node
                //making second last next value to null
                secondLast = last.prev;
                secondLast.next = null;
                //make first previous as last
                first.prev = last;
                last.next= first;
                last.prev=null;
                //making second last as last
                front.next = last;
                front = front.next;
                last = secondLast;
                first = first.next;
            }else {
                front.next = first;
                front = front.next;
                first = first.next;
            }
        }
        head = result.next;
    }

}
