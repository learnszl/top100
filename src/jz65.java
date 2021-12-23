/**
 * @Author szl
 * @Date 2021/11/28 16:45
 * @Description
 */
public class jz65 {
    public int add(int a, int b) {
        while (b !=0){
            int x  = (a & b) << 1;
            System.out.println("x  " + x);
            a ^= b;
            System.out.println("a  " + a);
            b = x;
        }
        return a;


    }

    public static void main(String[] args) {
        jz65 jz65 = new jz65();
        System.out.println(jz65.add(5,7));
    }
}
