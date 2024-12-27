import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, c;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        System.out.println(solve());
    }

    public static int solve() {
        int left = 1;
        int right = (house[house.length - 1] - house[0] + 1);

        while (left < right) {
            int mid = (left + right) / 2;

            if (installRouter(mid) < c) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right - 1;
    }

    public static int installRouter(int x) {
        int count = 1;
        int current = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - current >= x) {
                count++;
                current = house[i];
            }
        }

        return count;
    }
}
