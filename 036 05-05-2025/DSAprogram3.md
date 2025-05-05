
## Problem: Jump to Zero

**Description:**

You are given an array of non-negative integers representing positions in a game board. Each position contains a value that tells you how far you can jump **either left or right** from that index.

You start at a specific position on the board. Your goal is to determine whether it is **possible to reach any index with the value `0`** by making a sequence of valid jumps. You **cannot revisit** any position once you've been there.

Write a program that returns `true` if there is a way to reach any index with value `0` from the starting position. Otherwise, return `false`.

---

**Input Format:**

* The first line contains two integers:

  * `n` — the number of positions on the board.
  * `pos` — the starting position (0-indexed).
* The second line contains `n` space-separated non-negative integers — the values at each position.

---

**Output Format:**

* Print `true` if you can reach a position with value `0`, otherwise print `false`.

---

**Constraints:**

* `1 <= n <= 10^4`
* `0 <= pos < n`
* `0 <= nums[i] < n`

---

**Example Input 1:**

```
5 0
4 2 3 0 3
```

**Example Output 1:**

```
true
```

**Explanation:**
Start at index 0.
From index 0, you can jump to index 4 (0 + 4) or stay (0 - 4, invalid).
From index 4, you can jump to index 1 (4 - 3).
From index 1, you can jump to index 3 (1 + 2), which has value 0.

---

**Example Input 2:**

```
4 2
3 0 2 1
```

**Example Output 2:**

```
false
```

**Explanation:**
From index 2, you can jump to index 0 or 4 (invalid).
From index 0, you can jump to index 3.
From index 3, you jump to index 4 (invalid). No way to reach index with value 0.

---

```java
import java.util.*;

public class DSAprogram3 {
    public static boolean checkCanWin(int [] nums , boolean [] visited ,int start){
        if(start > nums.length - 1 || start < 0 || visited[start]){
            return false;
        }
        if(nums[start] == 0){
            return true;
        }
        visited[start] = true;
        return checkCanWin(nums, visited,start + nums[start]) || checkCanWin(nums, visited,start - nums[start]);
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        boolean [] visited = new boolean[n];
        System.out.println(checkCanWin(nums,visited,pos));
        sc.close();
    }
}
```