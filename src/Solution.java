import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Math.min(A[i], B[i]));
        }
        for (int i = 1; i <= 100000; i++) {
            if (!set.contains(i))
                return i;
        }
        return 100001;
    }

    public int solution(int[] A, int M) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            boolean f = true;
            if (!map.isEmpty()) {
                for (Integer key : map.keySet()) {
                    if (Math.abs(key - A[i]) % M == 0) {
                        map.get(key).add(A[i]);
                        f = false;
                        break;
                    }
                }
            }
            if (f) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(A[i]);
                map.put(A[i], list);
            }
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            res = Math.max(map.get(key).size(), res);
        }
        return res;
        // write your code in Java 8 (Java SE 8)
    }
    public int solution(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length,res = 0;
        for (int i = 0; i < n; i++) {
            int[] fre = new int[26];
            fre[chars[i] - 'a']++;
            for (int j = i + 1; j <= n; j++) {
                fre[chars[j] - 'a']++;
                boolean f = true;
                for (int k = 0; k < 26; k++) {
                    if (fre[k] % 2 != 0){
                        f = false;
                        break;
                    }
                }
                if (f){
                    res = Math.max(res,j - i + 1);
                }

            }
        }
        return res;
        // write your code in Java 8 (Java SE 8)
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-3,-2,1,0,8,7,1},3));
    }
}
