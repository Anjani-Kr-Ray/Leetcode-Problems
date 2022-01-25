// https://leetcode.com/problems/flipping-an-image/

import java.util.Scanner;

public class FlippingAnImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
				arr[i][j] = sc.nextInt();
		
		arr = flipAndInvertImage(arr);
		
		for(int[] i: arr) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] arr: image) {
            int i = 0;
            int j = arr.length-1;
            
            while(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j--;
            }
        }
        
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                image[i][j]^=1;
            }
        }
        
        return image;
    }

}
