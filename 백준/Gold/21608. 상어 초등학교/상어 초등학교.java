import java.util.*;
import java.io.*;

class Position {
    int y;
    int x;

    Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n;
    static int[] order;
    static boolean[][] seated;

    static Map<Integer, List<Integer>> likeStudentMap = new HashMap<>();
    static Map<Integer, Position> studentPositionMap = new HashMap<>();

    static int max = Integer.MIN_VALUE;
    static List<Position> checkList = new ArrayList<>();
    static int[][] countMap;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        n = Integer.parseInt(st.nextToken());
        order = new int[n * n];
        seated = new boolean[n][n];
        countMap = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());

            int studentNumber = Integer.parseInt(st.nextToken());
            order[i] = studentNumber;

            List<Integer> likeStudents = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                likeStudents.add(Integer.parseInt(st.nextToken()));
            }
            likeStudentMap.put(studentNumber, likeStudents);
        }

        // 학생 배치
        for (int i = 0; i < n * n; i++) {
            List<Integer> likeStudents = likeStudentMap.get(order[i]);
            seatStudent(order[i], likeStudents);

            max = Integer.MIN_VALUE;
            checkList = new ArrayList<>();
            countMap = new int[n][n];
        }

        // 만족도 계산
        for (int i = 0; i < n * n; i++) {
            int count = 0;
            Position myPosition = studentPositionMap.get(order[i]);
            List<Integer> likeStudents = likeStudentMap.get(order[i]);

            for (int j = 0; j < likeStudents.size(); j++) {
                Position likePosition = studentPositionMap.get(likeStudents.get(j));

                if (Math.abs(myPosition.x - likePosition.x) + Math.abs(myPosition.y - likePosition.y) == 1) count++;
            }

            if (count == 1) ans += 1;
            else if (count == 2) ans += 10;
            else if (count == 3) ans += 100;
            else if (count == 4) ans += 1000;
        }

        System.out.println(ans);
    }

    private static void seatStudent(int studentNumber, List<Integer> likeStudents) {
        for (int i = 0; i < likeStudents.size(); i++) {
            int likeStudentNumber = likeStudents.get(i);

            if (studentPositionMap.containsKey(likeStudentNumber)) { // 해당 학생이 자리 배치된 경우
                Position position = studentPositionMap.get(likeStudentNumber);
                checkFirst(position);
            }
        }

        // 1번 조건 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (countMap[i][j] == max) {
                    checkList.add(new Position(i, j));
                }
            }
        }

        if (checkList.size() == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (seated[i][j]) continue;
                    checkList.add(new Position(i, j));
                }
            }
        }

        if (checkList.size() == 1) {
            Position position = checkList.get(0);
            studentPositionMap.put(studentNumber, position);
            seated[position.y][position.x] = true;
        } else {
            // 2번 조건 체크
            checkSecond();

            // 2 & 3번 조건 동시에 만족
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!seated[i][j] && countMap[i][j] == max) {
                        Position position = new Position(i, j);
                        studentPositionMap.put(studentNumber, position);
                        seated[position.y][position.x] = true;
                        return;
                    }
                }
            }
        }
    }

    private static void checkFirst(Position position) {
        for (int i = 0; i < 4; i++) {
            int ny = position.y + dy[i];
            int nx = position.x + dx[i];

            if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
            if (seated[ny][nx]) continue; // 비어있는 자리가 아닌 경우

            // 인접한 자리 체크
            countMap[ny][nx] += 1;
            max = Math.max(max, countMap[ny][nx]);
        }
    }

    private static void checkSecond() {
        for (int i = 0; i < checkList.size(); i++) {
            Position position = checkList.get(i);

            int count = 0;
            for (int j = 0; j < 4; j++) {
                int ny = position.y + dy[j];
                int nx = position.x + dx[j];

                if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
                if (!seated[ny][nx]) count++;
            }

            countMap[position.y][position.x] += count;
            max = Math.max(max, countMap[position.y][position.x]);
        }
    }
}
