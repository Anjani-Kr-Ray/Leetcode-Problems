import java.util.Scanner;

public class UniqueInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		// return true if even
		System.out.println(unique(arr));
	}
	
	public static int unique(int[] nums) {
		int unique = 0;
		
		for(int i: nums) {
			unique ^= i;
		}
		
		return unique;
	}

}
