// https://leetcode.com/problems/container-with-most-water/



import java.util.Scanner;
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] height = new int[n];
		
		for(int i=0; i<n; i++) 
			height[i] = sc.nextInt();
		
		System.out.println(maxArea(height));
		
	}

	/* Brute Force Approach
	 * --------------------
	 * we will simply consider the area for every possible pair of the lines and find 
	 * out the maximum area out of those.
	 * 
	 * Time Complexity : O(n^2)
	 * Space Complexity : O(1)
	 * */
	
	public static int maxAreaBF(int[] height) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<height.length - 1; i++) {
			for(int j=i+1; j<height.length; j++) {
				max = Math.max(Math.min(height[i], height[j]) * (j-i), max);
			}
		}
		
		return max;
	}
	/* Two Pointers Approach
	 * ---------------------
	 * */
    public static int maxArea(int[] height) {
        
        int i = 0, j = height.length - 1;
        
        int max = Integer.MIN_VALUE;
        while(i<j) {
            
            int temp = (height[i]>height[j]?height[j]:height[i])*(j-i);
            if(temp > max) {
                max = temp;
            }
            
            if(height[i] > height[j])
                j--;
            else
                i++;
        }
        
        return max;
    }
}
