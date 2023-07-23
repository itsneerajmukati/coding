package string;

public class MinimumWindowString {

    public static void main(String[] args) throws Exception {
        String pattern = "tist";
        String str = "this is a test string";
        minimumWindow(pattern,str);
    }

    private static void minimumWindow(String pattern, String str) {
        int map[] = new int[256];
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        for(int i=0;i<pattern.length();i++) {
            // increase count for each unique character
            if (map[pattern.charAt(i)] == 0)
                count++;
            map[pattern.charAt(i)]++;
        }
        // References of Window
        int i = 0;
        int j = 0;

        // Traversing the window
        while (j < str.length()) {
            map[str.charAt(j)]--;
            System.out.println("j:"+j + " " + "char:"+str.charAt(j));
            //if value come to zero means pattern charater found in str,
            // if new character in str then value will be negative
            if (map[str.charAt(j)] == 0)
                count--;
            // count reached to zero means windows found
            if (count == 0) {
                System.out.println("end:"+j + " " + "start:"+i);
               while(count == 0) {
                   if(ans > j-i+1) {
                       ans = Math.min(ans,j-i+1);
                       start = i;
                       System.out.println("ans:"+ans + "i:"+i);
                   }
                   map[str.charAt(i)]++;
                   if(map[str.charAt(i)]>0) {
                    System.out.println("pattern character found in string again: " + str.charAt(i) +":"+map[str.charAt(i)]);   
                    count++;
                   }
                   i++;
               }
            }
            j++;
        }
        if (ans != Integer.MAX_VALUE)
          System.out.println(String.valueOf(str).substring(start, ans+start));   

    }
    
}
