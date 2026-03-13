class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long)1e18;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int height, int[] workers) {
        long total = 0;

        for (int w : workers) {

            long low = 0, high = (long)Math.sqrt(2.0 * time / w) + 2;

            while (low <= high) {
                long mid = (low + high) / 2;
                long need = (long)w * mid * (mid + 1) / 2;

                if (need <= time) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            total += high;

            if (total >= height) return true;
        }

        return total >= height;
    }
}