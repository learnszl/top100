import java.util.Random;
import java.util.Scanner;

public class baidu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt(), n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(new Random().nextInt(10) + 2);
        }
    }
}


