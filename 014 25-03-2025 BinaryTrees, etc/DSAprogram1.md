# Kiran's Jumping Game

## Problem Description

Kiran is playing a Jumping game on a flat surface XY. Initially, Kiran's position is at the center (x,y) = (0,0). He can jump one unit of length in one of the four directions: upside (U), downside (D), rightside (R), or leftside (L).

You are given a jumping sequence of Kiran as a string that contains only the characters U, D, L, and R. Your task is to determine whether Kiran returns to his initial position at the end of all jumps.

If he returns to (0,0), print `true`. Otherwise, print `false`.

## Input Format
- A string `jumps`, representing the jumping sequence (contains only U, R, L, D).

## Output Format
- Print a boolean value (`true` or `false`).

## Sample Input 1
```
UDRL
```

## Sample Output 1
```
true
```

### Explanation
Kiran's initial position is (0,0), and the jumps are:
- `U` -> (0,0) → (0,1)
- `D` -> (0,1) → (0,0)
- `R` -> (0,0) → (1,0)
- `L` -> (1,0) → (0,0)

Final position is (0,0), so the output is `true`.

## Sample Input 2
```
UURRLD
```

## Sample Output 2
```
false
```

### Explanation
Kiran's initial position is (0,0), and the jumps are:
- `U` -> (0,0) → (0,1)
- `U` -> (0,1) → (0,2)
- `R` -> (0,2) → (1,2)
- `R` -> (1,2) → (2,2)
- `L` -> (2,2) → (1,2)
- `D` -> (1,2) → (1,1)

Final position is (1,1), so the output is `false`.

## Solution

```java
import java.util.*;

public class JumpingGame {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] moves = sc.nextLine().split("");

        int x = 0, y = 0;

        for(String move: moves) {
            switch (move) {
                case "U":
                    y += 1;
                    break;
                case "D":
                    y -= 1;
                    break;
                case "R":
                    x += 1;
                    break;
                case "L":
                    x -= 1;
                    break;
                default:
                    break;
            }
        }

        System.out.println(x == 0 && y == 0);
        sc.close();
    }
}
```

