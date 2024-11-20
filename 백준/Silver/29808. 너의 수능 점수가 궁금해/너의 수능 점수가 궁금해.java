import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

class Answer implements Comparable<Answer> {
    int a;
    int b;

    public Answer(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Answer o) {
        if (this.a == o.a) return this.b - o.b;
        return this.a - o.a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return a == answer.a && b == answer.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

public class Main {

    static int[] x = {508, 108};
    static int[] y = {212, 305};
    static int studentNumber;
    static Set<Answer> set = new HashSet<>();
    static List<Answer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        studentNumber = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x[i], y[j]);
            }
        }

        Collections.sort(answers);
        sb.append(answers.size()).append("\n");
        for (int i = 0; i < answers.size(); i++) {
            Answer now = answers.get(i);
            sb.append(now.a).append(" ").append(now.b).append("\n");
        }

        System.out.println(sb);
    }

    public static void solve(int x, int y) {
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                if ((((i * x) + (j * y)) * 4763) == studentNumber){
                    Answer answer = new Answer(i, j);
                    if (set.contains(answer)) continue;
                    answers.add(answer);
                    set.add(answer);
                }
            }
        }
    }
}
