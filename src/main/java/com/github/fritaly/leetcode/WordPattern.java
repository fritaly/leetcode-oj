package com.github.fritaly.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		final String[] words = str.split(" ");

		if (words.length == pattern.length()) {
			final Map<String, Set<Character>> wordsToLetters = new HashMap<String, Set<Character>>();
			final Map<Character, Set<String>> lettersToWords = new HashMap<Character, Set<String>>();
			
			int index = 0;
			
			for (String word : words) {
				char c = pattern.charAt(index++);
				
				if (!wordsToLetters.containsKey(word)) {
					wordsToLetters.put(word, new TreeSet<Character>());
				}
				if (!lettersToWords.containsKey(c)) {
					lettersToWords.put(c, new TreeSet<String>());
				}
				
				wordsToLetters.get(word).add(c);
				lettersToWords.get(c).add(word);
			}
			
			for (Set<Character> characters : wordsToLetters.values()) {
				if (characters.size() > 1) {
					return false;
				}
			}
			for (Set<String> strings : lettersToWords.values()) {
				if (strings.size() > 1) {
					return false;
				}
			}
			
			return true;
		}

		return false;
	}
}