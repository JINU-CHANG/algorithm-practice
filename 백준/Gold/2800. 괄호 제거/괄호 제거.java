import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

class Info {
    int start;
    int end;

    Info(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String s = br.readLine();
        List<Info> infos = new ArrayList<>();

        Set<String> set = new TreeSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int idx = stack.pop();
                infos.add(new Info(idx, i));
            }
        }

        for (int i = 1; i < (1 << infos.size()); i++) {
            boolean[] check = new boolean[s.length()];
            for (int j = 0; j < infos.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    Info info = infos.get(j);
                    check[info.start] = true;
                    check[info.end] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < s.length(); k++) {
                if (check[k]) continue;
                else sb.append(s.charAt(k));
            }
            if (set.contains(sb.toString())) continue;
            set.add(sb.toString());
        }

        for (String a : set) {
            result.append(a).append("\n");
        }
        System.out.println(result);
    }
}
