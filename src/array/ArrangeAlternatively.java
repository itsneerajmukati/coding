package array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrangeAlternatively {
    /**
     * Given a sorted array of positive integers.
     * Your task is to rearrange the array elements alternatively
     * i.e first element should be max value,
     * second should be min value, third should be second max,
     *  fourth should be second min and so on.
     * Note: Modify the original array itself.
     * Do it without using any extra space.
     *  You do not have to return anything.
     * Example 1: Input:n = 6 arr[] = {1,2,3,4,5,6} Output: 6 1 5 2 4 3
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};

        int n=7;
        rearrange(arr, n);
    }

    public static void rearrange(int A[], int N){
        int maxIndex = N-1;
        int minIndex = 0;
        int maxElement = A[maxIndex]+1;
        for(int i=0;i<N;i++) {
            if(i%2==0) {
                A[i]+=(A[maxIndex]%maxElement)*maxElement;
                maxIndex--;
            }else {
                A[i]+=(A[minIndex]%maxElement)*maxElement;
                minIndex++;
            }
        }
        for(int i = 0; i < N ; i++) {
            A[i] = A[i]/maxElement;
        }

        for(int i = 0; i < N ; i++) {
            System.out.println(A[i]);
        }

    }
}
