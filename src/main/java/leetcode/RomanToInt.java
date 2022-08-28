package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToInt {

    static Map<String, Integer> map = new HashMap<>();
    /*
    Here special case scenarios are CM, CD, XC, XL, IX, IV
     */
    static {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public static int romanToInt(String s) {
        int i = 0;
        int num = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                num = num + map.get(s.substring(i, i + 2));
                i = i + 2;
            } else {
                num = num + map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return num;
    }

    public static int romanToIntLogic2(String s) {
        int previous = map.get("" + s.charAt(s.length() - 1));
        int number = map.get("" + s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int current = map.get("" + s.charAt(i));
            if (current >= previous) {
                number = number + current;
            } else {
                number = number - current;
            }
            previous = current;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println("MCMXCIV="+romanToInt("MCMXCIV"));
        System.out.println("MCMXCIV="+romanToInt("LVIII"));

        System.out.println("MCMXCIV="+romanToIntLogic2("MCMXCIV"));
        System.out.println("MCMXCIV="+romanToIntLogic2("LVIII"));
    }
}
