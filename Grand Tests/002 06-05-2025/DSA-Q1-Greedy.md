[1029. Two City Scheduling (lc)](https://leetcode.com/problems/two-city-scheduling/)

```java
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sorting on basis of how expensive trip to b compared to a
        // least to highest
        Arrays.sort(costs, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int res = 0, n = costs.length / 2;

        // choose b nTimes, then choose a.
        for(int i = 0; i < n; i++) {
            res += costs[i][1] + costs[i + n][0];
        }

        return res;
    }
}
```