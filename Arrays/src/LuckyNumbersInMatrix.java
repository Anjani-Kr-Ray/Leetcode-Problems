// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyNumbersInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(luckyNumbers(arr));
	}
	
	public static List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> l = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] row = new int[m];
        int[] col = new int[n];
        
        for(int i=0; i<m; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if(matrix[i][j] < min) 
                    min = matrix[i][j];
            }
            row[i] = min;
        }
        
        for(int i=0; i<n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=0; j<m; j++) {
                if(matrix[j][i] > max)             
                    max = matrix[j][i];
            }
            col[i] = max;
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] <= row[i] && matrix[i][j] >= col[j]) {
                    l.add(matrix[i][j]);
                }
            }
        }
        
        return l;
    }

}
