// https://www.hackerearth.com/problem/algorithm/ants-on-the-circle-928dbbba/

import java.util.Arrays;
import java.util.Scanner;

public class AntsOnCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[m];

        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            x = (x-1 + y*t) % n;
            x = (x+n)%n;

            arr[i] = x;
        }

        Arrays.sort(arr);

        for(int i: arr) {
            System.out.print((i+1)+" ");
        }
	}

}
