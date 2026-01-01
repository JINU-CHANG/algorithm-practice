import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int n; // ex) 5
    int w; // ex) 11

    public Node(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {

    static List<List<Node>> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(p).add(new Node(c, w));
        }

        check(1);

        System.out.println(answer);
    }

    private static int check(int i) { // 1
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;

        for (Node nN : list.get(i)) {
            int temp = nN.w;
            temp += check(nN.n);
            sum = Math.max(sum, temp);
            pq.add(temp);
        }

        if (pq.size() == 1) answer = Math.max(answer, pq.poll());
        else if (pq.size() >= 2) answer = Math.max(answer, pq.poll() + pq.poll());

        return sum;
    }
}
