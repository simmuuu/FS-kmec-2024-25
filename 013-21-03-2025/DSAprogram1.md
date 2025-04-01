# Possible Valid Times for a Digital Clock

## Problem Description

Mr. Kejriwal purchased a digital clock that displays time in "hh:mm" 24-hour format. Due to a technical issue, some digits on the display are replaced with the '#' symbol.

Since Mr. Kejriwal is an IIT student, he came up with an idea to determine the number of valid times by replacing '#' with valid digits between 0-9.

Your task is to help Mr. Kejriwal find the number of possible valid times.

### Constraints
- The valid time must be in the range of `00:00` to `23:59`.

## Input Format
- A string `T`, representing the time in 24-hour format as "hh:mm", where some digits may be replaced by `#`.

## Output Format
- Print an integer representing the number of valid times.

## Sample Input 1
```
#6:00
```

## Sample Output 1
```
2
```

### Explanation
The valid times after replacing `#` with 0 or 1 are:
- `06:00`
- `16:00`

## Sample Input 2
```
0#:0#
```

## Sample Output 2
```
100
```

### Explanation
To make the given time valid:
- Replace the first `#` with any digit from `0-9` (10 choices).
- Replace the second `#` with any digit from `0-9` (10 choices).

Total valid combinations: `10 × 10 = 100`

## Solution

```java
import java.util.*;

public class DSAprogram1 {
    public static int sol(String inp) {
        char h1 = inp.charAt(0);
        char h2 = inp.charAt(1);
        char m1 = inp.charAt(3);
        char m2 = inp.charAt(4);
        
        int count = 1;

        if(h1 == '#') {
            int h = 0;

            for(int i = 0; i <= 2; i++) {
                if(h2 == '#') {
                    if(i == 2) {
                        h += 4; // If 2#, then # (0 - 3) 
                    } else {
                        h += 10; // If 2#, then # (0 - 9)
                    }
                } else {
                    int hh2 = h2 - '0';
                    if(i < 2 || (i == 2 && hh2 <= 3)) {
                        h++;
                    }
                }
            }
            count *= h;
        } else if(h2 == '#') { // for x#:
            if(h1 == '2') { // 2# #(0-3)
                count *= 4;
            } else {
                count *= 10;
            }
        }

        if(m1 == '#') count *= 6; // :#x # == 6
        if(m2 == '#') count *= 10; // :x# # == 10

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inp = sc.nextLine();
        System.out.println(sol(inp));
        sc.close();
    }
}
```

