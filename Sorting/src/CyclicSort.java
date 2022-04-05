import java.util.Arrays;
import java.util.Scanner;

public class CyclicSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        int i = 0;
        
        while(i<n) {
        	int correct = arr[i] - 1;
        	if(arr[i]==arr[correct])
        		i++;
        	else {
        		int temp = arr[i];
        		arr[i] = arr[correct];
        		arr[correct] = temp;
        	}	
        }
        
        System.out.println(Arrays.toString(arr));
	}

}
