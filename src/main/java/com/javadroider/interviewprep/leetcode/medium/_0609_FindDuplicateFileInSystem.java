package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0609_FindDuplicateFileInSystem {

    public static void main(String[] args) {
        System.out.println(new _0609_FindDuplicateFileInSystem().findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }

    //https://leetcode.com/problems/find-duplicate-file-in-system/solution/
    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] values = path.split(" ");
            String dir = values[0];
            for(int i = 1; i < values.length; i++){
                String[] tokens = values[i].split("\\(");
                String fileName = tokens[0];
                String content = tokens[1].replaceAll("\\)", "");
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(dir +"/" + fileName);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }

        return res;
    }
}
