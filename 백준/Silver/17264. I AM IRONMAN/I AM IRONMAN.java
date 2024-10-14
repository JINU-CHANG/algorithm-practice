import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, p, w, l, g;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> winPeople = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String symbol = st.nextToken();

            if (symbol.equals("W")) {
                winPeople.add(name);
            }
        }

        if (isHeIronMan()) {
            System.out.println("I AM IRONMAN!!");
        } else {
            System.out.println("I AM NOT IRONMAN!!");
        }
    }

    public static boolean isHeIronMan() throws IOException {
        int score = 0;

        for (int i = 0; i < n; i++) {
            if (score >= g) {
                return false;
            }

            String name = br.readLine();

            if (winPeople.contains(name)) {
                score += w;
            } else {
                if (score - l <= 0) {
                    score = 0;
                    continue;
                }
                score -= l;
            }
        }

        return true;
    }
}
