package com.javadroider.interviewprep.leetcode.easy;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
}
