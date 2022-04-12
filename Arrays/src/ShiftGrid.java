// https://leetcode.com/problems/shift-2d-grid/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShiftGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] grid = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
	}
	
	public List<List<Integer>> shiftGridBF(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int p=0; p<k; p++) {
            int last = grid[rows-1][cols-1];
            for(int i=rows-1; i>=0; i--) {
                for(int j=cols-1; j>0; j--) {
                    grid[i][j] = grid[i][j-1];
                }
                
                if(i>0) {
                    grid[i][0] = grid[i-1][cols-1];
                } else {
                    grid[0][0] = last;
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<Integer>());
            for (int j = 0; j < cols; j++) {
                res.get(i).add(grid[i][j]);
            }
        }
        return res;
    }
    

    public List<List<Integer>> shiftGridFlattenGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        int total = m * n;
        k = k % total;
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            for (int j = 0; j < n; j++) {   
                // i * n + j original place index in 1D array
                // i * n + j - k  is to get value k steps before                 
                int index = ((i * n + j) - k + total) % total;
                list.add(grid[index / n][index % n]);
            }
        }
        
        return result;
        
    }
    
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++)// filling all the rows of result with empty lists
            result.add(new ArrayList<>());
        k %= (rows * col);// every rows*col shifts grid became the same, skipping the similar shifts
        int dimension = rows * col;
        int begin = dimension - k;// element at (begin) will be at 0,0 in new grid
        int x = 0;// counter variable
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;// calculating row and cell for new grid
            result.get(x / col).add(grid[r][c]);// adding new element in new row
            x++;
        }
        return result;// returning result list
    }

}
