import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        List<String> words = new LinkedList<>();

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            words.add(st.nextToken());
        }

        Collections.sort(words, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                // 사전 순
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                
                // 길이 순
                return Integer.compare(s1.length(), s2.length());
            }
        });

        Set<String> pureWords = new LinkedHashSet<>(words);
        for (String word : pureWords) {
            bw.write(word + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
}
