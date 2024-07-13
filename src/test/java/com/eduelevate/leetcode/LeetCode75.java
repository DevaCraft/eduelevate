package com.eduelevate.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode75 {

    LeetCodeArrayString leetCodeArrayString = new LeetCodeArrayString();

    @Test
    void mergeAlternatelyTest() {
        String result = leetCodeArrayString.mergeAlternately("abc", "pqr");
        Assertions.assertEquals("apbqcr", result);
        result = leetCodeArrayString.mergeAlternately("abc", "xyz123");
        Assertions.assertEquals("axbycz123", result);
    }

    @Test
    void removeStarsTest() {
        String result = leetCodeArrayString.removeStars("lee**tcode**");
        Assertions.assertEquals("ltco", result);
    }

    @Test
    void replaceVowels1() {
        String sentance = "i am java developer";
        List<Character> vowels = new ArrayList<>();
        for (char ch : sentance.toCharArray()) {
            if (isVowel(ch)) vowels.add(ch);
        }
        Collections.reverse(vowels);
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (char ch : sentance.toCharArray()) {
            if (isVowel(ch)) ch = vowels.get(index++);//
            builder.append(ch);
        }
        System.out.println(builder.toString());
    }


    @Test
    void replaceVowels2() {
        String sentance = "i am java developer";
        List<Character> vowels = sentance.chars().mapToObj(c -> (char) c).filter(LeetCode75::isVowel).collect(Collectors.toList());
        Collections.reverse(vowels);
        int[] index = {0};
        String result = sentance.chars().mapToObj(c -> {
            if (isVowel((char) c)) {
                return vowels.get(index[0]++);
            } else {
                return (char) c;
            }
        }).map(String::valueOf).collect(Collectors.joining());
        System.out.println(result);
    }


    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(Character.toLowerCase(ch)) != -1;
    }


    @Test
    void findPrefix1() {
        String[] words = {"follower", "follow", "following"};
        // output = "follow"
        String result = Arrays.stream(words).reduce((prefix, second) -> {
            while (!second.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
            return prefix;
        }).orElse("");
        System.out.println(result);
    }

    @Test
    void findPrefix2() {
        String[] words = {"follow", "follower", "follotwing"};
        // output = "follow"
        int minWordLength = Arrays.stream(words).mapToInt(String::length).min().orElse(0);
        StringBuilder prefix = new StringBuilder();
        outer:
        for (int i = 0; i < minWordLength; i++) {
            char currentChar = words[0].charAt(i);
            for (int j = 1; j < words.length; j++) {
                char nextChar = words[j].charAt(i);
                if (currentChar != nextChar) {
                    break outer;
                }
            }
            prefix.append(currentChar);
        }
        System.out.println(prefix.toString());


    }
//add method for adding two matrics
    @Test
    void addMatrices() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    // add method for multiplying two matrices
    @Test
    void multiplyMatrices() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }









}
