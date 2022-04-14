// https://leetcode.com/problems/spiral-matrix-ii/

import java.util.Scanner;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = generateMatrix(n);
		
		for(int i[]: arr) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        if (n == 0) {
            return res;
        }
        
        int row = n;
        int col = n;
        
        int rs = 0, cs = 0, re = row - 1, ce = col - 1, k = 1;
        
        while(cs <= ce && rs <= re) {
            for(int i=cs; i<=ce; i++)
                res[rs][i] = k++;
            rs++;

            for(int i=rs; i<=re; i++)
                res[i][ce] = k++;
            ce--;

            if (rs <= re)
                for(int i=ce; i>=cs; i--) 
                    res[re][i] = k++;
            re--;

            if (cs <= ce)
                for(int i=re; i>=rs; i--)
                    res[i][cs] = k++;
            cs++;
        }
        
        return res;
    }
	
	/* Optimized way of spiral traversal*/
	public int[][] generateMatrixOptimized(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int row = 0;
        int col = 0;
        while (cnt <= n * n) {
            result[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);

            // change direction if next cell is non zero
            if (result[r][c] != 0) d = (d + 1) % 4;

            row += dir[d][0];
            col += dir[d][1];
        }
        return result;
    }
}
