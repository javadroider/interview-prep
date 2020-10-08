package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1233_RemoveSubFoldersFromTheFilesystem {

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/discuss/409011/JavaC-Easy-and-Simple-Solution-with-Space-O(1)/664189
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        if (folder == null || folder.length == 0) {
            return res;
        }
        Arrays.sort(folder);
        res.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(res.get(res.size() - 1) + "/")) {
                res.add(folder[i]);
            }
        }

        return res;
    }
}
