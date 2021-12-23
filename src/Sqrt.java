public class Sqrt {
    public double sqrt(int x) {
        double acc = 0.000001;
        double l = 0.0, r = x;
        while (r - l > acc) {
            double mid = l + (r - l) / 2 + acc;
            if (mid * mid <= x) {
                l = mid;
            } else
                r = mid - acc;
        }
        return r;
    }

    public double sqrt1(int x) {
        double first = x, acc = 0.000001;
        double second = first / 2.0 + x / (2.0 * first);
        while (Math.abs(first - second) > acc) {
            first = second;
            second = second / 2.0 + x / (2.0 * second);
//            System.out.println("f:" + first);
//            System.out.println("s:" + second);
        }
        return second;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        long startTime = System.currentTimeMillis();
        System.out.printf("%.6f", sqrt.sqrt(1000));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}