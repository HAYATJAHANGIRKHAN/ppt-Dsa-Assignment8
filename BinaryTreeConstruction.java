//You need to construct a binary tree from a string consisting of parenthesis and integers.
//
//        The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
//        You always start to construct the **left** child node of the parent first if it exists.
//        **Input:** s = "4(2(3)(1))(6(5))"
//
//        **Output:** [4,2,6,3,1,5]

package ppt_assignment8;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeConstruction {
    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        int numEnd = s.indexOf('(');
        if (numEnd == -1) {
            return new TreeNode(Integer.parseInt(s));
        }

        int num = Integer.parseInt(s.substring(0, numEnd));
        TreeNode root = new TreeNode(num);

        int count = 0;
        int i = numEnd;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count == 0) {
                break;
            }
        }

        if (i < s.length() - 1) {
            root.left = str2tree(s.substring(numEnd + 1, i));
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        } else {
            root.left = str2tree(s.substring(numEnd + 1, s.length() - 1));
        }

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = str2tree(s);

        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
    }
}




