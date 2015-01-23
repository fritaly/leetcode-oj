package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WordSearch {

	private static class Coords implements Comparable<Coords> {
		final int x, y;

		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coords other) {
			if (this.x == other.x) {
				return this.y - other.y;
			}

			return this.x - other.x;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (obj == this) {
				return true;
			}
			if (obj instanceof Coords) {
				final Coords other = (Coords) obj;

				return (this.x == other.x) && (this.y == other.y);
			}

			return false;
		}
	}

	private static boolean search(char[][] board, String word, int x, int y, Set<Coords> used) {
		if ("".equals(word)) {
			return true;
		}

		final char nextLetter = word.charAt(0);

		final List<Coords> candidates = new ArrayList<>();

		if (x > 0) {
			candidates.add(new Coords(x - 1, y));
		}
		if (x < board[y].length - 1) {
			candidates.add(new Coords(x + 1, y));
		}
		if (y > 0) {
			candidates.add(new Coords(x, y - 1));
		}
		if (y < board.length - 1) {
			candidates.add(new Coords(x, y + 1));
		}

		for (Coords candidate : candidates) {
			if (!used.contains(candidate) && (board[candidate.y][candidate.x] == nextLetter)) {
				final Set<Coords> used2 = new TreeSet<>(used);
				used2.add(candidate);

				if (search(board, word.substring(1), candidate.x, candidate.y, used2)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word) {
		final char initial = word.charAt(0);

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x] == initial) {
					if (search(board, word.substring(1), x, y, Collections.singleton(new Coords(x, y)))) {
						return true;
					}
				}
			}
		}

		return false;
	}
}