

public class MultipleClass {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        String str3 = "hello";
        String str4 = "hello";
        System.out.println(str1 == str2); //false
        System.out.println(str1.equals(str2)); //true
        System.out.println(str3 == str1);  //false
        System.out.println(str3 == str2); //false
        System.out.println(str3 == str4); //true
        System.out.println(str3.equals(str4)); //true

    }    
}



 class TestPojo {
    private String str;
    private Integer int1;
    public TestPojo() {
    }
    public TestPojo(String str, Integer int1) {
        this.str = str;
        this.int1 = int1;
    }
}
