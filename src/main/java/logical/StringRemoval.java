package logical;

public class StringRemoval {

    public static void main(String[] args) {
        System.out.println(solution("codiility"));
        System.out.println(solution("acb"));
        System.out.println(solution("aaaa"));
    }

    public static String solution(String S) {
        int positionToRemove = -1;
        for (int i=1; i<S.length()-1; i++) {
            if (S.charAt(i)>S.charAt(i-1) && S.charAt(i)>S.charAt(i+1)) {
                positionToRemove=i;
                break;
            }
        }
        if (positionToRemove==-1) {
            if (S.charAt(0)>S.charAt(1)) {
                return S.substring(1, S.length());
            } else {
                return S.substring(0, S.length()-1);
            }
        }
        if (S.charAt(0)>S.charAt(positionToRemove)) {
            return S.substring(1, S.length());
        }
        return S.substring(0,positionToRemove)+S.substring(positionToRemove+1, S.length());
    }
}
