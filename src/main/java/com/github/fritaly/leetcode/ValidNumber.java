package com.github.fritaly.leetcode;

public class ValidNumber {

	public boolean isNumber(String s) {
		if ((s == null) || "".equals(s.trim())) {
			return false;
		}

		s = s.trim();

		return s.matches("[+-]?[\\d]+(e[+-]?[\\d]+)?") || s.matches("[+-]?[\\d]+\\.[\\d]*(e[+-]?[\\d]+)?") || s.matches("[+-]?\\.[\\d]+(e[+-]?[\\d]+)?");
	}
}
