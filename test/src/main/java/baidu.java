
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class baidu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        int numsFor = 0, res = 0;
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().trim().split(" ");
            System.out.println(s[0]);
            if (s[0].equals("for")) {
                stack.add("for");
                numsFor++;
            } else if (s[0].equals("if")) {
                stack.add("if");
                res = Math.max(res, numsFor - 1);
                numsFor = 0;
            } else if (s[0].equals("}")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        System.out.println(numsFor);
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] s = scanner.nextLine().split(" ");
//        int[] monster = new int[n];
//        long res = 0;
//        for (int i = 0; i < n; i++) {
//            monster[i] = Integer.parseInt(s[i]);
//            res += monster[i];
//        }
//        for (int i = 0; i < n - 2; i++) {
//            while (monster[i] >= 1 && monster[i + 1] >= 2 && monster[i + 2] >= 3) {
//                monster[i] -= 1;
//                monster[i + 1] -= 2;
//                monster[i + 2] -= 3;
//                res--;
//            }
//        }
//        System.out.println(res);
//    }
}


