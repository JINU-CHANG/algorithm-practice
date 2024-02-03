import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_1744 {
    static int N;
    static long ans;
    static List<Integer> negativeNums = new ArrayList<>();
    static List<Integer> positiveNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x <= 0) {
                negativeNums.add(x);
            } else {
                if (x==1) {
                    ans ++;
                    continue;
                }
                positiveNums.add(x);
            }
        }

        Collections.sort(negativeNums);
        Collections.sort(positiveNums, Collections.reverseOrder());

        calculateGroupNums(negativeNums);
        calculateGroupNums(positiveNums);

        System.out.println(ans);
    }

    public static void calculateGroupNums(List<Integer> nums) {
        for (int i=0; i<nums.size(); i+=2) {
            if (i == nums.size()-1) {
                ans += nums.get(i);
                break;
            }
            ans += nums.get(i) * nums.get(i+1);
        }
    }
}
