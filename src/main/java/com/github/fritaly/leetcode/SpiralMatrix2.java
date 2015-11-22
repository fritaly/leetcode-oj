package com.github.fritaly.leetcode;

public class SpiralMatrix2 {
    
	private static class Point {
		final int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		boolean exists(int n) {
			return ((0 <= x) && (x < n)) && ((0 <= y) && (y < n));
		}
	}
	
	private static enum Direction {
		RIGHT, LEFT, UP, DOWN;
		
		Direction next() {
			switch (this) {
			case RIGHT:
				return DOWN;
			case DOWN:
				return LEFT;
			case LEFT:
				return UP;
			case UP:
				return RIGHT;
			default:
				throw new UnsupportedOperationException();
			}
		}
		
		Point nextPoint(Point p) {
			switch (this) {
			case RIGHT:
				return new Point(p.x + 1, p.y);
			case DOWN:
				return new Point(p.x, p.y + 1);
			case LEFT:
				return new Point(p.x - 1, p.y);
			case UP:
				return new Point(p.x, p.y - 1);
			default:
				throw new UnsupportedOperationException();
			}
		}
	}
	
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		
		final int[][] matrix = new int[n][n];
		
		Direction direction = Direction.RIGHT;
		
		int i = 1;
		Point p = new Point(0, 0);
		
		do {
			System.err.println(i);
			
			matrix[p.y][p.x] = i++;
			
			final Point nextPoint = direction.nextPoint(p);
			
			if (!nextPoint.exists(n) || matrix[nextPoint.y][nextPoint.x] != 0) {
				direction = direction.next();
			}
			
			p = direction.nextPoint(p);
		} while (i <= n * n);
		
		return matrix;
    }
}