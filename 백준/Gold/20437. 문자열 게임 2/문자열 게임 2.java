import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (;t > 0; t--) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.containsKey(c)) {
                    List<Integer> list = map.get(c);
                    list.add(i);
                } else {
                    List<Integer> nList = new ArrayList<>();
                    nList.add(i);
                    map.put(c, nList);
                }
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (List<Integer> l : map.values()) {
                int sIdx = 0;
                for (int eIdx = 0; eIdx < l.size(); eIdx++) {
                    if (eIdx - sIdx == k - 1) {
                        int x = l.get(eIdx) - l.get(sIdx) + 1;
                        min = Math.min(min, x);
                        max = Math.max(max, x);
                        sIdx++;
                    }
                }
            }

            if (min == Integer.MIN_VALUE || max == Integer.MIN_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        System.out.println(sb);
    }
}
