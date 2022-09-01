
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            System.out.println(helper1(s));
//            if (helper(s)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
        }
    }

    private static String helper1(String[] s) {
        for (int i = 0; i < 6; i++) {
            if (s[i].equals("A"))
                s[i] = "8";
        }
        int[] alice = new int[3];
        int[] bob = new int[3];
        int amax = 1;
        int bmax = 1;
        for (int i = 0; i < 3; i++) {
            alice[i] = Integer.parseInt(s[i]);
            bob[i] = Integer.parseInt(s[i + 3]);
        }
        Arrays.sort(alice);
        Arrays.sort(bob);
//        System.out.println(Arrays.toString(alice));
//        System.out.println(Arrays.toString(bob));
        for (int i = 1; i < 3; i++) {
            if (alice[i] == alice[i - 1]) {
                amax++;
            }
            if (bob[i] == bob[i - 1]) {
                bmax++;
            }
        }
        if (amax > bmax) {
            return "Alice";
        } else if (amax < bmax) {
            return "Bob";
        } else if (amax == 2) {
            if (alice[0] == alice[1]) {
                int temp = alice[0];
                alice[0] = alice[2];
                alice[2] = temp;
            }
            if (bob[0] == bob[1]) {
                int temp = bob[0];
                bob[0] = bob[2];
                bob[2] = temp;
            }
            for (int i = 2; i >= 0; i--) {
                if (alice[i] > bob[i]) {
                    return "Alice";
                } else if (alice[i] < bob[i]) {
                    return "Bob";
                }
            }
        } else {
            for (int i = 2; i >= 0; i--) {
                if (alice[i] > bob[i]) {
                    return "Alice";
                } else if (alice[i] < bob[i]) {
                    return "Bob";
                }
            }
        }
        return "Tie";
    }

    private static boolean helper(String s) {
        if (s.length() < 6)
            return false;
        int nd = 0, nc = 0;
        char pre = '!';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                nd++;
                cnt = 0;
            } else {
                nc++;
                cnt++;
                if (cnt == 5)
                    return false;
            }
            if (c == pre) {
                return false;
            } else {
                pre = c;
            }
        }
        return nd < nc;
    }
}
