package com.uwo.leetcode.LetterCombinationsofaPhoneNumber;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> aList = new LinkedList<String>();
        if (digits.isEmpty()) return aList;
        String[] keyBoard = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        aList.add("");
        while (aList.peek().length() != digits.length()) {
            //remove first undo string
            String remove = aList.remove();
            //get the adding characters
            String unAddDigit = keyBoard[digits.charAt(remove.length()) - '0'];
            for (char c : unAddDigit.toCharArray()) {
                aList.addLast(remove + c);
            }
        }
        return aList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
