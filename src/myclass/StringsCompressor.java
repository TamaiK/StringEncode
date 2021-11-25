package myclass;

import java.util.ArrayList;
import java.util.List;

public class StringsCompressor {

    private static int SINGLE_NUM = 1;

    public static String encode(String encodeString){

        List<Character> charList = new ArrayList<>();
        List<Integer> charCountList = new ArrayList<>();

        countChar(encodeString, charList, charCountList);

        String joinText = joinList(charList, charCountList);

        return joinText;
    }

    private static void countChar(String encodeString, List<Character> charList, List<Integer> charCountList) {

        for (char chr : encodeString.toCharArray()) {
            
            if(!isEqualsChar(chr, charList)){

                changeCountChar(chr, charList, charCountList);
                continue;
            }

            countUp(charCountList);
        }
    }

    private static boolean isEqualsChar(char chr, List<Character> charList) {

        if(charList.size() == 0){
            return false;
        }
        
        int lastIndex = charList.size() - 1;
        return charList.get(lastIndex) == chr;
    }

    private static void changeCountChar(char chr, List<Character> charList, List<Integer> charCountList) {

        charList.add(chr);
        charCountList.add(1);
    }

    private static void countUp(List<Integer> charCountList) {
        
        if(charCountList.size() == 0){
            return;
        }
        
        int lastIndex = charCountList.size() - 1;
        int countUp = charCountList.get(lastIndex) + 1;
        charCountList.set(lastIndex, countUp);
    }

    private static String joinList(List<Character> charList, List<Integer> charCountList) {

        String joinText = "";

        for (int index = 0; index < charList.size(); index++) {
            
            joinText += charList.get(index);

            int charCount = charCountList.get(index);
            if(charCount > SINGLE_NUM){
                
                joinText += String.valueOf(charCount);
            }
        }

        return joinText;
    }
}
