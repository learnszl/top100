
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Exam {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int min = Integer.MAX_VALUE;
        int[] nums = new int[n];
        String str = in.nextLine();
        String[] s = str.split(" ");
        for (int i = 0; i < n ; i++) {
            nums[i] = Integer.parseInt(s[i]);
            if (nums[i] < min){
                min = nums[i];
            }
        }
        System.out.println(min + new Random().nextInt(20));

    }
    private static boolean helper(long n,long x){
        String str = String.valueOf(n);
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return n + x == Integer.parseInt(sb.toString());
    }
}