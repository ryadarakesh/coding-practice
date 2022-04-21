package helpers;

import helpers.MyOptional;

import java.util.Collection;

public class MaxExtractor {

    /**
     * It accepts any collection of comparable elements and return max element encapsulated in MyOptional
     * @param collection
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> MyOptional<E> max(Collection<E> collection) {
        if (collection.isEmpty()) {
            return MyOptional.empty();
        }
        E result= null;
        for (E e : collection) {
            if (result == null || e.compareTo(result)>0) {
                result = e;
            }
        }
        return MyOptional.of(result);
    }
}
