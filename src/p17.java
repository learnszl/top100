import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author szl
 * @Date 2021/11/9 23:15
 * @Description
 */
public class p17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        HashMap<Character, String> phoneNumber = new HashMap<>();
        phoneNumber.put('2', "abc");
        phoneNumber.put('3', "def");
        phoneNumber.put('4', "ghi");
        phoneNumber.put('5', "jkl");
        phoneNumber.put('6', "mno");
        phoneNumber.put('7', "pqrs");
        phoneNumber.put('8', "tuv");
        phoneNumber.put('9', "wxyz");
        ArrayList<String> res = new ArrayList<>();
        dfs(phoneNumber, 0, new StringBuffer(), res, digits);
        return res;
    }

    private void dfs(HashMap<Character, String> map, int index, StringBuffer temp, ArrayList<String> res, String digits) {
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }
        String curr = map.get(digits.charAt(index));
        for (int i = 0; i < curr.length(); i++) {
            temp.append(curr.charAt(i));
            dfs(map, index + 1, temp, res, digits);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        p17 p17 = new p17();
        System.out.println(p17.letterCombinations("23"));
    }
}
