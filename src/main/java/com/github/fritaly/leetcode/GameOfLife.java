package com.github.fritaly.leetcode;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        final int[][] grid = new int[board.length][board[0].length];
        
        for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				int neighbours = 0;
				
				if (y - 1 >= 0) {
					if (x - 1 >= 0) {
						neighbours += board[y-1][x-1];
					}
					neighbours += board[y-1][x];
					if (x + 1 < board[y].length) {
						neighbours += board[y-1][x+1];					
					}
				}
				{
					if (x - 1 >= 0) {
						neighbours += board[y][x-1];
					}
					if (x + 1 < board[y].length) {
						neighbours += board[y][x+1];
					}
					
				}
				if (y + 1 <= board.length - 1) {
					if (x - 1 >= 0) {
						neighbours += board[y+1][x-1];
					}
					neighbours += board[y+1][x];
					if (x + 1 < board[y].length) {
						neighbours += board[y+1][x+1];
					}
				}
				
				if (board[y][x] == 1) {
					if (neighbours < 2) {
						grid[y][x] = 0;
					} else if ((2 <= neighbours) && (neighbours <= 3)) {
						grid[y][x] = board[y][x];
					} else if (neighbours > 3) {
						grid[y][x] = 0;
					}	
				} else {
					if (neighbours == 3) {
						grid[y][x] = 1;
					} else {
						grid[y][x] = 0;
					}
				}
			}
		}
        
        for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = grid[y][x];
			}
        }
    }
}