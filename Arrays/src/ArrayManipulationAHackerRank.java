import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulationAHackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<List<Integer>> l = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0; j<3; j++) {
				temp.add(j, sc.nextInt());
			}
			
			l.add(i, temp);
		}
		
		System.out.println(arrayManipulation(n, l));
	}
	
	public static long arrayManipulation(int n, List<List<Integer>> queries) {
	    // Write your code here
		int m = queries.size() + 1;
	    n = n+1;
	    int[][] arr = new int[m][n];
	        
	    for(int i=0; i<queries.size(); i++) {
	    	int a = queries.get(i).get(0);
	        int b = queries.get(i).get(1);
	        int k = queries.get(i).get(2);
	            
	        for(int j=a; j<=b; j++) {
	        	arr[i+1][j] += k;
	        	for(int p=i+2; p<m; p++)
	        		arr[p][j] += k;       
	        }
	    }
	    long max = 0;
	    for(int i=1; i<m; i++) {
	    	for(int j=1; j<n; j++) {
	    		if(max < arr[i][j])
	    			max = arr[i][j];
	        }
	    }
	    
	    return max;
	}

}
