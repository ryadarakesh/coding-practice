package logical;

/*
Used to search for an item in Equally distributed sorted array
It is an improvement over binary search
formula
pos = lo + [ \frac{(x-arr[lo])*(hi-lo) }{ (arr[hi]-arr[Lo]) }]
https://www.geeksforgeeks.org/interpolation-search/
 */
public class InterpolationSearch {

    public static void main(String[] args) {
        System.out.println(interpolationSearch(new int[] {10,20,30,40,50,60,70,80,90,100}, 0, 9, 30));

        System.out.println(interpolationSearch(new int[] {10,20,30,40,50,60,70,80,90,100}, 0, 9, 90));

        System.out.println(interpolationSearch(new int[] {10,20,30,40,50,60,70,80,90,100}, 0, 9, 110));

        System.out.println(interpolationSearch(new int[] {10,20,30,40,50,60,70,80,90,100}, 0, 9, 95));
    }

    public static int interpolationSearch(int[] a, int low, int high, int x) {
        // Item not available
        if (low > high || (x < a[low] || x > a[high])) {
            return -1;
        }
        // calculate nearest position
        int position = low + ((x - a[low]) * (high - low)) / (a[high] - a[low]);
        if (a[position] == x) {
            return position;
        }
        // Search right side
        if (x > a[position]) {
            return interpolationSearch(a, position + 1, high, x);
        }
        // search left side
        return interpolationSearch(a, low, position - 1, x);
    }
}
