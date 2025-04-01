# Scorecard Operations in a Game

## Problem Description

You are managing scores in a game with an initially empty scorecard. You will be given a string of operations, where each character represents a specific action:

- **A digit (0-9)** → Add this number to the scorecard.
- **'A' (Addition)** → Add a new score, which is the sum of the last two scores.
- **'D' (Double)** → Add a new score, which is double the previous score.
- **'R' (Remove)** → Invalidate and remove the last score from the scorecard.

Your task is to compute the sum of all remaining scores after performing all operations.


## Input Format
- A single string of characters representing the operations.

## Output Format
- Print an integer representing the sum of all remaining scores.


## Sample Input 1
```
526RDAA
```

## Sample Output 1
```
27
```

### Explanation:
```
'5'  → [5]
'2'  → [5, 2]
'6'  → [5, 2, 6]
'R'  → [5, 2]  (Remove last score)
'D'  → [5, 2, 4]  (Double last score: 2 * 2 = 4)
'A'  → [5, 2, 4, 6]  (Add last two: 2 + 4 = 6)
'A'  → [5, 2, 4, 6, 10]  (Add last two: 4 + 6 = 10)
```
Final sum = `5 + 2 + 4 + 6 + 10 = 27`



## Sample Input 2
```
1R
```

## Sample Output 2
```
0
```

### Explanation:
```
'1'  → [1]
'R'  → []  (Remove last score)
```
Final sum = `0`



## Solution Code
```java
import java.util.*;

public class DSAprogram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inp = sc.nextLine().toCharArray();
        List<Integer> list = new ArrayList<>();

        for (char c : inp) {
            int n = list.size();

            if (Character.isDigit(c)) {
                list.add(c - '0');
            } else if (c == 'R' && n > 0) {
                list.remove(n - 1);
            } else if (c == 'D' && n > 0) {
                list.add(2 * list.get(n - 1));
            } else if (c == 'A' && n > 1) {
                list.add(list.get(n - 1) + list.get(n - 2));
            }
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        sc.close();
    }
}
```

