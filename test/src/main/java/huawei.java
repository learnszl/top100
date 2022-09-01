import java.util.*;

public class huawei {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s3 = s.nextLine();
        String[] s4 = s3.split(" ");
        int n = Integer.parseInt(s4[0]);
        int m = Integer.parseInt(s4[1]);

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> all = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String topic = s.nextLine();
            String[] s1 = topic.split(" ");
            for (int j = 0; j < s1.length; j++) {
                all.add(s1[j]);
                map.put(s1[j], map.getOrDefault(s1[j], 0) + 3);
            }
            String pp = s.nextLine();
            String[] s2 = pp.split(" ");
            for (int j = 0; j < s2.length; j++) {
                all.add(s2[j]);
                map.put(s2[j], map.getOrDefault(s2[j], 0) + 1);
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).equals(map.get(o1)) ? all.indexOf(o1) - all.indexOf(o2) : map.get(o2) - map.get(o1);
            }
        });
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < all.size(); i++) {
            if (set.contains(all.get(i)))
                continue;
            set.add(all.get(i));
            heap.add(all.get(i));
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(heap.poll() + " ");
        }
        System.out.print(heap.poll());
    }



}

