// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllNoDisappeared {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(findDisappearedNumbers(arr));
	}
	
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> l = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        
        while(i<n) {
            int correct = arr[i] - 1;
            if(arr[i] == arr[correct])
                i++;
            else {
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            }
        }
        
        for(i=0; i<n; i++) {
            if(i!=(arr[i]-1))
                l.add(i+1);
        }
        
        return l;
    }

}
