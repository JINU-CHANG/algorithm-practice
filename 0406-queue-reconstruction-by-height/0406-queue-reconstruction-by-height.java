import java.util.*;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        // 1. hi 큰 순으로, hi 같다면 ki 작은 순으로 정렬
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return -(o1[0] - o2[0]);
        });

        // 2. 큰 것부터 차례로 집어넣기 -> 링크드 리스트
        List<int[]> list = new LinkedList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }

        int[][] result = new int[people.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}