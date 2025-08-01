import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (;t > 0; t--) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] list = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                list[idx].add(i);
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (ArrayList<Integer> l : list) {
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
