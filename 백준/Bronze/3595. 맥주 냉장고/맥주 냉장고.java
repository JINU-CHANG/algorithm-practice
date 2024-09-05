import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node>{
    int a;
    int b;
    int c;
    int sum;

    public Node(int a, int b, int c, int sum) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
        return this.sum - o.sum;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i != 0) continue;
            for (int j = 1; j <= n / i; j++) {
                if (n / i % j != 0) continue;
                for (int k = 1; k <= n / i / j; k++) {
                    if (n / i / j % k != 0) continue;
                    if (i * j * k != n) continue;
                    int sum = (i * j * 2) + (j * k * 2) + (i * k * 2);
                    list.add(new Node(i, j, k, sum));
                }
            }
        }

        Collections.sort(list);
        Node answer = list.get(0);
        sb.append(answer.a).append(" ").append(answer.b).append(" ").append(answer.c);
        System.out.println(sb);
    }
}

