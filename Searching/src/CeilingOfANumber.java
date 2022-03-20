import java.util.Scanner;

public class CeilingOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int t = sc.nextInt();
		System.out.println("Index of "+t+" : "+ceiling(arr, t));
	}
	
	public static int ceiling(int[] arr, int num) {
		
		if(num > arr[arr.length - 1])
			return -1;
		
		int l = 0, r = arr.length - 1;
		
		while(l<=r) {
			int mid = l + (r-l) / 2;
			if(arr[mid] == num)
				return mid;
			if(arr[mid] < num)
				l = mid + 1;
			else
				r = mid - 1;
		}
		
		return l;
	}
}

