import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        for(int i=0; i<n-1; i++) {
        	int j = i+1;
        	int temp = arr[j];
        	while(j>0 && temp < arr[j-1]) {
        		arr[j] = arr[j-1];
        		j--;
        	}
        	
        	arr[j] = temp;       	
        }
        System.out.println(Arrays.toString(arr));
	}

}
