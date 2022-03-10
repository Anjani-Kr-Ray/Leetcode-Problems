// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(spiralOrder(arr));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> l = new ArrayList<>();
        
        if (matrix.length == 0) {
            return l;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int rs = 0, cs = 0, re = row - 1, ce = col - 1;
        
        while(cs <= ce && rs <= re) {
            for(int i=cs; i<=ce; i++)
                l.add(matrix[rs][i]);
            rs++;

            for(int i=rs; i<=re; i++)
                l.add(matrix[i][ce]);
            ce--;

            if (rs <= re)
                for(int i=ce; i>=cs; i--) 
                    l.add(matrix[re][i]);
            re--;

            if (cs <= ce)
                for(int i=re; i>=rs; i--)
                    l.add(matrix[i][cs]);
            cs++;
        }
        
        return l;
    }

}
