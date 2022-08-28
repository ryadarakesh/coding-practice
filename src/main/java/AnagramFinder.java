import java.util.Arrays;

public class AnagramFinder {

    public static void main(String[] args) {
        System.out.println(isAnagram("peek", "keep"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("Man", "can"));
    }

    static boolean isAnagram(String firstStr, String secondStr) {
        if (firstStr == null && secondStr == null) {
            return true;
        }
        if (firstStr == null || secondStr == null) {
            return false;
        }
        if (firstStr.length() != secondStr.length()) {
            return false;
        }

        char[] s1 = firstStr.toCharArray();
        char[] s2 = secondStr.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

}
