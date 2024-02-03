import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    public long startTime;
    public long endTime;

    public Meeting(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.endTime == o.endTime) {
            return (int)(this.startTime - o.startTime);
        }
        return (int) (this.endTime - o.endTime);
    }
}

public class B_1931 {
    static int N;
    static int ans = 1;
    static Meeting selected;
    static List<Meeting> meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        meetings = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            long startTime = Integer.parseInt(st.nextToken());
            long endTime = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(startTime, endTime));
        }

        Collections.sort(meetings);
        selected = meetings.get(0);

        for (int i=1; i<N; i++) {
            if (selected.endTime <= meetings.get(i).startTime) {
                selected = meetings.get(i);
                ans ++;
            }
        }

        System.out.println(ans);
    }
}
