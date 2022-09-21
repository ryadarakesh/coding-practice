package backtracking;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakSentenceMaker {
    public static void main(String[] args) {
        // List of strings in dictionary
        List<String> sentences = new ArrayList<>();
        List<String> dict= Arrays.asList("mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","love","ice","cream");
        System.out.println("Actual word - "+"ilovesamsungmobile");
        getSentencesByBreakingWords(dict, "ilovesamsungmobile", "", sentences);
        Utils.printListElements(sentences);
        sentences = new ArrayList<>();
        System.out.println("Actual word - "+"iloveicecreamandmango");
        getSentencesByBreakingWords(dict, "iloveicecreamandmango", "", sentences);
        Utils.printListElements(sentences);

        sentences = new ArrayList<>();
    }

    static void getSentencesByBreakingWords (List<String> dict, String s, String prefix, List<String> sentences) {
        if (Utils.isEmpty(s)) {
            sentences.add(prefix);
            return;
        }
        /*
        Get substrings with length 1 to n and for each valid word split and make it as a prefix and call the method for remaining chars using prfix
         */
        for (int i=1; i<=s.length(); i++) {
            String currentPrefix = s.substring(0,i);
            if (dict.contains(currentPrefix)) {
                getSentencesByBreakingWords(dict, s.substring(i), prefix+" "+currentPrefix, sentences);
            }
        }
    }

}
