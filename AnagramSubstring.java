//<aside>
//💡 **Question 6**
//
//        Given two strings s and p, return *an array of all the start indices of* p*'s anagrams in* s. You may return the answer in **any order**.
//
//        An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//        **Example 1:**
//
//        **Input:** s = "cbaebabacd", p = "abc"
//
//        **Output:** [0,6]
//
//        **Explanation:**
//
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//</aside>

package ppt_assignment8;

import java.util.*;


public class AnagramSubstring {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Edge cases: if either string is empty or p is longer than s, return empty result
        if (s.isEmpty() || p.isEmpty() || p.length() > s.length()) {
            return result;
        }

        // Create frequency maps for characters in p and a sliding window in s
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = 0;
        int windowEnd = 0;
        int matchCount = 0;

        while (windowEnd < s.length()) {
            // Expand the window
            char currentChar = s.charAt(windowEnd);

            // Update the window map
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            // If the frequency of the current character in the window map matches the frequency in p map, increment match count
            if (pMap.containsKey(currentChar) && windowMap.get(currentChar).equals(pMap.get(currentChar))) {
                matchCount++;
            }

            // Shrink the window if it's larger than p
            if (windowEnd - windowStart + 1 > p.length()) {
                char leftChar = s.charAt(windowStart);

                // Update the window map
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If the frequency of the left character in the window map becomes less than the frequency in p map, decrement match count
                if (pMap.containsKey(leftChar) && windowMap.get(leftChar).equals(pMap.get(leftChar) - 1)) {
                    matchCount--;
                }

                // Move the window start to the right
                windowStart++;
            }

            // If all characters in p are matched, add the start index of the anagram to the result list
            if (matchCount == pMap.size()) {
                result.add(windowStart);
            }

            // Move the window end to the right
            windowEnd++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> indices = findAnagrams(s, p);
        System.out.println("Anagram start indices: " + indices);
    }
}

