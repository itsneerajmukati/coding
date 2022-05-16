import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root;

    public BinaryTree() { 
        root = null;
    }

    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    void printCurrentLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    public void printLevelOrderQueue() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();
            System.out.print(temp.data+ " ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);

        }
    }
    public void inOrderTraversal(Node node) {
        if(node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data+ " ");
            inOrderTraversal(node.right);
        }
    }
    public void preOrderTraversal(Node node) {
        if(node != null) {
            System.out.print(node.data+ " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(Node node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data+ " ");
        }
    }

    public void inOrderTraversalUsingStack(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current != null || stack.size() > 0) {
            while(current != null) {
                stack.add(node);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
   

    }

    void buildTreeUsingArrayIndexes() {
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        Map<Integer,Integer[]> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.get(parent[i])!=null) {
                Integer[] arr = map.get(parent[i]);
                arr[1]=i;
                map.put(parent[i], arr);
            }else {
                map.put(parent[i], new Integer[]{i,null});
            }
        }
        root = new Node(map.get(-1)[0]);
        child(root,map.get(root.data),map);
        inOrderTraversal(root);
        
    }
    void child(Node node, Integer[] data, Map<Integer,Integer[]> map) {
        if(data == null) {
            return;
        }
        if(data[0] != null) {
            node.left = new Node(data[0]);
            child(node.left, map.get(node.left.data),map);
        }
        if(data[1] != null) {
            node.right = new Node(data[1]);
            child(node.right, map.get(node.right.data),map);
        }
    }
    

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
       tree.buildTreeUsingArrayIndexes();
    }
}
class Node {
    int data;
    Node left, right;
    
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
