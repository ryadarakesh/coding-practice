package logical;
/*
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class StringPermutations {

    public static void main(String[] args) {
        permute("ABC", 0, 2);
        System.out.println("Approach 2");
        permuteWithSubStr("ABC", "");
    }

    static void permute(String s, int left, int right) {
        if (left == right) {
            System.out.println(s + " ");
            return;
        }
        // Each time swap left character with some next character i and call permute for left+1 starting position
        for (int i = left; i <= right; i++) {
            s = swap(s, i, left);
            permute(s, left + 1, right);
            s = swap(s, left, i);
        }
    }

    static void permuteWithSubStr (String s, String result) {
        if (s.length()==0) {
            System.out.println(result+" ");
            return;
        }
        for (int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            String remaining = s.substring(0,i) + s.substring(i+1);
            permuteWithSubStr(remaining, result+ch);
        }
    }

    static String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
