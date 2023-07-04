//
//💡 **Question 7**
//
//        Given an encoded string, return its decoded string.
//
//        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//        You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].



package ppt_assignment8;

import java.util.*;

public class StringDecoder {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String decodedString = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                // Extract the number
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                // Push the current decoded string and start a new one
                stringStack.push(decodedString);
                decodedString = "";
                index++;
            } else if (s.charAt(index) == ']') {
                // Retrieve the previous decoded string and repeat it
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(decodedString);
                }
                decodedString = temp.toString();
                index++;
            } else {
                // Append characters to the current decoded string
                decodedString += s.charAt(index);
                index++;
            }
        }

        return decodedString;
    }

    public static void main(String[] args) {
        String encodedString = "3[a2[bc]4[d]]";
        String decodedString = decodeString(encodedString);
        System.out.println("Decoded string: " + decodedString);
    }
}
