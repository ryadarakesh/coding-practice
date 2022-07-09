package logical;

public class SwapWithXOR {

    public static void main(String[] args) {
        int x = 123;
        int y = 345;
        System.out.println("Before x="+x+" y="+y);
        // Swap without temp using XOR operation
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After x="+x+" y="+y);
        String s = "abcedef";
        System.out.println("String = "+s);
        System.out.println("Reverse = "+reverseWithXor(s));
    }

    public static String reverseWithXor (String s) {
        StringBuffer sb = new StringBuffer(s);
        int len = sb.length()-1;
        for (int i=0; i<=len/2; i++) {
            sb.setCharAt(i, (char)( (int) sb.charAt(i) ^ (int)sb.charAt(len-i)));
            sb.setCharAt((len-i), (char)( (int) sb.charAt(i) ^ (int)sb.charAt(len-i)));
            sb.setCharAt((i), (char)( (int) sb.charAt(i) ^ (int)sb.charAt(len-i)));
        }
        return sb.toString();
    }
}
