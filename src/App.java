
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



public class App {

    public static void main(String[] args) throws InterruptedException  {
        
        
        String s = "abc";
        permute(s, "");
    }

    static void permute(String s , String answer)
        {  System.out.print(answer + "  ");
        if (s.length() == 0)
        {
            return;
        }
     
    for(int i = 0 ;i < s.length(); i++)
    {
        System.out.println(i+"i");
        char ch = s.charAt(i);
        String left_substr = s.substring(0, i);
        
        String right_substr = s.substring(i + 1);
        String rest = left_substr + right_substr;
        System.out.println("rest"+rest);
        permute(rest, answer + ch);
    }
}

    
   
    public static void printArray(int[] arr) {
        for(int pointer=0;pointer<arr.length;pointer++) {
            System.out.println(arr[pointer]);
        }
    }

    public static void reverseStack() {
        Stack<Integer> s =  new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.empty()) {
            return;
        }
        int item = s.pop();
        reverseStack(s);
        s.push(item);
    }

    public static void generateNumber() {
        Queue<String> queue = new LinkedList<>();
        List<String> numberList = new ArrayList<>(); 
        queue.add("1");
        for(int i=10;i>0;i--) {
            String s1 = queue.peek();
            queue.remove();
            String s2 = s1;
            numberList.add(s1);
            queue.add(s1+"0");
            queue.add(s2+"1");
        }
        numberList.forEach(n-> {System.out.println(n);});
    }
  
}
