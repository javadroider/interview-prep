package com.javadroider.interviewprep.leetcode.medium;

import java.util.*;

public class _0721_AccountsMerge {

    //https://leetcode.com/problems/accounts-merge/discuss/140978/Easy-to-Understand-Union-Find-in-Java-95
    public static void main(String[] args) {
        _0721_AccountsMerge instance = new _0721_AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

//        accounts.add(Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"));
//        accounts.add(Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"));
//        accounts.add(Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"));
//        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
//        accounts.add(Arrays.asList("David","David4@m.co","David1@m.co","David3@m.co"));
        //Expected: [["David","David0@m.co","David1@m.co","David3@m.co","David4@m.co","David5@m.co"]]

//        accounts.add(Arrays.asList("David","David0@m.co","David1@m.co"));
//        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
//        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));
//        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
//        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
        //Expect: [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]

//        accounts.add(Arrays.asList("David","David1@m.co","David2@m.co"));
//        accounts.add(Arrays.asList("David","David2@m.co","David3@m.co"));
//        accounts.add(Arrays.asList("David","David3@m.co","David4@m.co"));
//        accounts.add(Arrays.asList("David","David4@m.co","David5@m.co"));

        System.out.println(instance.accountsMerge(accounts));
    }

    public List<List<String>> accountsMergeInEfficient(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            Set<String> set = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                set.add(account.get(i));
            }
            if (map.size() > 0) {
                boolean flag = false;
                for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                    Set<String> tempSet = entry.getValue();
                    for (String email : set) {
                        if (tempSet.contains(email)) {
                            map.get(name).addAll(set);
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if (!flag) {
                    if (map.containsKey(name)) {
                        int counter = 1;
                        String tempName = name + "_" + counter;
                        while (map.containsKey(tempName)) {
                            counter++;
                            tempName = name + "_" + counter;
                        }
                        name = tempName;
                    }
                    map.put(name, set);
                }
            } else {
                map.put(name, set);
            }
        }

        return ans;
    }

    //https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
    //https://leetcode.com/problems/accounts-merge/discuss/140978/Easy-to-Understand-Union-Find-in-Java-95
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // array is initialized with the total size of accounts and each is given a unique id.
        // When the index of an array is equal to the value inside it, it means it is its own parent.
        // if it is different, it means that it has some other parent.
        // Basically we are mapping each account to its index. And at the start,
        // every account is its own parent.
        int[] parents = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            parents[i] = i;
        }
        // This hashmap contains the email to index mapping. We will use this map to find the particular
        // account when an email has already been found.
        Map<String, Integer> owners = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            // Traverse each List<String> from the first index i.e. skip first index which is the name
            // and just traverse on the emails
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                // The email in this account has already been registered before.
                if (owners.containsKey(email)) {
                    // Find that account's index
                    int person = owners.get(email);
                    // Find the parent of the account where our email in the map had been found
                    int p1 = findParent(parents, person);
                    // Find the parent of that current account
                    int p2 = findParent(parents, i);
                    // If they weren't already connected, then connect them. For connecting them,
                    // we would reassign the index of the account of where we found our email
                    // to the current account we are processing.
                    if (p1 != p2) {
                        parents[p2] = p1;
                    }
                } else {
                    // Otherwise just track it
                    owners.put(email, i);
                }
            }
        }

/* Now that we have our parents array ready where each index is either it's own parent of has some other account's index,
we need to merge all accounts who's parents are the same into one account.
The users map will contain index to TreeSet of email mapping.
Note that treeset sorts the elements inside it in natural level, therefore no need to worry about sorting when using this data structure.
For adding an element, it takes O(logn) operation. For n emails, it would take O(nlogn) and O(n) space.
*/
        Map<Integer, TreeSet<String>> users = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
// find the parent. If an element in the parent's array doesn't equal it's index, It's parent is different. Retrieve that id.
            int parent = findParent(parents, i);
// get all email's particular to the index right now. Note that this is not collecting the parent's email at al..
            List<String> emails = accounts.get(i);
// create the treeset if not already there for that parent
            users.putIfAbsent(parent, new TreeSet<String>());
// get the treeset from the parent, and add all the email excluding the emails in them.
            users.get(parent).addAll(emails.subList(1, emails.size()));
        }

// We not have a map with index and a treemap containing all the emails. Now we are Building final result.
        List<List<String>> res = new ArrayList<>();
        for (Integer idx : users.keySet()) {
// idx is the account id, get that particular account's name. We need to append it to our arraylist before returning it.
            String name = accounts.get(idx).get(0);
            ArrayList<String> emails = new ArrayList<>(users.get(idx));
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }

    // This method find's the parent of a particular index.
    private int findParent(int[] parents, int idx) {
        while (idx != parents[idx]) {
            parents[idx] = parents[parents[idx]];
            idx = parents[idx];
        }
        return parents[idx];
    }
}
