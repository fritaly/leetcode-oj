package com.github.fritaly.leetcode;

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		final String[] words = s.split("[ ]+");

		return (words.length > 0) ? words[words.length - 1].length() : 0;
	}
}