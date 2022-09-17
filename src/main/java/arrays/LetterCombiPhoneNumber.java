package arrays;

import java.util.*;

public class LetterCombiPhoneNumber {
    static List<String> mappings;

    static {
        mappings = Arrays.asList("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
    }

    public static void main(String[] args) {
        getLetterCombinations(new int[]{2, 3});
    }

    static void getLetterCombinations(int[] numbers) {
        List<String> list = new ArrayList<>();
        getLetterCombinations(numbers, 0, "", list);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    static void getLetterCombinations(int[] numbers, int currentPos, String currentString, List<String> result) {
        if (numbers.length == currentString.length()) {
            result.add(currentString);
            return;
        }
        if (currentPos >= numbers.length) {
            return;
        }
        String s = mappings.get(numbers[currentPos]);
        for (char ch : s.toCharArray()) {
            getLetterCombinations(numbers, currentPos + 1, currentString + ch, result);
        }
    }
}
