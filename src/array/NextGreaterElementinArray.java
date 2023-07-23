package array;

import java.util.Stack;

public class NextGreaterElementinArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 7, 5, 8, 10, 6};
        int[] greater = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        greater[arr.length-1]=-1;
        for(int i=arr.length-1;i>=0;i--){
            while (!s.empty() && s.peek() <= arr[i]) {
                s.pop();
            }
            greater[i]=s.empty()?-1:s.peek();
            s.push(arr[i]);
        }
        System.out.println(greater[1]);
        //App.printArray(greater);
    }


    
}
