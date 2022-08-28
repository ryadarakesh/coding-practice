package leetcode;

import java.util.*;

public class IntToRoman {

    /*
    I             1
V             5
X             10
L             50
C             100
D             500
M             1000
     */
    // Linked hashmap to maintain order
    static Map<String, Integer> map = new LinkedHashMap<>();
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

    public static void main(String[] args) {
        //System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));

    }


    public static String intToRoman(int num) {
        StringBuffer s= new StringBuffer("");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int candidate = entry.getValue();
            while (num>=candidate) {
                num = num - candidate;
                s.append(entry.getKey());
            }
            if (num==0) {
                break;
            }
        }
        return s.toString();
    }

}
