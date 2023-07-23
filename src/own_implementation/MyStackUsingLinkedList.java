package own_implementation;

public class MyStackUsingLinkedList {
    StackNode root;
    static class StackNode {
        int data;
        StackNode next;

        public StackNode(int d) {
            this.data=d;
            this.next = null;
        }
    }

    public boolean push(int data) {
        StackNode newNode = new StackNode(data);
        if(root == null) {
            root = newNode;
            return true;
        } else {
            StackNode temp = root;
            root = newNode;
            newNode.next=temp;
            return true;
        }
    }

    public int pop() {
        if(root == null) {
            return 0;
        }
        int d = root.data;
        root = root.next;
        return d;
    }

    public int peek() {
        if(root == null) {
            return 0;
        }
        int d = root.data;
        return d;
    }

    public void print() {
        StackNode temp = root;
        while(temp !=null ) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
