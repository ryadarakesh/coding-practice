package java_practice;

public class PrimeChecker {

    public static boolean isPrime(int A) {
        if (A < 2) {
            return false;
        }
        int upperLimit = (int) (Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(84923));
        StringBuffer sb = new StringBuffer("");
        
    }
}
