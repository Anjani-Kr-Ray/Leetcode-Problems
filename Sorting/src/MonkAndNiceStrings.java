import java.util.Scanner;

public class MonkAndNiceStrings {
	static void compare(String[]arr, int size) {
        for(int i = 0; i<arr.length; i++){
            int count = 0;
            for(int j = i-1; j>-1; j--){
                if(arr[i].compareTo(arr[j]) > 0){
                    count = count+1;
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String[] arr = new String[size];
        for(int i = 0; i<size; i++){
            String ch = s.next();
            arr[i] = ch;
        }
        compare(arr, size);
    }
}
