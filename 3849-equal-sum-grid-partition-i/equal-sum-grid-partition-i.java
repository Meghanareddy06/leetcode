class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        
        if (totalSum % 2 != 0) return false;

        long target = totalSum / 2;

        
        long rowSum = 0;
        for (int i = 0; i < m - 1; i++) { 
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == target) return true;
        }

        
        long[] colSum = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[j] += grid[i][j];
            }
        }

        long runningColSum = 0;
        for (int j = 0; j < n - 1; j++) { 
            runningColSum += colSum[j];
            if (runningColSum == target) return true;
        }

        return false;
    }
}