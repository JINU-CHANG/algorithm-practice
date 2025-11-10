import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, d, k, c;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= d; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < k; i++) {
            set.add(arr[i]);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        
        if (!set.contains(c)) max = Math.max(max, set.size() + 1);
        max = Math.max(max, set.size());

        for (int first = 1; first < n; first++) {
            int firstV = arr[first - 1];
            if (map.get(firstV) == 1) set.remove(firstV);
            map.put(firstV, map.get(firstV) - 1);

            int last = first + k - 1;
            if (last >= n) last = last - n;

            int lastV = arr[last];
            set.add(lastV);
            map.put(lastV, map.get(lastV) + 1);

            if (!set.contains(c)) max = Math.max(max, set.size() + 1);
            else max = Math.max(max, set.size());
        }

        System.out.println(max);
    }
}
