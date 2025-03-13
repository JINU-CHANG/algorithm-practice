import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        Set<String> played = new HashSet<>();

        for (int i = 0; i < n; i++) {
            played.add(br.readLine());
        }

        if (game == 'Y') {
            System.out.println(played.size() / 1);
        } else if (game == 'F') {
            System.out.println(played.size() / 2);
        } else {
            System.out.println(played.size() / 3);
        }
    }
}
