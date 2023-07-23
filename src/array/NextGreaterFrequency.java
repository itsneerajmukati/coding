package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFrequency {
    
    public static void main(String[] args) {
        int arr[] =  new int[]{1, 1, 2, 3, 4, 2, 1};
        int len = arr.length;
        int result[]= new int[len];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], (map.get(arr[i])+1));
            }else {
                map.put(arr[i], 1);
            }
        }
        System.out.println(map.toString());
        for(int i=len-1;i>=0;i--) {
            while(!stack.isEmpty() && map.get(arr[i])>=map.get(stack.peek())) {
                stack.pop();
            }
            result[i]= stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        App.printArray(result);
        
    }

}
