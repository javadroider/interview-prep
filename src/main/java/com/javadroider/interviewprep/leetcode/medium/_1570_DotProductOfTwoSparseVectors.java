package com.javadroider.interviewprep.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _1570_DotProductOfTwoSparseVectors {

    //https://leetcode.com/problems/dot-product-of-two-sparse-vectors/discuss/826713/Java-100-O(min(dm-dn))-solution/707102
    class SparseVector {

        Map<Integer, Integer> indexMap = new HashMap<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    indexMap.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if (indexMap.size() == 0 || vec.indexMap.size() == 0) {
                return 0;
            }

            if (indexMap.size() < vec.indexMap.size()) {
                return vec.dotProduct(this);
            }

            int product = 0;
            for (Integer key : indexMap.keySet()) {
                if (vec.indexMap.containsKey(key)) {
                    product += vec.indexMap.get(key) * indexMap.get(key);
                }
            }

            return product;
        }
    }
}
