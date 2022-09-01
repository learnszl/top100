/**
 * @Author szl
 * @Date 2022/3/22 18:53
 * @Description
 */
public class jz67 {
    public int strToInt(String str) {
        String s = str.trim();
        if (s.length() == 0)
            return 0;
        char c = s.charAt(0);
        int i = 0, res = 0;
        boolean negative = false;
        if (c == '-')
            negative = true;
        if (c == '+' || c == '-')
            i++;
        while (i < s.length()) {
            char temp = s.charAt(i);
            if (!Character.isDigit(temp)) {
                break;
            } else {
                if (res >= Integer.MAX_VALUE / 10)
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                else {
                    res = res * 10 + temp - '0';
                }
            }
            i++;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        jz67 jz67 = new jz67();
        System.out.println(jz67.strToInt("43"));
    }
}
