package com.javadroider.interviewprep.leetcode.medium;

import java.util.Stack;

public class _0071_SimplifyPath {

    public static void main(String[] args) {
        System.out.println(new _0071_SimplifyPath().simplifyPath("/a//b////c/d//././/.."));// "/a/b/c"
        System.out.println(new _0071_SimplifyPath().simplifyPath("/a/../../b/../c//.//"));// "/c"
        System.out.println(new _0071_SimplifyPath().simplifyPath("/a/./b/../../c/"));// "/c"
    }

    //https://leetcode.com/problems/simplify-path/solution/
    public String simplifyPath(String path) {

        // Handle empty string
        if (path.isEmpty()) {
            return path;
        }

        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {

            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {

                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {

                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
