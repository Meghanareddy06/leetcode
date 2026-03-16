import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                set.add(grid[i][j]); 

                for (int k = 1; i-k >= 0 && i+k < m && j-k >= 0 && j+k < n; k++) {

                    int sum = 0;

                    int x = i-k, y = j;

                    
                    for (int t = 0; t < k; t++)
                        sum += grid[x+t][y+t];

                   
                    for (int t = 0; t < k; t++)
                        sum += grid[i+t][j+k-t];

                    
                    for (int t = 0; t < k; t++)
                        sum += grid[i+k-t][j-t];

                   
                    for (int t = 0; t < k; t++)
                        sum += grid[i-t][j-k+t];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int idx = 0;
        for (int val : set) {
            if (idx == 3) break;
            ans[idx++] = val;
        }

        return ans;
    }
}