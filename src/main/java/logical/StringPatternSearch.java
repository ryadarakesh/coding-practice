package logical;

import java.util.ArrayList;

public class StringPatternSearch {

    public static void main(String[] args) {
        System.out.println(isSubString("Rakesh Ryada", "Rajesh"));
        System.out.println(isSubString("Rakesh Ryada", "Rakesh"));
        System.out.println(isSubString("Rakesh Ryada", "Ryad"));
    }

    static boolean isSubString(String s, String p) {
        for (int i = 0; i < (s.length() - p.length()); i++) {
            int matchCount = 0;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i + j)) {
                    matchCount++;
                    if (matchCount == p.length()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
