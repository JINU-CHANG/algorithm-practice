import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // R 옮기기
        int countR = 0;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (list.get(i) == 'R' && list.get(i + 1) == 'B') {
                list.remove(i);
                list.addLast('R');

                countR++;
            }
        }

        list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // B 옮기기
        int countB = 0;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (list.get(i) == 'B' && list.get(i + 1) == 'R') {
                list.remove(i);
                list.addLast('B');

                countB++;
            }
        }

        System.out.println(Math.min(countR, countB));
    }
}
