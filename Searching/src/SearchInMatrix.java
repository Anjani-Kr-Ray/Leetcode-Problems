import java.util.Arrays;
import java.util.Scanner;

public class SearchInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][] matrix = new int[m][n];
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				matrix[i][j] = sc.nextInt();
		
		int target = sc.nextInt();
		
		System.out.println(Arrays.toString(binarySearchInMatrix(matrix, target)));
	}
	
	/* Method 1: Linear Search
	 * -----------------------
	 * When an unsorted matrix is given then we are left with no choice. We have to perform linear search
	 * on the matrix. If found return an array containing row and col else return array with {-1, -1}
	 * as value.
	 * 
	 * Time Complexity : O(m*n)
	 * Space Complexity : O(1)*/
	public static int[] linearSearch(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(matrix[i][j] == target) 
					return new int[] {i, j};
			}
		}
		
		return new int[] {-1,-1};
	}

	/* Method 2: Reduce Search Space
	 * -----------------------------
	 * Will only work if matrix is sorted row and column wise. The idea is to reduce the search space.
	 * We will assign two pointer (start & end) one pointing to first row (start) and another pointing 
	 * to last column (end). Now there are three cases that can occur: 
	 * 
	 * case 1: Element at {start, end} is the target element. In this case we will return start and end
	 * 
	 * case 2: Element at {start, end} is greater than target element. As we know the matrix is sorted 
	 * 		   column wise so there is no chance for the target element to exist after the current element
	 *         (since all the elements after the current element are greater than it). So we will reduce
	 *         end by 1.
	 * 
	 * case 3: Element at {start, end} is less than target element. As we know the matrix is sorted row 
	 *         wise so there is no chance for the target element to exist before the current element
	 *         (since all the elements before the current element are smaller than it). So we will increase
	 *         start by 1.
	 * 
	 * Time Complexity : O(m+n)
	 * Space Complexity : O(1)
	 * */
	public static int[] searchByReducingSpace(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		int start = 0, end = col - 1;
		
		while(start < row && end >= 0) {
			if(matrix[start][end] == target) 
				return new int[] {start, end};
			else if(matrix[start][end] > target) 
				end--;
			else
				start++;
		}
		
		return new int[] {-1,-1};
	}
	
	/* Method 3: Binary Search
	 * -----------------------
	 * Will only work if the matrix is strictly sorted. The idea is to find the mid column and then
	 * do binary search as well as reduce the search space. Let us take an example:
	 * 
	 * Target = 2
	 * 				cs        ce
	 * 	      rs ->	 1   2  3  4 
	 * 		 		 5   6  7  8
	 * 		 		 9  10 11 12
	 * 	      re ->	13  14 15 16
	 * 
	 * 		cmid = col / 2 = 1
	 * 
	 * After finding the mid column we will do binary search in it. 
	 * 		rmid = rs + (re - rs) / 2 = 1  --> matrix[rmid][cmid] = 6 > 2
	 * As we can see that element at mid is greater than the target we will reduce the search space i.e., 
	 * we will bring re to rmid. Had the target been greater than 6 we would have brought rs to rmid
	 * 
	 * Now this process will repeat till there are two rows remaining. When there will be two rows left first
	 * we will check if matrix[rs][cmid] == target. If true we will return the indexes else we will check if
	 * matrix[re][cmid] == target. If true we will return the indexes else we will be left with four parts.
	 * 
	 * 1. matrix[rs][0] to matrix[rs][cmid-1]
	 * 2. matrix[rs][cmid+1] to matrix[rs][ce]
	 * 3. matrix[re][0] to matrix[re][cmid-1]
	 * 4. matrix[re][cmid+1] to matrix[rs][ce]
	 * 
	 * We will apply binary search in all the parts one by one. If found return the indexes else continue searching
	 * in other parts. If not found in any of these four part then target element doesn't exists in the matrix
	 * hence return {-1, -1}
	 * 
	 * Time Complexity: O(log n + log m)
	 * Space Complexity: O(1)
	 * 
	 * */
	public static int[] binarySearch(int[][] arr, int target, int row, int l, int r) {
		
		while(l<=r) {
			int mid = l + (r - l) / 2;
			
			if(arr[row][mid] == target)
				return new int[] {row, mid};
			if(arr[row][mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		
		return new int[] {-1,-1};
	}
	
	public static int[] binarySearchInMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		if(row == 1) {
			return binarySearch(null, target, 0, 0, col-1);
		}
		
		int rStart = 0, rEnd = row - 1, midCol = col / 2;
		
		while(rStart < rEnd - 1) {
			int midRow = rStart + (rEnd - rStart) / 2;
			
			if(matrix[midRow][midCol] == target) 
				return new int[] {midRow, midCol};
			else if(matrix[midRow][midCol] > target)
				rEnd = midRow;
			else
				rStart = midRow;
		}
		
		// Now we have 2 rows left
		if(matrix[rStart][midCol] == target)
			return new int[] {rStart, midCol};

		if(matrix[rEnd][midCol] == target)
			return new int[] {rEnd, midCol};
		
		// If not found then search in remaining four parts
		if(target <= matrix[rStart][midCol-1])
			return binarySearch(matrix, target, rStart, 0, midCol-1);
		
		if(target >= matrix[rStart][midCol+1] && target <= matrix[rStart][col-1])
			return binarySearch(matrix, target, rStart, midCol+1, col-1);
		
		if(target <= matrix[rEnd][midCol-1])
			return binarySearch(matrix, target, rEnd, 0, midCol-1);
		
		if(target >= matrix[rEnd][midCol+1] && target <= matrix[rStart][col-1])
			return binarySearch(matrix, target, rStart, midCol+1, col-1);
		
		return new int[] {-1,-1};
	}
	
}
