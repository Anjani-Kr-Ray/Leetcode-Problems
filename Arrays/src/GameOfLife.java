// https://leetcode.com/problems/game-of-life/

import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {

	private static final int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, 
											   { 0, -1},          { 0, 1},
											   { 1, -1}, { 1, 0}, { 1, 1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] board = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		gameOfLifeBF(board);
		
		for(int[] arr: board) {
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	/* The bruteforce approach would be to take an extra matrix of same dimensions as that of given board
	 * and apply the rules given by Game Of Life and fill the new matrix. As its said inplace we have to 
	 * copy back the new matrix to board. But this approach takes extra space and is not an in-place
	 * approach 
	 * 
	 * Time Complexity: O(m*n)
	 * Space Complexity: O(m*n)*/
	public static int countLiveNeighbors(int[][] board,int m, int n, int i, int j) {
		int sum = 0;
		
		if(i-1 >= 0) {
			sum += board[i-1][j];
            
            if(j-1 >= 0) {
                sum += board[i-1][j-1];
            }
            
            if(j+1 < n) {
                sum += board[i-1][j+1]; 
            }
        }
        if(i+1 < m) {
            sum += board[i+1][j];
            
            if(j-1 >= 0)
                sum += board[i+1][j-1];
            
            if(j+1 < n)
                sum += board[i+1][j+1]; 
            
        }
        if(j-1 >= 0)
            sum += board[i][j-1];
        if(j+1 < n)
            sum += board[i][j+1];
		
		return sum;
	}
	
	public static void gameOfLifeBF(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] res = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int sum = countLiveNeighbors(board, m, n, i, j);
				if(board[i][j] == 1 && sum < 2)
					res[i][j] = 0;
				else if(board[i][j] == 1 && (sum >= 2 && sum <=3))
					res[i][j] = 1;
				else if(board[i][j] == 1 && sum > 3)
					res[i][j] = 0;
				else if(board[i][j] == 0 && sum == 3)
					res[i][j] = 1;
			}
		}
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				board[i][j] = res[i][j];
	}
	
	/* This is an in-place approach to this problem. The idea is to replace 0's and 1's to any number 
	 * between 0 and 3 based on the given chart:
	 * 
	 * Original |  New  | State
	 * ---------|-------|------
	 * 	   0    |   0   |   0  --> if dead cell doesn't have exactly three neighbors, then make no changes in the matrix
	 *     1    |   0   |   1  --> if live cell have more than three neighbors, then make no changes in the matrix
	 *     0    |   1   |   2  --> if dead cell have exactly three neighbors, change the cell value to 2 
	 *     1    |   1   |   3  --> if live cell have 2 or 3 neighbors, change the cell value to 3
	 *     
	 * */

	public static void gameOfLife(int[][] board) {
		// getting number of rows and columns
		int r = board.length;
		int c = board[0].length;

		// iterating through all numbers in matrices
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {

				// counting the neighbors
				int neighbors = countNeighbors(board, i, j);

				// checking if present element is live or dead
				if(board[i][j] == 1) {
					if(neighbors == 2 || neighbors == 3) 
						board[i][j] = 3;
				} else {
					if(neighbors == 3)
						board[i][j] = 2;
				}
			}
		}

		// To get the final state
		updateBoard(board, r, c);

	}

	private static void updateBoard(int[][] board, int rows, int cols) {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if(board[i][j] == 1)
					board[i][j] = 0;
				else if(board[i][j] == 2 || board[i][j] == 3) 
					board[i][j] = 1;
			}
	}

	private static int countNeighbors(int[][] board, int row, int col) {

		int count = 0;

		for (int[] dir : directions) {
			int rowNew = row + dir[0];
			int colNew = col + dir[1];

			if((!isOutOfBounds(board.length, board[0].length, rowNew, colNew))) 
				count += board[rowNew][colNew] & 1;
		}
		return count;
	}

	private static boolean isOutOfBounds(int rows, int cols, int x, int y) {
		return x < 0 || x >= rows || y < 0 || y >= cols;
	}
	
}
