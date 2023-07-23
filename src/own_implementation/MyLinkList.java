package own_implementation;

public class MyLinkList {

    Node head;

    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(Object data) {
        Node newNode  = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        //making head to next of new node
        newNode.next=head;
        // making new node as head
        head=newNode;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next=newNode;
    }

    public void addAfterNode(Node node, Object data) {
        if(node == null) {
            return;
        }
        Node newNode = new Node(data);
        //making new node next to previous node next as it is coming between 2
        newNode.next=node.next;
        // making previous node next to new node as it is coming between 2
        node.next=newNode;
    }

    public void removeNode(Object data) {
        if(head == null) {
            return;
        }
        if(data.equals(head.data)){
            head = head.next;
            return;
        } 
        Node prev = head;
        Node next = head;
        while(next != null && !next.data.equals(data)) {
            prev=next;
            next=next.next;
        }
        if(next==null) {
            return;
        }
        prev.next=next.next;
    }

    public void removeNodeAt(int position) {
        if(position < 0 ){
            return;
        }
        //remove head
        if(position == 0) {
            head = head.next;
        }
        //get node and its previous
        Node prev=head;
        for(int i=0; prev != null && i<position-1;i++) {
            prev = head.next;
        }
        if(prev == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    public void reverse() {
        if(head == null) {
            return;    
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null) {
            next = current.next;
            // to reverse the list need to change current next to previous node
            //in case of head will go null
            current.next = prev;
            // set current node as prev for next iteration
            prev = current;
            // update current to next
            current = next;
        }
        head = prev;
    }

    public void swapNode(int n1, int n2) {
        if(head == null ) {
            return;
        }
        if(n1==n2) {
            return;
        }
        Node node1=head,node2=head,node1Prev=null,node2Prev=null;
        
        while(node1 != null && !node1.data.equals(n1)) {
            node1Prev=node1;
            node1 = node1.next;
        }

        while(node2 != null && !node2.data.equals(n2)) {
            node2Prev=node2;
            node2 = node2.next;
        }
        if(node1Prev != null) 
            node1Prev.next=node2;
        else
            head = node2;
        if(node2Prev != null)
            node2Prev.next=node1;
        else
            head = node1;
        Node temp = node2.next;
        node2.next = node1.next;
        node1.next= temp;

    }

    public void addingZeroBeforeHead(MyLinkList l1, MyLinkList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;
        while(n1 !=null && n2!= null) {
            n1=n1.next;
            n2=n2.next;
        }
        if(n1 == null && n2 !=null) {
            while(n2 !=null) {
                Node zeroNode = new Node(0);
                zeroNode.next=l1.head;
                l1.head = zeroNode;
                n2 = n2.next;
            }
        }
        if(n2 == null && n1 !=null) {
            System.out.println("in n2 null");
            while(n1 !=null) {
                Node zeroNode = new Node(0);
                zeroNode.next=l2.head;
                l2.head=zeroNode;
                n1 = n1.next;
            }
        }
    }

    

}
