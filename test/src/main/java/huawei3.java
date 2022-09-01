import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author szl
 * @Date 2022/4/6 20:07
 * @Description
 */
public class huawei3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        if (n < len) {
            System.out.println(0);
        }
        String[] split = scanner.nextLine().split(",");
        int[] deep = new int[n];
        for (int i = 0; i < n; i++) {
            deep[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(deep));
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (deep[i] < 0) {
                total += (-deep[i]);
            }
        }
        if (len == 1) {
            System.out.println(total);
        }
        int start = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (deep[i] >= 0) {
                res += (i - start) / len;
                start = i + 1;
            }
        }
        res += (n - start) / len;
        System.out.println(res);
    }
}
