package com.perimeter;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int element = grid[i][j];
				if(element == 1) {
					perimeter += 4;
					
					//checking neighbors
					List<List<Integer>> neighbors = getNeighbors(i,j, rows, cols, grid);
					perimeter -= neighbors.size();
				}
			}
		}
        return perimeter;
    }
	
	private List<List<Integer>> getNeighbors(int row, int col, int maxRow, int maxCol, int[][] grid) {
		List<List<Integer>> neighbors = new ArrayList<>();
		
		//adding left point
		int leftRow = row;
		int leftCol = col - 1;
		
		if(isValidPoint(leftRow, leftCol, maxRow, maxCol, grid)) {
			ArrayList<Integer> leftPoint = new ArrayList<>();
			leftPoint.add(leftRow);
			leftPoint.add(leftCol);
			neighbors.add(leftPoint);
		}
		
		//adding right point
		int rightRow = row;
		int rightCol = col + 1;
		
		if(isValidPoint(rightRow, rightCol, maxRow, maxCol, grid)) {
			ArrayList<Integer> rightPoint = new ArrayList<>();
			rightPoint.add(rightRow);
			rightPoint.add(rightCol);
			neighbors.add(rightPoint);
		}
		
		
		//adding top point
		int topRow = row - 1;
		int topCol = col;
		
		if(isValidPoint(topRow, topCol, maxRow, maxCol, grid)) {
			ArrayList<Integer> topPoint = new ArrayList<>();
			topPoint.add(topRow);
			topPoint.add(topCol);
			neighbors.add(topPoint);
		}
		
		//adding bottom point
		int bottomRow = row + 1;
		int bottomCol = col;
		
		if(isValidPoint(bottomRow, bottomCol, maxRow, maxCol, grid)) {
			ArrayList<Integer> bottomPoint = new ArrayList<>();
			bottomPoint.add(bottomRow);
			bottomPoint.add(bottomCol);
			neighbors.add(bottomPoint);
		}		
		
		return neighbors;
	}

	private boolean isValidPoint(int row, int col, int maxRow, int maxCol, int[][] grid) {
		boolean valid = false;
		if( (row >= 0) && (row < maxRow) ) {
			if( (col >= 0) && (col < maxCol) ) {
				if(grid[row][col] == 1)
				valid = true;
			}
		}
		return valid;
	}

	public static void main(String[] args) {
		Main obj = new Main();
		int[][] grid = new int[][] {{0,1,0,0},
		                             {1,1,1,0},
		                             {0,1,0,0},
		                             {1,1,0,0}};
		System.out.println(obj.islandPerimeter(grid));
	}

}
