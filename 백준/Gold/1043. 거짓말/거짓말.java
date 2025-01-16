import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Party {

    List<Integer> peopleNum;

    public Party(List<Integer> peopleNum) {
        this.peopleNum = peopleNum;
    }
}

public class Main {

    static int n, m;
    static int ans;
    static boolean[] truthPeople;
    static List<Party> parties = new ArrayList<>();
    static Map<Integer, List<Integer>> meetPeopleMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기화
        truthPeople = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        int truthPeopleNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthPeopleNum; i++) {
            truthPeople[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < n + 1; i++) {
            meetPeopleMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            List<Integer> peopleNum = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                peopleNum.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < num; j++) {
                for (int k = j + 1; k < num; k++) {
                    List<Integer> meetPeople1 = meetPeopleMap.get(peopleNum.get(j));
                    meetPeople1.add(peopleNum.get(k));

                    List<Integer> meetPeople2 = meetPeopleMap.get(peopleNum.get(k));
                    meetPeople2.add(peopleNum.get(j));
                }
            }

            parties.add(new Party(peopleNum));
        }

        // 진실을 아는 사람 구하기
        for (int i = 1; i < n + 1; i++) {
            if (truthPeople[i]) dfs(i);
        }

        // 결과
        boolean canLie = true;
        for (Party party : parties) {
            List<Integer> peopleNum = party.peopleNum;
            for (Integer people : peopleNum) {
                if (truthPeople[people]) {
                    canLie = false;
                    break;
                } else {
                    canLie = true;
                }
            }

            if (canLie) ans++;
        }

        System.out.println(ans);
    }

    public static void dfs(int start) {
        truthPeople[start] = true;

        for (Integer people : meetPeopleMap.get(start)) {
            if (!truthPeople[people]) {
                dfs(people);
            }
        }
    }
}
