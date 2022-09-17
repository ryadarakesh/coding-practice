package arrays;

public class FindStringOcuurance {
    public static void main(String[] args) {
        System.out.println(strStr("sabutsad", "sad"));
    }
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i=0; i<=(haystack.length()-needle.length()); i++) {
            boolean found = true;
            for (int j=0; j<needle.length(); j++) {
                if (needle.charAt(j)!=haystack.charAt(i+j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
