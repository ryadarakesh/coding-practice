package runners;

public class UniqueCharStringFinder {
    public static void main(String[] args) {
        System.out.println(hasUniqueChars("RAKESH"));
        System.out.println(hasUniqueChars("RRAKESH "));
    }

    /**
     * It will use individual bits to check whether that position char already repeated
     * It works only for chars A-Z otherwise overflow may occur
     * @param s
     * @return
     */
    private static boolean hasUniqueChars(String s) {
        int tracker = 0;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'A';
            if ((tracker & (1 << pos)) > 0) {
                return false;
            }
            tracker = tracker | 1 << pos;
        }
        return true;
    }
}
