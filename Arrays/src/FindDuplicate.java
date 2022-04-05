import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* Method 1: Sorting
	 * *****************
	 * In an unsorted array, duplicate elements may be scattered across the array. However, in a sorted
	 * array, duplicate numbers will be next to each other.
	 * 
	 * So, sort the array. Iterate through the array, comparing the current element with the next element.
	 * Return the first number equal to its successor.
	 * 
	 * Time Complexity : O(n log n)
	 * Space Complexity : O(log n) or O(n)
	 * 
	 * Note: Java Arrays.sort() uses variant of quick sort algorithm, which has a space complexity of O(log n)
	 * 		 C++ sort() uses hybrid of Quick Sort, Insertion sort and Heap sort, so space complexity is O(log n) in worst case
	 *       Python sort() is implemented using TimSort Algorithm which has worst case space complexity of O(n)*/
	public static int findDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        
        return -1;
    }
    
	/* Method 2: Set
	 * *************
	 * Iterate through the array and add elements to the set provided the element is not present in the 
	 * set. If element is already present then return that element.
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 * */
    public static int findDuplicateSet(int[] nums) {
        Set<Integer> s = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            if(s.contains(nums[i]))
                return nums[i];
            s.add(nums[i]);
        }
         
        return -1;
    }
    
    /* Method 3: Negative Marking
     * **************************
     * Since the array only contains positive integers, we can track each number (num) that has been seen
     * before by flipping the sign of the number located at index |num|.
     * 
     * For example, if the input array is [1, 3, 3, 2], then for 1, flip the number at index 1, making 
     * the array [1,-3,3,2]. Next, for −3 flip the number at index 33, making the array [1,−3,3,−2]. 
     * Finally, when we reach the second 33, we'll notice that nums[3] is already negative, 
     * indicating that 3 has been seen before and hence is the duplicate number.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public static int findDuplicateNegativeMarking(int[] nums) {
        int n = nums.length; 
        int duplicate = -1;
        for(int i=0; i<n; i++) {
            int curr = Math.abs(nums[i]);
            
            if(nums[curr] < 0) {
                duplicate = curr;
                break;
            }
            
            nums[curr] *= -1;
        }
        
        return duplicate;
    }

}
