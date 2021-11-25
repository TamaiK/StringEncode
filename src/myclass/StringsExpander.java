package myclass;

import java.util.ArrayList;
import java.util.List;

public class StringsExpander {

    private static final char CHAR_NUM_MIN = '0';
    private static final char CHAR_NUM_MAX = '9';
    
    public static final String STRING_BLANK = "";

    public static String decode(String decodeString){

        List<Character> charList = new ArrayList<>();
        List<Integer> charCountList = new ArrayList<>();

        countChar(decodeString, charList, charCountList);

        String joinText = joinList(charList, charCountList);

        return joinText;
    }

    private static void countChar(String decodeString, List<Character> charList, List<Integer> charCountList) {

        String numberString = STRING_BLANK;
        for (char chr : decodeString.toCharArray()) {

            if(isNumberChar(chr)){
                numberString += chr;
                continue;
            }

            if(numberString != STRING_BLANK){
                
                int count = Integer.parseInt(numberString);
                setCount(count, charCountList);
                numberString = STRING_BLANK;
            }

            changeCountChar(chr, charList, charCountList);
        }
    }

    private static boolean isNumberChar(char chr) {
        return chr >= CHAR_NUM_MIN && chr <= CHAR_NUM_MAX;
    }

    private static void setCount(int count, List<Integer> charCountList) {
        
        if(charCountList.size() == 0){
            return;
        }
        
        int lastIndex = charCountList.size() - 1;
        charCountList.set(lastIndex, count);
    }

    private static void changeCountChar(char chr, List<Character> charList, List<Integer> charCountList) {

        charList.add(chr);
        charCountList.add(1);
    }

    private static String joinList(List<Character> charList, List<Integer> charCountList) {
        
        String joinText = "";

        for (int index = 0; index < charList.size(); index++) {
            
            char chr = charList.get(index);
            int charCount = charCountList.get(index);
            joinText += createCharLine(index, chr, charCount);
        }

        return joinText;
    }

    private static String createCharLine(int index, char chr, int charCount) {

        String charLine = "";

        for (int i = 0; i < charCount; i++) {
            charLine += chr;
        }

        return charLine;
    }
}
