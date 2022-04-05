import java.util.Collections;
import java.util.List;

public class MinMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] minMax(List<Integer> arr) {
		
		int max = 0;
		int min = 0;
		
		int sum = arr.stream().mapToInt(i->i).sum();
		
		max = sum - Collections.min(arr);
		min = sum - Collections.max(arr);
		
		return new int[] {min, max};
	}

}
