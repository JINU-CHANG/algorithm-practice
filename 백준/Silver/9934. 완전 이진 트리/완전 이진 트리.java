import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        int nodeNum = (int) Math.pow(2, k) - 1;

        array = new int[nodeNum];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeNum; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        list.get(k - 1).add(array[nodeNum / 2]);
        dfs(k - 1, nodeNum / 2);
        for (int i = k - 1; i >= 0; i--) {
            for (int x : list.get(i)) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int height, int mid) { // 3, 2
        int c = (int) Math.pow(2, height - 1);
        int left = mid - c;
        int right = mid + c;
        list.get(height - 1).add(array[left]);
        list.get(height - 1).add(array[right]);
        if (c == 1) return;
        dfs(height - 1, left);
        dfs(height - 1, right);
    }
}
