import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] temp;
    static Set<String> set = new HashSet<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        temp = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int idx, int size) {
        if (size == m) {
            StringBuffer tempsb = new StringBuffer();
            for (int x : temp) {
                tempsb.append(x).append(" ");
            }

            if (set.contains(tempsb.toString())) return;

            set.add(tempsb.toString());
            sb.append(tempsb);
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            temp[size] = arr[i];
            dfs(i, size + 1);
        }
    }
}
