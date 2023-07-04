//<aside>
//💡 **Question 8**
//
//        Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal to* goal*, otherwise, return* false*.*
//
//        Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
//
//        - For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
//
//        **Example 1:**
//
//        **Input:** s = "ab", goal = "ba"
//
//        **Output:** true
//
//        **Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.



package ppt_assignment8;

public class SwapStrings {
    public static boolean canSwapStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int diffCount = 0;
        int[] diffIndices = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diffCount >= 2) {
                    return false;
                }
                diffIndices[diffCount++] = i;
            }
        }

        if (diffCount == 0) {
            return true; // Strings are already equal, no swaps needed
        }

        if (diffCount == 2) {
            // Check if swapping the characters at the two different indices results in 's' becoming equal to 'goal'
            char temp = s.charAt(diffIndices[0]);
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(diffIndices[0], s.charAt(diffIndices[1]));
            sb.setCharAt(diffIndices[1], temp);
            return sb.toString().equals(goal);
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String goal1 = "ba";
        System.out.println(canSwapStrings(s1, goal1)); // Output: true

        String s2 = "abcd";
        String goal2 = "cbad";
        System.out.println(canSwapStrings(s2, goal2)); // Output: false
    }
}
