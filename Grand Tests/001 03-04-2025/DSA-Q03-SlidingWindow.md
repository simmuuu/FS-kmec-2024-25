# Longest Tree Arrangement

## Problem Description

In a forest, there are N redwood trees arranged in a row. Each tree has a specific height, and these heights are given in the array `heights[]`.

Your task is to find the longest possible tree arrangement that satisfies the following conditions:
- The minimum size of the tree arrangement must be 3.
- There must be a tree at position `i` (where 0 < i < N-1) such that:
  - The heights form an increasing sequence from `heights[0]` to `heights[i]`.
  - The heights then form a decreasing sequence from `heights[i]` to `heights[N-1]`.

You need to return the length of the longest tree arrangement that follows these conditions. If no such arrangement exists, return 0.

## Input Format
- Line 1: An integer `N`, the number of trees.
- Line 2: N space-separated integers, representing the heights of the trees.

## Output Format
- Output an integer, the length of the longest tree arrangement.

## Constraints
- 3 <= N <= 1000
- 1 <= heights[i] <= 1000

## Sample Input 1  
```
8
4 2 5 7 4 2 3 6
```

## Sample Output 1  
```
5
```

### Explanation  
The longest tree arrangement is: `2 5 7 4 2`. It starts by increasing up to 7 and then decreases. The length of this arrangement is 5.

## Sample Input 2  
```
4
2 4 5 7
```

## Sample Output 2  
```
0
```

### Explanation  
No such arrangement is possible since there is no peak where the heights increase and then decrease. Hence, the result is 0.

## Solution Code  

```java
import java.util.*;

public class program {
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;

        int res = 0, start = 0;

        while(start < n) {
            int end = start;

            // Check for potential mountain starting point
            if(start + 1 < n && arr[start] < arr[start + 1]) {
                while(end + 1 < n && arr[end] < arr[end + 1]) end++;

                // Check if mountains descends after peak
                if(end + 1 < n && arr[end] > arr[end + 1]) {
                    while(end + 1 < n && arr[end] > arr[end + 1]) end++;

                    // Update only if there is a mountain
                    res = Math.max(res, end - start + 1);
                }
            }

            // skip to end if mountain found, else move start by 1
            start = Math.max(end, start + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println(longestMountain(nums));
    }
}
```