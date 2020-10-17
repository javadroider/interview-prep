package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.TreeNode;

public class _0333_LargestBSTSubtree {

    //https://leetcode.com/problems/largest-bst-subtree/discuss/78891/Share-my-O(n)-Java-code-with-brief-explanation-and-comments/83725
    public int largestBSTSubtree(TreeNode root) {
        return getLargestBST(root).size;
    }

    public Answer getLargestBST(TreeNode root) {
        if (root == null) {
            return new Answer(true, 0, null, null);
        }

        Answer leftAns = getLargestBST(root.left);
        Answer rightAns = getLargestBST(root.right);

        if (leftAns.isValid && rightAns.isValid) {
            if ((root.left == null || root.val > leftAns.max) && (root.right == null || root.val < rightAns.min)) {
                return new Answer(true, leftAns.size + rightAns.size + 1,
                        root.left == null ? root.val : leftAns.min, root.right == null ? root.val : rightAns.max);
            }
        }
        return new Answer(false, Math.max(leftAns.size, rightAns.size), null, null);
    }


    private class Answer {
        boolean isValid;
        Integer max;
        Integer min;
        int size;

        public Answer(boolean isValid, int size, Integer min, Integer max) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
}
