# Pascal's Triangle Row Generator

## Problem Description
Pascal's Triangle is a triangular array of numbers where each number is the sum of the two numbers directly above it. The triangle looks like this:

```
        1
      1   1
    1   2   1
  1   3   3   1
```

You can generate an arbitrary number of rows, with the rows indexed from 0 onwards.

Given an integer `N`, your task is to print the `N`-th row of Pascal's Triangle.

## Input Format
- An integer `N`, representing the row index.

## Output Format
- Print the `N`-th row of Pascal's Triangle as space-separated integers.

## Sample Input 1
```
1
```

## Sample Output 1
```
1 1
```

## Sample Input 2
```
3
```

## Sample Output 2
```
1 3 3 1
```

## Solution

```java
import java.util.*;

public class PascalTriangle {
    public static void sol(int row) {
        List<List<Integer>> l = genPascal(row);

        for(int i: l.get(row)) {
            System.out.print(i + " ");
        }
    }

    private static List<List<Integer>> genPascal(int n) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(List.of(1));

        for(int i = 1; i <= n; i++) { // row
            List<Integer> rowList = new ArrayList<>();

            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) rowList.add(1);
                else {
                    rowList.add(l.get(i - 1).get(j) + l.get(i - 1).get(j - 1));
                }
            }

            l.add(rowList);
        }

        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        sol(row);

        sc.close();
    }
}
```

