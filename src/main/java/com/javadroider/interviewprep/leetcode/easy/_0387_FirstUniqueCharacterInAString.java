package com.javadroider.interviewprep.leetcode.easy;

import java.util.*;

public class _0387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(str.charAt(new _0387_FirstUniqueCharacterInAString().firstUniqChar(str)));
    }

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                map.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }

        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

    //https://leetcode.com/problems/first-unique-character-in-a-string/solution/
    public int firstUniqChar1(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
