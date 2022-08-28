package logical;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatChar {
    public static void main(String[] args) {
        System.out.println(getFirstRepeatChar("hyderabad"));
    }

    public static char getFirstRepeatChar(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        int minIndexRepeat = s.length();
        char repeatChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (positionMap.containsKey(s.charAt(i))) {
                int position = positionMap.get(s.charAt(i));
                if (minIndexRepeat > position) {
                    minIndexRepeat = position;
                    repeatChar = s.charAt(i);
                }
            } else {
                positionMap.put(s.charAt(i), i);
            }
        }

        return repeatChar;
    }
}
