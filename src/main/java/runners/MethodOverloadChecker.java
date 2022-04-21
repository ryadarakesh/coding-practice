package runners;

import java.math.BigInteger;
import java.util.*;

public class MethodOverloadChecker {
    public static String classify(Set<?> s) {
        return "Set";
    }
    public static String classify(List<?> lst) {
        return "List";
    }
    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }
    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        // It will print 3 times Unknown Collection as it is compile time
        // polymorphism depends on reference type but not object type
        for (Collection<?> c : collections)
            System.out.println(classify(c));


    }
}
