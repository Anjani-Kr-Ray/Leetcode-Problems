
public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int splitArray(int[] nums, int m) {
		int start = 0, end = 0;
		
		for(int n: nums) {
			start = Math.max(start, n);
			end += n;
		}
		
		// binary search 
		int pieces = 0;
		while(start < end) {
			int mid = start + (end - start) / 2;
			
			int sum = 0;
			for(int num: nums) {
				if(sum + num > mid)
				{
					sum = num;
					pieces++;
				} else {
					sum += num;
				}
				
			}
			
			if(pieces > m) 
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return start;
	}

}
