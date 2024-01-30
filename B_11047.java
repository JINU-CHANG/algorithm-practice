import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [그리디]
 * 필요한 동전의 갯수를 최소로 구해야하므로 최대한 큰 종류의 값으로 나눠야 한다.
 * (A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수) 해당 조건에 따라 Ai는 언제나 Ai-1로 나누어떨어진다. 따라서 언제나 더 큰 값으로 나누어야 한다.
 */
public class B_11047 {
    static int N, K;
    static int ans = 0;
    static int[] type;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        type = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            type[(N-1)-i] = Integer.parseInt(st.nextToken());
        }

        while(K>0) {
            divideByMaxType();
        }

        System.out.println(ans);
    }

    private static void divideByMaxType() {
        for(int i=0; i<N; i++) {
            if (type[i]<=K) {
                ans += K/type[i];
                K -= (K/type[i]) * type[i];
                break;
            }
        }
    }
}
