package leetcode;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -42"));
        System.out.println(myAtoi(" +42 "));
    }
    public static int myAtoi(String s) {
        s= s.trim();
        char op=' ';
        if (s.startsWith("+") || s.startsWith("-")) {
            op = s.charAt(0);
            s = s.substring(1);
        }
        double num=0;
        for (int i=0; i<s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return 0;
            }
            num= num*10+(s.charAt(i)-'0');
        }
        num = op=='-' ? -num : num;
        if (num>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }
}
