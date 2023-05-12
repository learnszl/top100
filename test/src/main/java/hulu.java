import java.text.DateFormat;
import java.util.*;

public class hulu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<Long> list = new ArrayList<>();
        HashMap<Long, Set<Character>> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            char c = s1[0].charAt(0);
            String[] s2 = s1[1].split("-");
            int year = Integer.parseInt(s2[0]);
            int month = Integer.parseInt(s2[1]);
            int day = Integer.parseInt(s2[2]);
            Date date = new Date(year, month, day);
            list.add(date.getTime());
            if (!map.containsKey(date.getTime())){
                Set<Character> set = new HashSet<>();
                set.add(c);
                map.put(date.getTime(),set);
            }
            map.get(date.getTime()).add(c);
        }
        int k = Integer.parseInt(in.nextLine());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < list.size() ; j++) {
                set.addAll(map.get(list.get(j)));
                if (set.size() >= k){
                    int tmp =(int) ((list.get(j) - list.get(i)) / (24 * 3600 * 1000));
                    res = Math.min(res,tmp + 1);
                    break;
                }
            }
        }
        if (res == Integer.MAX_VALUE){
            res = -1;
        }
        System.out.println(res);

    }
}
