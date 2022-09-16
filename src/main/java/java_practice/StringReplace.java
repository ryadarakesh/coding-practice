package java_practice;

public class StringReplace {
    public static void main(String[] args) {
        String s = "abc.def.abc";
        System.out.println(s.replaceAll("\\.", "_"));
    }
}
