# Finding Dimensions of a Portrait

## Problem Description

Mr. Chandra has a portrait photo with dimensions M × N pixels, where:
- M is the length of the portrait.
- N is the width of the portrait.

You are given an integer `S`, representing the total size of the portrait in pixels (`S = M × N`).

Your task is to determine the actual values `[M, N]` following these conditions:
- The size of the portrait should be exactly `S`, i.e., `S = M × N`.
- `N` should always be smaller than or equal to `M` (`N ≤ M`).
- The difference between length and width (`M - N`) should be minimized.

## Input Format
- A single integer `S`, representing the size of the portrait.

## Output Format
- Print two integers `M` and `N`, representing the dimensions of the portrait.

## Sample Input 1
```
24
```

## Sample Output 1
```
6 4
```

## Sample Input 2
```
550
```

## Sample Output 2
```
25 22
```

## Solution

```java
import java.util.*;

public class DSAprogram2 {
    public static String sol(int s) {
        int m, n;
        m = n = (int)Math.sqrt(s);

        while(m * n != s) {
            if(m * n < s) {
                m++;
            } else {
                n--;
            }
        }

        return String.format("%d %d", m, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        System.out.println(sol(s));

        sc.close();
    }
}
```

