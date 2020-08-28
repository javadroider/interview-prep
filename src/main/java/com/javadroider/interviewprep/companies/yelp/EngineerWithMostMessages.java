package com.javadroider.interviewprep.companies.yelp;

import java.util.*;

public class EngineerWithMostMessages {


    public static void main(String[] args) {
        //a->b
        //c->b
        //d->b
        Map<String, Data> map = new HashMap<>();
        String[] json = {"a:b", "c:b", "d:b", "c:d"};
        for (String str : json) {
            String[] tokens = str.split(":");
            String from = tokens[0];
            String to = tokens[1];
            if (from.equalsIgnoreCase(to)) {
                continue;
            }
            if (map.containsKey(to)) {
                map.get(to).count++;
            } else {
                map.putIfAbsent(to, new Data(to, 1));
            }
        }
        List<Data> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(new ArrayList<>(map.values()), new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Integer.compare(o1.count, o2.count);
            }
        });
        for (Data data : list) {
            System.out.println(data);
        }

    }

    private static class Data {
        private String name;
        private int count;

        public Data(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return count == data.count &&
                    Objects.equals(name, data.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, count);
        }

        @Override
        public String toString() {
            return name + ":" + count;
        }
    }
}
