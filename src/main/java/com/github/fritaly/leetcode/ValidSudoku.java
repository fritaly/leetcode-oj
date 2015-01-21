package com.github.fritaly.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int y = 0; y < 9; y++) {
			final Set<Character> digits = new TreeSet<>();

			for (int x = 0; x < 9; x++) {
				if (board[y][x] != '.') {
					if (!digits.add(board[y][x])) {
						return false;
					}
				}
			}
		}

		for (int x = 0; x < 9; x++) {
			final Set<Character> digits = new TreeSet<>();

			for (int y = 0; y < 9; y++) {
				if (board[y][x] != '.') {
					if (!digits.add(board[y][x])) {
						return false;
					}
				}
			}
		}

		for (int n = 0; n < 9; n++) {
			final Set<Character> digits = new TreeSet<>();

			for (int y = (n / 3) * 3; y < ((n / 3) + 1) * 3; y++) {
				for (int x = (n % 3) * 3; x < ((n % 3) + 1) * 3; x++) {

					if (board[y][x] != '.') {
						if (!digits.add(board[y][x])) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
}
