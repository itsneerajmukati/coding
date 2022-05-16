public class FindTarget {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[] {2,3,5,7,10,14};
        int target = 18;
        int result  = findNearTarget(arr, target);
        System.out.println(result);
        
    }

    private static int findNearTarget(int[] arr,int target) {
        //corner cases
        if(target < arr[0]) {
            return arr[0];
        }
        if(target > arr[arr.length-1]) {
            return arr[arr.length-1];
        }
        for(int i=0;i<arr.length-1; i++) {
            if(target==arr[i]) {
                return arr[i];
            }
            if(target < arr[i]) {
                return arr[i];
            }
            if(target > arr[i] && target < arr[i+1]) {
                if(target-arr[i] <= arr[i+1]-target)
                    return arr[i];
                else {
                    return arr[i+1];
                }
            }
        }
        return 0;
    }
    
}
