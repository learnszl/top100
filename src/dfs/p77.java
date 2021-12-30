package dfs;

import java.util.ArrayList;
import java.util.List;

public class p77 {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(n, k, new ArrayList<>(), used, 1);
        return res;
    }

    private void dfs(int n, int k, List<Integer> temp, boolean[] used, int index) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n - k + temp.size() + 1; i++) {
            if (!used[i - 1]) {
                temp.add(i);
                used[i - 1] = true;
                System.out.println("递归之前 " + temp);
                dfs(n, k, temp, used, i);
                temp.remove(temp.size() - 1);
                System.out.println("递归之后 " + temp);
                used[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        p77 p77 = new p77();
        System.out.println(p77.combine(4, 2));
    }
}

