
import java.util.*;


public class Main {
    class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Queue<Node> q = new LinkedList<>();

    public Node Convert(Node pRootOfTree) {
        inorder(pRootOfTree);
        if (q.isEmpty()) {
            return pRootOfTree;
        }
        pRootOfTree = q.poll();
        Node pre = pRootOfTree;
        pre.left = null;
        Node curr;
        while (!q.isEmpty()) {
            curr = q.poll();
            pre.right = curr;
            curr.left = pre;
            pre = curr;
        }
        pre.right = null;
        return pRootOfTree;
    }

    private void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        q.offer(node);
        inorder(node.right);
    }

    class ListNode<T> {
        public T data;
        public ListNode next;
    }

    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> l = null;
        ListNode<Integer> r = null;
        ListNode<Integer> p = head;
        int len = 0;
        while (p != null) {
            len++;
            if (left - 1 == len) {
                l = p;
            }
            if (right == len) {
                r = p;
                break;
            }
            p = p.next;
        }
        p = l;
        ListNode<Integer> pre = l;
        l = l.next;
        ListNode q = l, s = r.next, m = r;
        r = r.next;
        while (l != r) {
            ListNode cur = l.next;
            l.next = pre;
            pre = l;
            l = cur;
        }
        p.next = m;
        q.next = s;
        return head;
    }

    public ArrayList<String> compose(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int len = 0, j = i;
            for (i = j; i < words.length; i++) {
                len = len + words[i].length() + 1;
                if (len > maxWidth + 1) {
                    len = len - words[i].length() - 1;
                    break;
                }
            }
            len -= 1;
            if (i == words.length) {
                StringBuilder temp = new StringBuilder(words[j]);
                for (int k = j + 1; k < i; k++) {
                    temp.append(' ');
                    temp.append(words[k]);
                }
                temp.append(generateSpace(maxWidth - len));
                res.add(temp.toString());
                break;
            }
            int num = i - j;
            int sub = maxWidth - len;
            if (num == 1)
                res.add(words[j] + generateSpace(sub));
            else {
                StringBuilder temp = new StringBuilder(words[j]);
                int space = sub / (num - 1);
                int extra = sub - (num - 1) * space;
                for (int k = j + 1; k < i; k++) {
                    if (extra > 0) {
                        temp.append(generateSpace(space + 2));
                        temp.append(words[k]);
                        extra--;
                    } else {
                        temp.append(generateSpace(space + 1));
                        temp.append(words[k]);
                    }
                }
                res.add(temp.toString());
            }
        }
        return res;
    }

    private String generateSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
    // write code here


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] tmp = new int[n][2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            tmp[i][0] = profit[i];
            tmp[i][1] = difficulty[i];
        }
        Arrays.sort(tmp, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < n; j++) {
                if (worker[i] >= tmp[j][1]) {
                    res += tmp[j][0];
                    break;
                }
            }
        }
        return res;
        // write code here
    }

    public int smallestRange(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int res = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[i] + K, A[n - 1] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);
            res = Math.min(res, max - min);
        }
        return res;
        // write code here
    }

    HashSet<Integer> set;

    public boolean cross_river(int[] stones) {
        set = new HashSet<>();
        for (int stone : stones) {
            set.add(stone);
        }
        int n = stones.length;
        return dfs(stones, n, 1, 0);
        // write code here
    }

    private boolean dfs(int[] stones, int n, int k, int index) {
        if (index > stones[n - 1])
            return false;
        if (index == stones[n - 1]) {
            return true;
        }
        boolean origin = false;
        boolean originAdd = false;
        boolean originDes = false;
        if (set.contains(index + k)) {
            origin = dfs(stones, n, k, index + k);
        }
        if (set.contains(index + k + 1)) {
            originAdd = dfs(stones, n, k + 1, index + k + 1);
        }
        if (set.contains(index + k - 1) && k > 1) {
            originDes = dfs(stones, n, k - 1, index + k - 1);
        }
        return origin || originAdd || originDes;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.cross_river(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
    }
}
