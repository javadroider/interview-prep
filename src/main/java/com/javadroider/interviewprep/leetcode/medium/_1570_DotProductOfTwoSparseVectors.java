package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            if (indexMap.size() > vec.indexMap.size()) {
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

    //https://leetcode.com/problems/dot-product-of-two-sparse-vectors/discuss/840934/Easy-to-understand-Java-Solution.-Linear-Runtime.-O(M%2BN))
    class SparseVector1 {

        private class Pair {

            int index;
            int value;

            private Pair(int i, int v) {
                this.index = i;
                this.value = v;
            }

        }

        List<Pair> pairList;

        SparseVector1(int[] nums) {

            this.pairList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    this.pairList.add(new Pair(i, nums[i]));
                }
            }

        }

        public List<Pair> getPairList() {
            return this.pairList;
        }


        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector1 vec) {

            List<Pair> pairListA = this.pairList;
            List<Pair> pairListB = vec.getPairList();

            int result = 0;

            int i = 0;
            int j = 0;

            while (i < pairListA.size() && j < pairListB.size()) {

                Pair pairA = pairListA.get(i);
                Pair pairB = pairListB.get(j);

                if (pairA.index < pairB.index) {
                    i++;
                } else if (pairA.index > pairB.index) {
                    j++;
                } else { // pairA.index == pairB.index;
                    result += pairA.value * pairB.value;
                    i++;
                    j++;
                }

            }

            return result;


        }
    }
}
