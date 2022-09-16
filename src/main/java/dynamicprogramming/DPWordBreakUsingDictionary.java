package dynamicprogramming;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 *   cream, icecream, man, go, mango}
 *
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 *
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung"
 * or "i like sam sung".
 */
public class DPWordBreakUsingDictionary {
    static Set<String> dictionary = new HashSet<>();
    static {
        dictionary.addAll(Arrays.asList("mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"));
    }

    public static void main(String[] args) {
        System.out.println(isWordBreakPerfectNonDP("ilikesamsung"));
        System.out.println(isWordBreakPerfectNonDP("ilokesamsung"));

        System.out.println(wordBreakUsingDP1("ilikesamsung"));
        System.out.println(wordBreakUsingDP1("ilokesamsung"));
    }

    /*
    For each string we will divide into 2 parts for each
     */
    public static boolean isWordBreakPerfectNonDP(String s) {
        if (s.length() == 0) {
            return true;
        }


        for (int i = 0; i <= s.length(); i++) {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.
            if (dictionary.contains(s.substring(0, i)) && isWordBreakPerfectNonDP(s.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreakUsingDP1(String s) {
        boolean[] dp = new boolean[s.length()+1];
        // Every d[x] true indicates that 0 to x chars are part of dictionary
        dp[0] = true;
        for (int length = 1; length <= s.length(); length++) {
            // For each length check 0 to intermediary and intermediary to length are dictionary words
            for (int i = 0; i < length; i++) {
                if (dp[i] && dictionary.contains(s.substring(i, length))) {
                    dp[length] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
