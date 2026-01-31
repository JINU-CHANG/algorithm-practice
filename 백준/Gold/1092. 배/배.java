import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cranes, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(boxes, Collections.reverseOrder());

        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        while (!boxes.isEmpty()) {

            for (int i = 0; i < cranes.size(); i++) {
                int max = cranes.get(i);

                for (int j = 0; j < boxes.size(); j++) {
                    int box = boxes.get(j);
                    if (max >= box) {
                        boxes.remove(j);
                        break;
                    }
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
