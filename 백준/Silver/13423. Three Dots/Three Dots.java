import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int ans = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sb.append(search(arr) + "\n");
        }

        System.out.println(sb);
    }

    public static int search(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            list.add(new ArrayList<>());
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.get(i).add(Math.abs(arr[i] - arr[j]));
            }
        }

        for (int i = 0; i < n; i++) {
            ans += list.get(i).size() - new HashSet<>(list.get(i)).size();
        }

        return ans;
    }

}