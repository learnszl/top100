/**
 * @Author szl
 * @Date 2021/12/24 21:44
 * @Description
 */
public class p1093 {
    /**
    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        int sum = 0, max = 0;
        for (int i = 0; i < 256; i++) {
            sum += count[i];
            if (count[i] > max) {
                max = i;
            }
        }
        res[4] = max;
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                res[0] = i;
                break;
            }
        }
        for (int i = 255; i >= 0; i--) {
            if (count[i] != 0) {
                res[1] = i;
                break;
            }
        }
        int arv = 0, temp = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                temp += i * count[i];
                arv += temp / sum;
                temp = temp % sum;
            }
        }
        res[2] = (double) arv + (double) temp / sum;
        int i = 0, j = 255, l = 0, r = 0;
        while (true) {
            if (l < r) {
                i++;
                l += count[i];
            } else if (l > r) {
                j--;
                r += count[j];
            } else {
                i++;
                j--;
                l += count[i];
                j += count[j];
            }
            if (i == j) {
                res[4] = i;
                break;
            }
            if (i > j) {
                res[4] = (i + j) / 2.0;
                break;
            }
        }
        return res;
    }
     */
}
