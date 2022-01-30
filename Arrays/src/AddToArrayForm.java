// https://leetcode.com/problems/add-to-array-form-of-integer/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddToArrayForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		int k = sc.nextInt();
		
		System.out.println(addToArrayForm(arr, k));
	}
	
	public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> l = new ArrayList<>();
        
        for(int i=num.length - 1; i>=0; i--) {
            int sum = num[i] + k;
            l.add(0, sum%10);
            k = sum / 10;
        }
        
        while(k!=0) {
            l.add(0, k%10);
            k /= 10;
        }
        
        return l;
    }

}
