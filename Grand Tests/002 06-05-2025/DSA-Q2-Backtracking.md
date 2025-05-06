[1079. Letter Tile Possibilities (lc)](https://leetcode.com/problems/letter-tile-possibilities/)

```java
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for(char c: tiles.toCharArray()) {
            cnt[c - 'A']++;
        }

        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;

        for(int i = 0; i < 26; i++) {
            if(cnt[i] == 0) continue;
            res += 1;
            cnt[i] -= 1;
            res += dfs(cnt);
            cnt[i] += 1;
        }

        return res;
    }
}
```