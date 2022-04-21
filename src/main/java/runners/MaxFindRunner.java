package runners;

import helpers.MaxExtractor;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxFindRunner {
    public static void main(String[] args) {

        System.out.println(MaxExtractor.max(Arrays.asList(1,5,8,2,100,96)).orElse(0));

        System.out.println(MaxExtractor.max(Arrays.asList("abc","def","rak")).orElse("Not Found"));

        System.out.println(MaxExtractor.max(new ArrayList<String>()).orElse("Not Found"));
        
    }
}
