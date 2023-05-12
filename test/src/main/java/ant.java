import java.util.Arrays;
import java.util.Scanner;

public class ant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();
        if(n == 0){
            System.out.println(0);
            return;
        }

        int[] arr =new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i-1] ^ (1 << (s.charAt(i-1) - 'a'));
        }

        long ret = 0;
        int[] cnt = new int[1<<26];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 26; j++){
                int tmp = arr[i] ^ (1 << j);
                ret += cnt[tmp];
            }
            cnt[arr[i]]++;
        }

        System.out.println(ret);
    }
}