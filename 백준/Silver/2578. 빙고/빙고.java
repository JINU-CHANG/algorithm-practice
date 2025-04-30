import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        int[][] numberArray = new int[26][2];
        boolean[][] checkedArray = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                numberArray[x][0] = i;
                numberArray[x][1] = j;
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int x = Integer.parseInt(st.nextToken());
                checkedArray[numberArray[x][0]][numberArray[x][1]] = true;
                if (checkBingGo(checkedArray)) {
                    System.out.println(answer);
                    return;
                }

                answer++;
            }
        }
    }

    private static boolean checkBingGo(boolean[][] checkedArray) {
        // 가로 체크
        int aCnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (!checkedArray[i][j]) {
                    check = false;
                    break;
                }
            }

            if (check) aCnt++;
        }
        // 세로 체크
        int bCnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (!checkedArray[j][i]) {
                    check = false;
                    break;
                }
            }

            if (check) bCnt++;
        }

        // 대각선 체크
        int cCnt = 0;
        boolean check = true;
        for (int i = 0; i < 5; i++) {
            if (!checkedArray[i][i]) {
                check = false;
                break;
            }
        }

        if (check) cCnt++;

        check = true;
        for (int i = 4; i >= 0; i--) {
            if (!checkedArray[(4 - i)][i]) {
                check = false;
                break;
            }
        }

        if (check) cCnt++;

        //System.out.println("aCnt : " + aCnt + " bCnt : " + bCnt + " cCnt : " + cCnt);
        if (aCnt + bCnt + cCnt >= 3) return true;
        else return false;
    }
}
