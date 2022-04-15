import java.util.Scanner;
public class IsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(isSorted(arr, 0));
	}
	
	public static boolean isSorted(int[] arr, int index) {
		if(index == arr.length - 1)
			return true;
		
		if(arr[index] < arr[index+1])
			return isSorted(arr, index+1);
		else
			return false;
		
	}

}
