// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

import java.util.Scanner;

public class CellsWithOddValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println("Brute Force Method : "+oddCellsBruteForce(m, n, arr));
		// System.out.println("Optimized Method : "+oddCellsOptimized(m, n, arr));
	}

	public static int oddCellsBruteForce(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for(int[] a: indices) {
            int row = a[0];
            int col = a[1];
            
            for(int i=0; i<n; i++) {
                arr[row][i]++;
            }
            
            for(int i=0; i<m; i++) {
                arr[i][col]++;
            }
        }
        
        int count = 0;
        for(int[] i: arr) {
            for(int j: i) {
                if(j%2!=0)
                    count++;
            }
        }
        
        return count;
    }
	
	public static int oddCellsOptimized(int m, int n, int[][] indices) {
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        for(int[] index: indices) {
            row[index[0]] ^= true;
            col[index[1]] ^= true;
        }
        
        int rc = 0, cc = 0;
        for(boolean i: row) {
            if(i)
                rc++;
        }
        
        for(boolean i: col) {
            if(i)
                cc++;
        }
        
        return rc*n + cc*m - 2*rc*cc;
    }
}
