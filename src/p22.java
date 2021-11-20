import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/11/20 21:43
 * @Description
 */
public class p22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(0, 0, new StringBuffer(), res, n);
        return res;
    }

    private void dfs(int leftCount, int rightCount, StringBuffer sb, List<String> res, int n) {
        if (leftCount + rightCount == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (leftCount < n) {
            sb.append('(');
            dfs(leftCount + 1, rightCount, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightCount < leftCount) {
            sb.append(')');
            dfs(leftCount, rightCount + 1, sb, res, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        p22 p22 = new p22();
        System.out.println(p22.generateParenthesis(3));
    }
}
