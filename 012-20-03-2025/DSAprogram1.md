# Game Score Adjustment

## Problem Description
A crew of **N** players played a game and received some scores. They must maintain their original positions after the game.

### Constraints:
- Each player's score **must not be greater or smaller than both of their neighbors**.
- To achieve this constraint, the following rules are applied repeatedly:
  - If **player-K**'s score is smaller than both of their neighbors, it is incremented by **1**.
  - If **player-K**'s score is greater than both of their neighbors, it is decremented by **1**.
  - The **first and last players' scores remain unchanged**.
  - These steps continue until all players satisfy the constraint.

### Input Format
- **Line 1:** An integer `N`, the number of players.
- **Line 2:** `N` space-separated integers representing the scores of each player.

### Output Format
- Print the adjusted scores as an integer array.

---

### Sample Input-1:
```text
6
4 3 5 2 6 3
```

### Sample Output-1:
```text
[4, 4, 4, 4, 4, 3]
```

### Sample Input-2:
```text
8
5 1 4 2 7 4 6 3
```

### Sample Output-2:
```text
[5, 3, 3, 3, 5, 5, 5, 3]
```



## Solution
```java
import java.util.*;

public class DSAprogram1 {
    public static String sol(int n, int[] nums) {
        boolean changed;

        do {
            changed = false;
            for(int i = 1; i < n - 1; i++) {
                if(nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
                    nums[i]++;
                    changed = true;
                } else if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    nums[i]--;
                    changed = true;
                }
            }
        } while(changed);

        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sol(n, nums));
        sc.close();
    }
}
```

