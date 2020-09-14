package com.javadroider.interviewprep.leetcode.medium;

import com.javadroider.interviewprep.util.ListNode;
import com.javadroider.interviewprep.util.TreeNode;

public class _0109_ConvertSortedListToBinarySearchTree {

    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
    public static void main(String[] args) {
        //   [-10,-3,0,5,9]

        ListNode head = new ListNode(-10);
        ListNode minus3 = new ListNode(-3);
        ListNode zero = new ListNode(0);
        ListNode five = new ListNode(5);
        ListNode nine = new ListNode(9);
        head.next = minus3;
        minus3.next = zero;
        zero.next = five;
        five.next = nine;
        TreeNode treeNode = new _0109_ConvertSortedListToBinarySearchTree().sortedListToBST(head);
        treeNode.inorder(treeNode);
    }

    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int size = 0;
        while (ptr != null) {
            ptr = ptr.next;
            size += 1;
        }
        return size;
    }

    private TreeNode convertListToBST(int l, int r) {
        // Invalid case
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        // First step of simulated inorder traversal. Recursively form
        // the left half
        TreeNode left = convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node
        TreeNode node = new TreeNode(head.val);
        node.left = left;

        // Maintain the invariance mentioned in the algorithm
        head = head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = convertListToBST(mid + 1, r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        // Get the size of the linked list first
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }
}
