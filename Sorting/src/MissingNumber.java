// https://leetcode.com/problems/missing-number/

import java.util.Scanner;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(missingNumber(arr));
	}
	
	public static int missingNumber(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i<n) {
            if(arr[i] == n || i==arr[i]) 
                i++;
            else {
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            } 
        }   
        
        for(int j=0; j<n; j++) {
            if(j!=arr[j])
                return j;
        }
        
        return n;
    }

}
