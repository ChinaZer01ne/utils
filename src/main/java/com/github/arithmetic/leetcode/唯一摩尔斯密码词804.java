package com.github.arithmetic.leetcode;

import java.util.TreeSet;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/28 16:58
 */
public class 唯一摩尔斯密码词804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] digits = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                sb.append(digits[word.charAt(j) - 'a']);
            }
            treeSet.add(sb.toString());
        }
        return treeSet.size();
    }
}
