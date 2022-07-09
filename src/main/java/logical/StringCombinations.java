package logical;

/*
Here For String ABC AB and BA are of same char combinations so only one should be printed
 */
public class StringCombinations {
    public static void main(String[] args) {
        combinations("", "ABC");
    }

    static void combinations (String prefix, String s) {
        System.out.println(prefix);
        for (int i=0; i< s.length(); i++) {
            combinations(prefix+s.charAt(i), s.substring(i+1));
        }
    }
}
