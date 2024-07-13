package com.eduelevate.leetcode;



public class LeetCodeArrayString {


   public String mergeAlternately(String word1, String word2){
       if(word1 ==null || word2 ==null )  return "";
       int length1 = word1.length();
       int length2 = word2.length();
       StringBuilder builder = new StringBuilder();
       for(int i =0; i <Math.max(length1,length2); i++){
            if(i<length1) builder.append(word1.charAt(i));
            if(i<length2) builder.append(word2.charAt(i));
       }
       return builder.toString();

   }

    public String removeStars(String s) {

        StringBuilder result = new StringBuilder();

        int bound = s.length();
        for (int i = 0; i < bound; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (!result.isEmpty()) {
                    result.deleteCharAt(result.length() - 1);
                }

            } else {
                result.append(ch);
            }
        }
        return result.toString();

    }
}
