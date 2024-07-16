import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        Set<Integer> set = new TreeSet<>(); // 중복제거 후 정렬해서 숫자 저장 ex) [-9, -10, 2, 4]

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            set.add(x);
        }

        Map<Integer, Integer> result = compactNumbers(set);

        for (int i : arr) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    public static Map<Integer, Integer> compactNumbers(Set<Integer> numbers) {
        List<Integer> numbersList = new ArrayList<>(numbers);
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < numbersList.size(); i++) {
            result.put(numbersList.get(i), i);
        }

        return result;
    }
}