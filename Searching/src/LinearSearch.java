import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		int target = sc.nextInt();
		
		System.out.println(linearSearch(arr, target));
	}
	
	public static int linearSearch(int[] arr, int target) {
		if(arr.length == 0) {
			return -1;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == target) 
				return i; 
		}
		
		return -1;
	}

}
