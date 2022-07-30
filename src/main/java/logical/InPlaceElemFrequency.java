package logical;

public class InPlaceElemFrequency {
    public static void main(String[] args) {
        printFrequency(new int[] {1,2,2,3,3,3,6});
    }
    // If Array size is N holds 0 to N-1 as values
    // Hence we are adding n at corresponding position as %n will give actual element and /n give frequency
    static void printFrequency(int[] a) {
        int n= a.length;
        for (int i=0; i<n; i++) {
            int ele = a[i]%n;
            a[ele] = a[ele]+n;
        }

        for (int i=0; i<n; i++) {
            System.out.println(i+ " found "+(a[i]/n)+ " times");
        }

    }
}
