package com.javadroider.interviewprep.ds.tree;

import com.javadroider.interviewprep.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrinthPathWithGivenSum {

    /*
		    10
		  /   \
		 8     12
		/ \   /  \
		7  9  11  13

	*/
    static void print(Node node, Stack<Node> stack, int sum, int k) {
        if (node == null) {
            return;
        }
        sum = sum + node.data;
        stack.push(node);
        print(node.left, stack, sum, k);
        if (sum == k) {
            System.out.println(stack);
        }
        print(node.right, stack, sum, k);
        stack.pop();
    }

    public static void main(String[] args) {
        Node node = BinaryTree.sample();
        //print(node, new Stack<>(), 0, 22);
        //System.out.println(pathSum(TreeNode.sample(), 27));
        System.out.println(branchSums(TreeNode.sample()));
    }

    private static List<Integer> branchSums(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        calculateBranchSums(node, result, 0);
        return result;
    }

    private static void calculateBranchSums(TreeNode node, List<Integer> result, int sum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            result.add(sum);
            return;
        }
        calculateBranchSums(node.left, result, sum);
        calculateBranchSums(node.right, result, sum);

    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, result, new ArrayList<>());
        //dfs(root, sum, result, new ArrayList<>());
        return result;
    }

    private static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, res, path);
            path.remove(path.size() - 1);
        }

    }

    private static void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentPath) {

        if (root == null || sum < 0) {
            return;
        }
        currentPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(currentPath));
            }
            return;
        }
        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }


}
