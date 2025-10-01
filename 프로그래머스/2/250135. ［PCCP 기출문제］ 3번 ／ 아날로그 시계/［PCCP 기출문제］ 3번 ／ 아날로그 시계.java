import java.util.*;
import java.time.*;

class Solution {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = (h1 * 60 * 60) + (m1 * 60) + (s1);

        LocalTime start = LocalTime.of(h1, m1, s1);
        LocalTime end = LocalTime.of(h2, m2, s2);
        long duration = Duration.between(start, end).getSeconds();

        // 시작 h
        double h = (12 * 60 * 60.0);
        // 시작 m
        double m = (60 * 60.0);
        // 시작 s
        double s = 60.0;

        double beforeNS = ((startTime) % s) / s;
        double beforeNM = ((startTime) % m) / m;
        double beforeNH = ((startTime) % h) / h;

        if (beforeNS == beforeNM && beforeNM == beforeNH) answer++;

        for (int i = 1; i <= duration; i++) {
            double ns = ((startTime + i) % s) / s;
            double nm = ((startTime + i) % m) / m;
            double nh = ((startTime+ i) % h) / h;
            //System.out.println(ns + "/" + nm + "/" + nh);

            if (beforeNS < beforeNM && (ns >= nm || (beforeNS >= 0.9 && ns == 0.0))) {
                answer++;
            }
            if (beforeNS < beforeNH && (ns >= nh || (beforeNS >= 0.9 && ns == 0.0))) {
                answer++;
            }
            if (nm == nh && nh == ns) answer--;

            beforeNS = ns;
            beforeNM = nm;
            beforeNH = nh;
        }
        return answer;
    }
}

