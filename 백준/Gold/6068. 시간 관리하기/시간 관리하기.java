import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int t;
    int s;

    public Info(int t, int s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(Info o) {
        return this.s - o.s;
    }
}

public class Main {

    static int n;
    static Info[] todoList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        todoList = new Info[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            todoList[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int ans = solve();
        if (ans < 0 || calculate(ans) == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int solve() {
        Arrays.sort(todoList);

        int left = 0;
        int right = todoList[0].s - todoList[0].t + 1;

        while (left < right) {
            int mid = (left + right) / 2;

            int value = calculate(mid);
            if (value == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right - 1;
    }

    public static int calculate(int startTime) {
        for (Info info : todoList) {
            int endTime = startTime + info.t;

            if (endTime > info.s) {
                return -1;
            }

            startTime = endTime;
        }

        return startTime;
    }
}
