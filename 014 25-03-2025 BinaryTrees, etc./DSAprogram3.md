# Maximum Product of Two Elements in a List

## Problem Description

You are given a list of positive integers `List[]`. Your task is to find the maximum possible product `P`, which is calculated as:

$P = (List[i] - 1) \times (List[j] - 1)$

where `i` and `j` are the indices of two different elements in the list.



## Input Format
- Line 1: An integer `N`, the number of elements in the list.
- Line 2: `N` space-separated positive integers.

## Output Format
- Print a single integer representing the maximum possible product.

## Sample Input 1
```
4
3 4 5 2
```

## Sample Output 1
```
12
```

## Sample Input 2
```
4
2 5 4 5
```

## Sample Output 2
```
16
```

## Solution Code
```java
import java.util.*;

public class DSAprogram3 {
    private static int sol(int[] nums, int n) {
        Arrays.sort(nums);
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sol(nums, n));

        sc.close();
    }
}
```