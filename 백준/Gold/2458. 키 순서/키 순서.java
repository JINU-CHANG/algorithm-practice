
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> large = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> small = new ArrayList<>();
    static boolean[] chk;
    static int cnt = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+1; i++) { // 초기화
            large.add(new ArrayList<>());
            small.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) { // 크고 작은 값 입력
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            small.get(v).add(u);
            large.get(u).add(v);
        }

        for(int i=1; i<=N; i++) {
            chk = new boolean[N+1];
            dfs(i, small);
            chk = new boolean[N+1];
            dfs(i, large);

            if(cnt == N+1) ans ++;
            
            cnt = 0;
        }

        System.out.println(ans);
    }

    public static void dfs(int x, ArrayList<ArrayList<Integer>> find) {
        
        if(chk[x]) return;
        chk[x] = true;
        cnt ++;

        if(find.get(x).isEmpty()) return;

        for(int i=0; i<find.get(x).size(); i++) {
            dfs(find.get(x).get(i), find);
        }

        
    }
}
