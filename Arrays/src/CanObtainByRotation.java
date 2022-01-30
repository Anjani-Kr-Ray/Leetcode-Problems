// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

import java.util.Scanner;

public class CanObtainByRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		int[][] target = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				target[i][j] = sc.nextInt();
		
		System.out.println(findRotation(arr, target));
	}
	
	public static boolean findRotation(int[][] mat, int[][] target) {
        
        if(mat.length!=target.length && mat[0].length!=target[0].length) {
            return false;
        }
        
        for(int i=0; i<4; i++) {
            if(checkSame(mat, target))
                return true;
            rotateBy90(mat);
        }
        
        return false;
    }
    
    public static void rotateBy90(int[][] mat) {
        
        for(int[] arr: mat) {
            int i = 0;
            int j = arr.length - 1;
            
            while(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }
        
        for(int i=0; i<mat.length; i++) {
            for(int j=i; j<mat[i].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    
    public static boolean checkSame(int[][] mat, int[][] target) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<target.length; j++) {
                if(mat[i][j]!=target[i][j])
                    return false;
            }
        }
        
        return true;
    }

}
