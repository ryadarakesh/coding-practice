package logical;

/**
 * Given a number n, give an algorithm for finding the number of trailing zeros in
 */
public class FactorialTrailingZeros {
    public static void main(String[] args) {
        System.out.println(getTrailingZerosInFactorial(5));
        System.out.println(getTrailingZerosInFactorial(10));
        System.out.println(getTrailingZerosInFactorial(25));
    }

    /*
    Here we need to count how many 5's that we will get by dividing the number with 5
    But in case of 25 instead of 5 5's we have 6 because 25 = 5*5
    similarly 125 will have 5*5*5 . So we should increment 5 with *5 and try till n/i >0

     */
    public static int getTrailingZerosInFactorial(int n) {
        if (n < 0) {
            return -1;
        }
        int count = 0;
        for (int i = 5; n / i > 0; i = i * 5) {
            count = count + (n / i);
        }
        return count;
    }
}
