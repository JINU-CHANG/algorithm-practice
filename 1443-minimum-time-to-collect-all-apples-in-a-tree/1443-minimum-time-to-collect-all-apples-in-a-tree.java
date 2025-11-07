class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        visited = new boolean[n];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        visited[0] = true;
        return 2 * dfs(0, hasApple);
    }

    public int dfs(int start, List<Boolean> hasApple) {
        int sum = 0;

        for (int x : list.get(start)) {
            if (visited[x]) continue;
            if (hasApple.get(x)) {
                sum += 1;
            }

            visited[x] = true;
            int temp = dfs(x, hasApple);
            if (temp > 0) sum += temp;
            visited[x] = false;
        }
        
        if (!hasApple.get(start) && start != 0 && sum > 0) sum += 1;
        //System.out.println("===" + start + " " + sum);
        return sum;
    }
}