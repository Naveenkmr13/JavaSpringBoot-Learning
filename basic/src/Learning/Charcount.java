package Learning;
import java.util.*;

public class Charcount {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String val = input.nextLine();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char ch : val.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> result = map.entrySet().stream().toList();

        System.out.println(result);
    }
}
