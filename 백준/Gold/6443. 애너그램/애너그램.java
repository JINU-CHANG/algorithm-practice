import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] cArrs;
    static char[] anagram;
    static boolean[] visited;
    //static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            cArrs = br.readLine().toCharArray();
            anagram = new char[cArrs.length];
            visited = new boolean[cArrs.length];
            //set = new HashSet<>();
            Arrays.sort(cArrs);
            search(0);
        }

        System.out.println(sb);
    }

    private static void search(int count) {
        if (count == cArrs.length) {
            String s = String.valueOf(anagram);
            //if (set.contains(s)) return;

            sb.append(s).append("\n");
            //set.add(s);
            return;
        }

        for (int i = 0; i < cArrs.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && !visited[i - 1] && cArrs[i - 1] == cArrs[i]) continue;

            visited[i] = true;
            anagram[count] = cArrs[i];
            search(count + 1);
            visited[i] = false;
        }
    }
}
