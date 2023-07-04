//<aside>
//💡 **Question 5**
//
//        Given an array of characters chars, compress it using the following algorithm:
//
//        Begin with an empty string s. For each group of **consecutive repeating characters** in chars:
//
//        - If the group's length is 1, append the character to s.
//        - Otherwise, append the character followed by the group's length.
//
//        The compressed string s **should not be returned separately**, but instead, be stored **in the input character array chars**. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
//
//        After you are done **modifying the input array,** return *the new length of the array*.
//
//        You must write an algorithm that uses only constant extra space.
//
//        **Example 1:**
//
//        **Input:** chars = ["a","a","b","b","c","c","c"]
//
//        **Output:** Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//
//        **Explanation:**
//
//        The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".


package ppt_assignment8;

public class compresschar {
    public int compress(char[] chars) {
        int index = 0; // current index to modify chars array
        int count = 1; // count of consecutive repeating characters

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1]; // store the character

                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c; // store the count as separate characters
                    }
                }

                count = 1; // reset count for the new character
            }
        }

        // store the last character and its count (if applicable)
        chars[index++] = chars[chars.length - 1];
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[index++] = c;
            }
        }

        return index; // return the new length of the array
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compresschar solution = new compresschar();
        int newLength = solution.compress(chars);

        System.out.println("New length: " + newLength);
        System.out.print("Modified chars array: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i]);
            if (i < newLength - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

    }
}
