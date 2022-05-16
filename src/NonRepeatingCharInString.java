import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class NonRepeatingCharInString {
    public static void main(String[] args) throws Exception {
        String str = "caabcegfpkt";
        char[] charArr = str.toCharArray();
        findFirstAndLastNonRepeatingChar(charArr);
    }

    private static void findFirstAndLastNonRepeatingChar(char[] charArr) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i < charArr.length;i++) {
            if(map.get(charArr[i]) !=null) {
                map.put(charArr[i], map.get(charArr[i])+1);
            }else {
                map.put(charArr[i], 1);
            }
        }
        String first="";
        String last="";
        for(Entry<Character,Integer> entry : map.entrySet()) {
            
            if(entry.getValue()==1 && first.equals("")) {
                first = entry.getKey()+"";
            }
            if(entry.getValue()==1) {
                last=entry.getKey()+"";
            }
        }
        System.out.println("first" + first);
        System.out.println("last" + last);
    }
}
