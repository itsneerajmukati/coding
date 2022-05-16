
public class CountGreaterNumberRight {

    public static void main(String[] args) {
        int arr[] =  new int[]{3, 4, 2, 7, 5, 8, 10, 6};
        int q=2;
        int len = arr.length;
        int result[]= new int[len];
       
       
        result[len-1]=0;
        for(int i=len-2;i>=0;i--) {
            if(arr[i]>q) {
                result[i]=result[i+1]+1;
            }else {
                result[i]=result[i+1];
            }
        }
        System.out.println(result[3]);
        System.out.println(result[6]);
        System.out.println(result[1]);
    }
    
}
