import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 학생 저장
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            String s = br.readLine();

            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }

            list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            if (k == 0) break;
            String current = list.get(i);
            if (map.get(current) == 1) {
                sb.append(list.get(i)).append("\n");
                k--;
            } else {
                map.put(current, map.get(current) - 1);
            }
        }

        System.out.println(sb);
    }
}
