import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Netcracker {

//Design and implement algorithm to find most frequently occurring word(s) in given input.
//Example Input : "Neeraj is employee of ABC company, neeraj is from Pune, 'NEERAJ! is good in algorithms. Nee'raj, a strong technical expert"
//Expected output:
//Neeraj – 3
//is - 3
    public static void main(String[] args) {
        String input = "Neeraj is employee of ABC company, neeraj is from Pune, 'NEERAJ! is good in algorithms. Nee'raj, a strong technical expert";
        String stringarray[] = input.split(" ");
        Map<String,MyData> map = new LinkedHashMap<>();
        for(String s : stringarray) {
            String news = removeOtherChar(s);
            if(map.containsKey(news.toLowerCase())) {
                map.get(news.toLowerCase()).incrementCount();
                continue;
            }
            map.put(news.toLowerCase(), new MyData(news, 1));
        }
        //System.out.println(map);
        int max=0;
        for(Entry<String,MyData> entry: map.entrySet()) {
            if(entry.getValue().count > max) {
                max=entry.getValue().count;
            }
        }
        for(Entry<String,MyData> entry: map.entrySet()) {
            if(entry.getValue().count == max) {
                System.out.println(entry.getValue().name + ":" + entry.getValue().count);
            }
        }
    }
    static class MyData {
        String name;
        Integer count;
        MyData(String name, Integer count) {
            this.name= name;
            this.count=count;
        }
        public void incrementCount() {
            count++;
        }
        @Override
        public String toString() {
            return "MyData [name=" + name + ", count=" + count + "]";
        }
        
    }
    private static String removeOtherChar(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        for(;start<chars.length;start++) {
            if(!Character.isLetter(chars[start])) {
                continue;
            }
            break;
        }
        int end = chars.length-1;
        for(;end>0;end--) {
            if(!Character.isLetter(chars[end])) {
                continue;
            }
            break;
        }
        return s.substring(start, end+1);
    }
}
