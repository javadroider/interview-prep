package com.javadroider.interviewprep.lru;

import java.util.LinkedHashMap;

public class UsingLinkedHashMap {

	public static void main(String[] args) {
		MyMap lruCache = new MyMap(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		System.out.println(lruCache);
		lruCache.put(2, 2);
		System.out.println(lruCache);
	}

	static class MyMap extends LinkedHashMap<Integer, Integer> {

		private int capacity;

		public MyMap(int capacity) {
			this.capacity = capacity;
		}

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
			return size() > capacity;
		}
	}
}
