import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enQueue(int x) {
        if(!stack1.isEmpty()) {
            //copy stack1 to stack2
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            //again copy stack2 to stack1
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }else {
            stack1.push(x);
        }
    }

    public int deQueue() {
        if(!stack1.empty()) {
            return stack1.pop();
        }else {
            return 0;
        }
    }

    public void enQueueSingleStack(int item) {
        stack1.push(item);
    }
    public int deQueueSingleStack(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return stack.pop();
        }
        int x = stack.pop();
        int res = deQueueSingleStack(stack);
        stack.push(x);
        return res;
    }
}
