import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<int[]> left = new Stack<>();
        Stack<int[]> right = new Stack<>();
        List<int[]> list = new LinkedList<>();
        int[] max = new int[]{0, Integer.MIN_VALUE};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        for (int[] arr : list) {
            if (arr[1] >= max[1]) {
                max = arr;
            }
        }

        left.push(list.get(0));
        right.push(list.get(list.size() - 1));

        for (int i = 1; i < n; i++) {
            int[] peek = left.peek();
            if (peek[1] <= list.get(i)[1]) {
                left.push(list.get(i));
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] peek = right.peek();
            if (list.get(i)[1] == max[1]) break;
            if (peek[1] <= list.get(i)[1]) {
                right.push(list.get(i));
            }
        }

        int sum = 0;
        int[] before = left.get(0);
        for (int i = 1; i < left.size(); i++) {
            sum += (left.get(i)[0] - before[0]) * before[1];
            before = left.get(i);
        }
        sum += before[1];

        before = right.get(0);
        for (int i = 1; i < right.size(); i++) {
            sum += (before[0] - right.get(i)[0]) * before[1];
            before = right.get(i);
        }
        sum += (before[0] - max[0]) * before[1];

        System.out.println(sum);
    }
}
