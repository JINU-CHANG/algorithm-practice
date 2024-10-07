import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Dababa {
    int y;
    int x;

    public Dababa(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dababa dababa = (Dababa) o;
        return y == dababa.y && x == dababa.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

public class Main {

    static int n, k;
    static int[] dy = {2, -2, 0, 0};
    static int[] dx = {0, 0, 2, -2};
    static Set<Dababa> dababas = new HashSet<>();
    static Set<Dababa> nDababas = new HashSet<>();

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dababas.add(new Dababa(y - 1, x - 1));
        }

        for (Dababa dababa : dababas) {
            for (int k = 0; k < 4; k++) {
                int ny = dababa.y + dy[k];
                int nx = dababa.x + dx[k];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                Dababa nDababa = new Dababa(ny, nx);
                if (dababas.contains(nDababa) || nDababas.contains(nDababa)) continue;
                nDababas.add(nDababa);
                count++;
            }
        }

        System.out.println(count);
    }
}
