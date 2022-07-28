package logical;

public class IncrementDigits {
    public static void main(String[] args) {
        System.out.println(solution(512, 10));
        System.out.println(solution(191, 4));
        System.out.println(solution(285, 20));
    }

    public static int solution(int N, int K) {
        for (int i = 0; i < K; i++) {
            if (N < 900) {
                N = N + 100;
            } else if (N < 990) {
                N = N + 10;
            } else if (N < 999) {
                N = N + 1;
            }
        }
        return N;
    }
}
