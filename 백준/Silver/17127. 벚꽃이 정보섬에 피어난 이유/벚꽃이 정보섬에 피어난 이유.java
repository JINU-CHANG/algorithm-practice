import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 벚꽃나무 개수
        int X = N - 3; // 부분합 갯수
        int sum = 0;

        List<Integer> trees = new ArrayList<>(); // 벚꽃나무 초기화
        List<Boolean> checkTrees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees.add(Integer.parseInt(st.nextToken()));
            checkTrees.add(false);
        }
        
        int max = 0; // 부분합 최댓값
        int maxI = 0; // 부분합 시작 인데스
        for (int i = 0; i < N - X + 1; i++) {
            int x = 1;
            for (int j = i; j < i + X; j++) {
                x *= trees.get(j);
            }

            if (x >= max) {
                max = x;
                maxI = i;
            }
        }

        for (int i = maxI; i < maxI + X; i++) {
            checkTrees.set(i, true);
        }

        for (int i = 0; i < N ; i ++) {
            if (!checkTrees.get(i)) {
                sum += trees.get(i);
            }
        }
        System.out.println(sum + max);
    }
}
