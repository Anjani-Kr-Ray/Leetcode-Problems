// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<removeDuplicates(arr); i++) {
			System.out.print(arr[i]+" ");
		}
	}

    public static int removeDuplicates(int[] nums) {
        int i = 0, j=0;
        
        while(j!=nums.length) {
            if(nums[i]!=nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        
        return i+1;
    }
}
