import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {
    int x;
    int s;

    Info(int x, int s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public int compareTo(Info o) {
        if (this.s < o.s) return -1;
        if  (this.s > o.s) return 1;
        else return 0;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    PriorityQueue<Info> queue = new PriorityQueue<>();

    boolean[] chk = new boolean[100001];

    queue.add(new Info(N,0));

    while(!queue.isEmpty()) {
        Info info = queue.poll();
        if(info.x < 0 || info.x>100000) continue;
        if(chk[info.x]) continue;
        if(info.x==K) {
            System.out.println(info.s);
            break;
        }
        chk[info.x] = true;
        queue.add(new Info((info.x-1), info.s+1));
        queue.add(new Info((info.x+1), info.s+1));
        queue.add(new Info((info.x*2), info.s));
    }

}
}
