package java_practice;

public class Codility1 {
    public static void main(String[] args) {
        System.out.println(solution(15958));
        System.out.println(solution(-5859));
    }

    public static int solution(int N) {
        String str = "" + N;
        int lastKeyFound = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '5') {
                lastKeyFound = i;
                if ((N > 0) && i + 1 < str.length() && Integer.parseInt("" + str.charAt(i + 1)) >= 5) {
                    break;
                } else if (N < 0 && i + 1 < str.length() && Integer.parseInt("" + str.charAt(i + 1)) <= 5) {
                    break;
                }
            }
        }
        if (lastKeyFound != -1) {
            return Integer.parseInt(str.substring(0, lastKeyFound) + str.substring(lastKeyFound + 1));
        }
        return -1;
    }
}
