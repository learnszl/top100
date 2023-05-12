
import java.util.*;

public class pony {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        char[] arr = in.nextLine().toCharArray();
        Boolean[] flag = new Boolean[n];
        for (int i = 0; i < n; i++) {
            flag[i] = true;
        }
        int res = 0;
        char[] pony = new char[]{'p', 'o', 'n', 'y'};
        while (true) {
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (index >= 4) {
                    break;
                }
                if (arr[i] == pony[index] && flag[i]) {
                    flag[i] = false;
                    index++;
                }
            }
            if (index < 4) {
                break;
            } else {
                res++;
            }
        }
        System.out.println(res);
    }
}