package Misc;

import java.util.HashMap;

public class LongestSubstringWithLength {

    static void LongestSubstr(String str){
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();

        int left=0; int maxLen=0; int startIdx=0;
        for (int right = 0; right < str.length(); right++) {
            Character chr = str.charAt(right);
            if(map.containsKey(chr) && map.get(chr) >= left){
                left = map.get(chr)+1;
            }
            map.put(chr,right);
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
        }


        System.out.println(maxLen);
        System.out.println(str.substring(startIdx,startIdx+maxLen));
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        LongestSubstr(str);
    }
}
