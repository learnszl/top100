import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2022/1/8 11:57
 * @Description
 */
public class p89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }


    public static void main(String[] args) {
        p89 p89 = new p89();
        System.out.println(p89.grayCode(3));
        System.out.println(p89.grayCode1(3));
    }
}
