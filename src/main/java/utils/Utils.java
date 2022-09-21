package utils;

import java.util.List;

public class Utils {
    public static boolean isEmpty(String s) {
        return s==null || s.length()==0;
    }
    public static boolean isBlank(String s) {
        return s==null || s.trim().length()==0;
    }

    public static void printListElements(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    public static void printIntListElements(List<Integer> list) {
        list.stream().forEach(System.out::print);
        System.out.println("");
    }


}
