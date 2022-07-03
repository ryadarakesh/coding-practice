package logical;


public class OddOccuringNumber {
    public static void main(String[] args) {
        System.out.println(findOddOccuredNumber(new int[]{1,2,3,1,2,3,3,3,4}));
        System.out.println(findOddOccuredNumber(new int[]{20,40,90,40,90,15,15}));
    }
    /*
    Here all numbers would be there even number of times and only one is odd number of times
    Solution - A XOR A = 0 means all even numbers would become zero
    ex : {1,2,3,1,2,3,3,3,4} - 4
         {20,40,90,40,90,15,15}
     */
    static int findOddOccuredNumber(int[] a) {
        int result = a[0];
        for (int i=1; i< a.length; i++) {
            result ^= a[i];
        }
        return result;
    }
}
