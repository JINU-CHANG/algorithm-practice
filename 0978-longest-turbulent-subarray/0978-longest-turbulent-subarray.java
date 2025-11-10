class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] dpL = new int[arr.length];
        int[] dpR = new int[arr.length];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int temp = 0;
            if (arr[i - 1] > arr[i]) {
                dpL[i] = dpR[i - 1] + 1;
                temp = dpL[i];
            } else if (arr[i - 1] < arr[i]) {
                dpR[i] = dpL[i - 1] + 1;
                temp = dpR[i];
            }

            max = Math.max(max, temp);
        }

        if (max == Integer.MIN_VALUE) return 1;
        return max + 1;
    }
}