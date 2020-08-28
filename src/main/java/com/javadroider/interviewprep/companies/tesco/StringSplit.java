package com.javadroider.interviewprep.companies.tesco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class StringSplit {
	public static void main(String[] args) {
		//System.out.println("Hello World!");

		// break line into multiple lines of length n
		// if nth character

		String input = "This is Tesco interview";
		int N = 10;
		StringSplit instance = new StringSplit();
		System.out.println("Expected : " + 3 + ", Received: " + instance.splitString("This is Apple", 3).size());
		//System.out.println("Expected : " + 1 + ", Received: " + instance.splitString("", 4).size());
		//System.out.println("Expected : " + 0 + ", Received: " + instance.splitString(null, 4).size());

	}

	public List<String> splitString(String str, int n) {
		List<String> list = new ArrayList<String>();
		if(str == null) {
			return list;
		}
		
		if(str.length() == 0) {
			return list;
		}
		
		
		int start = 0;
		while (start + n < str.length()) {
			int newEnd = start + n;
			String word = str.substring(start, newEnd);
			int len = word.length() - 1;
			while(len > 0 && word.charAt(len) != ' ') {
				len--;//need to add word to new line
			}
			newEnd = start + len + 1;
			word = str.substring(start, newEnd);
			list.add(word);
			start = newEnd;
		}
		
		list.add(str.substring(start));
		System.out.println(list);
		return list;
	}

	public List<String> splitString1(String str, int n) {
		List<String> list = new ArrayList<String>();
		if (str == null) {
			return list;
		}

		if (str.length() == 0) {
			list.add("");
			return list;
		}

		String[] tokens = str.split("\\s");
		int currentCharacterCount = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tokens.length; i++) {
			String word = tokens[i];
			if (currentCharacterCount + word.length() < n) {
				sb.append(word).append(" ");
				currentCharacterCount += word.length();
			} else {
				list.add(sb.toString());
				sb = new StringBuilder();
				currentCharacterCount = 0;
			}
		}

		return list;

	}

}
