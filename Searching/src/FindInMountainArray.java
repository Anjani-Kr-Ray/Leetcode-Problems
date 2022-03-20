// https://leetcode.com/problems/find-in-mountain-array/

import java.util.Scanner;

interface MountainArray {
	public int get(int index);
	public int length();
}

class Array implements MountainArray {
	private int[] arr;
	Array(int[] arr) {
		this.arr = arr;
	}
	
	public int get(int index) {
		return arr[index];
	}
	
	public int length() {
		return arr.length;
	}
}

public class FindInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		MountainArray m = new Array(arr);
		System.out.println("Index of "+t+" : "+findInMountainArray(t, m));

	}
	public static int findInMountainArray(int target, MountainArray A) {
        
        int left = 0, right = A.length() - 1;
        // Find the peak index
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < A.get(mid + 1)) {
                left = mid + 1;
            } else { 
                right = mid;
            }
        }
        int peak = left;
        
        // Binary search on increasing subarray
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < target) {
                left = mid + 1;
            } else if (A.get(mid) > target) { 
                right = mid - 1;
            } else {
                return mid;
            }
        }
        
        // Binary search on decreasing subarray
        left = peak;
        right = A.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A.get(mid) < target) {
                right = mid - 1;
            } else if (A.get(mid) > target) { 
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
        
    }
	
}
