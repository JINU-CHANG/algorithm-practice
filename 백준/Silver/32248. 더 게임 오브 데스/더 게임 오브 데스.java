
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long k;

    static List<Integer> list = new ArrayList<>();

    static List<Integer> lista = new ArrayList<>();
    static List<Integer> listb = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    public static int solve() {
        int x = 1;
        int Ax = array[x];
        list.add(Ax);
        set.add(Ax);

        while (true) {
            x = Ax;
            Ax = array[x];

            if (set.contains(Ax)) break;
            list.add(Ax);
            set.add(Ax);
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(Ax)) {
                lista.add(list.get(i));
            }


            if (list.get(i).equals(Ax)) {
                for (int j = i; j < list.size(); j++) {
                    listb.add(list.get(j));
                }

                break;
            }
        }

        if (lista.size() >= k) return lista.get((int) k - 1);
        if ((k - lista.size()) % listb.size() == 0) return listb.get(listb.size() - 1);
        return listb.get((int) ((k - lista.size()) % listb.size() - 1));
    }
}
