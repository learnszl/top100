import java.util.Arrays;

public class Kmp {
    public int kmp(String s, String p) {
        int m = s.length(), n = p.length();
        int[] next = new int[n];
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pp[i] != pp[j]) {
                j = next[j - 1];
            }
            if (pp[i] == pp[j])
                j++;
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && ss[i] != pp[j]) {
                j = next[j - 1];
            }
            if (ss[i] == pp[j])
                j++;
            System.out.println("i:" + i + " j:" + j);
            if (j == n)
                return i - n + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        System.out.println(kmp.kmp("hellolla", "lla"));
    }
}
