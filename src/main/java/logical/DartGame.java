package logical;

import java.util.HashMap;
import java.util.Map;

public class DartGame {
    static Map<String, Integer> exceptionalMap;

    static {
        exceptionalMap = new HashMap<>();
        exceptionalMap.put("SB", 25);
        exceptionalMap.put("DB", 50);
    }

    public static void main(String[] args) {
        /*System.out.println(getDartGameResult(new String[]{"D10", "T2", "18", "17", "D19", "5"}));

        System.out.println(getDartGameResult(new String[]{"12", "T13", "D10", "T2", "18", "17", "D19", "5"}));

        System.out.println(getDartGameResult(new String[]{"12", "T13", "D10", "T2", "18", "17", "D19", "5", "T20", "T20", "T20", "1", "D8"}));

        System.out.println(getDartGameResult(new String[]{"12", "T13", "D10", "T2", "18", "17", "D19", "5", "T20", "T20", "T20", "D8", "1"}));

        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "DB"}));

         */

        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "T17", "0" , "0"})); //50
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "T17", "0" , "0", "11", "0", "0"})); // 39
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "20", "15", "0" , "T5"})); // 15
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "20", "15", "0" , "T5"})); // 15
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "20", "15", "0" , "T5", "15"})); // 15
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "T20"})); // 50
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1","10", "T20"})); // 50
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "DB"})); // 0
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "20", "5", "0", "SB"})); // 25
        System.out.println(getDartGameResult(new String[]{"17", "T2", "17", "18", "17", "D19", "5"})); // 258
        System.out.println(getDartGameResult(new String[]{"D20", "T20", "T20", "T20", "T10", "1", "DB"})); // 0
    }

    public static int getDartGameResult(String[] attempts) {
        boolean isGameStarted = false;
        int score = 301;
        int roundScore = 0;
        boolean burstHappened = false;
        for (int i = 0; i < attempts.length; i++) {
            if (i % 3 == 0) {
                roundScore = 0;
            }
            if (!isGameStarted) {
                if (isDouble(attempts[i])) {
                    isGameStarted = true;
                } else {
                    continue;
                }
            }
            int currentScore = getScoreFromAttempt(attempts[i]);
            roundScore = roundScore + currentScore;
            if (score - currentScore <= 1) {
                if (isDouble(attempts[i])) {
                    score = score - currentScore;
                    return score;
                } else {
                    score = score - currentScore;
                    burstHappened = true;
                }
            } else {
                score = score - currentScore;
            }
            if ((i % 3 == 2 || i == attempts.length - 1) && burstHappened) {
                burstHappened = false;
                score = score + roundScore;
            }
        }
        return score;
    }

    static boolean isDouble(String s) {
        return s != null && s.startsWith("D");
    }

    static int getScoreFromAttempt(String s) {
        if (exceptionalMap.containsKey(s)) {
            return exceptionalMap.get(s);
        }
        if (s.startsWith("D")) {
            return Integer.parseInt(s.substring(1)) * 2;
        } else if (s.startsWith("T")) {
            return Integer.parseInt(s.substring(1)) * 3;
        }
        return Integer.parseInt(s);
    }

}
