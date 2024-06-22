import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Fxtion {
    int x;
    int y;

    Fxtion(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static List<Fxtion> fxtions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        initalizeFxtions();
    
        for (int i = 0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());
            Fxtion ans = fxtions.get(Integer.parseInt(st.nextToken()));

            System.out.println(ans.x + " " + ans.y);
        }
        
    }

    public static void initalizeFxtions() {
        Fxtion f0 = new Fxtion(1, 0);
        Fxtion f1 = new Fxtion(0, 1);

        fxtions.add(f0);
        fxtions.add(f1);

        for (int i = 2; i <= 40; i ++) {
            Fxtion first = fxtions.get(i - 1);
            Fxtion second = fxtions.get(i - 2);

            Fxtion fn = new Fxtion((first.x + second.x), (first.y + second.y));

            fxtions.add(fn);
        }
    }
}
