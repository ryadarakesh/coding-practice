package backtracking;

import helpers.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        permutations("ABC", 0);
        printResult(result);
    }

    static void permutations(String s, int index) {
       if (s.length()==index) {
           System.out.println(s);
       }

       for (int i=index; i< s.length(); i++) {
           s=swap(s, i, index);
           permutations( s, index+1);
           s=swap(s, i, index);
       }
    }

    static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

    static void printResult (List<String> result ) {
        for (String r : result) {
            System.out.println(r);
        }
    }
}
