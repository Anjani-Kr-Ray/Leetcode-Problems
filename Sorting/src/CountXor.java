// https://www.hackerearth.com/problem/algorithm/shubham-and-xor-8526868e/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountXor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        HashMap<Long, Long> hs= new HashMap<>();
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
            hs.put(arr[i], hs.getOrDefault(arr[i], 0L)+1);
        }
        long count = 0;
        for(Map.Entry<Long, Long> e: hs.entrySet()) {
            long x = e.getValue();
            count += (x*(x-1)) / 2;
        }
        System.out.println(count);
	}

}
