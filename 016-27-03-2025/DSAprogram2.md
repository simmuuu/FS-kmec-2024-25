# Steps to Reduce a Binary Number to 1  

## Problem Description  

Neeraj has a task to reduce a number **N** to **1** using the following rules:  
1. If **N** is odd → Add **1** to it.  
2. If **N** is even → Divide **N** by **2**.  

The number **N** is given as a **binary string** `S`.  

Your task is to determine the **minimum number of steps** required to reduce `N` to `1`.  


## Input Format  
- A single binary string **S**, representing **N**.  

## Output Format  
- Print the **minimum number of steps**.  


## Constraints  
- $1 \leq S.length \leq 200$
- `S` consists only of `'0'` and `'1'`.  
- `S` does not have leading zeros.  


## Sample Input 1  
```
110
```

## Sample Output 1  
```
4
```

### Explanation  
- `110` (6) → Even → `6 / 2 = 3`  
- `11` (3) → Odd → `3 + 1 = 4`  
- `100` (4) → Even → `4 / 2 = 2`  
- `10` (2) → Even → `2 / 2 = 1`  
- **Total Steps: 4**  


## Sample Input 2  
```
101
```

## Sample Output 2  
```
5
```

### Explanation  
- `101` (5) → Odd → `5 + 1 = 6`  
- `110` (6) → Even → `6 / 2 = 3`  
- `11` (3) → Odd → `3 + 1 = 4`  
- `100` (4) → Even → `4 / 2 = 2`  
- `10` (2) → Even → `2 / 2 = 1`  
- **Total Steps: 5**  


## Solution Code  

```java
import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        int count = 0;

        while (!inp.equals("1")) {
            int len = inp.length();

            if (inp.charAt(len - 1) == '0') {  // Even case
                inp = inp.substring(0, len - 1);
            } else {  // Odd case (Adding 1)
                StringBuilder sb = new StringBuilder(inp);
                int i = len - 1;
                
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                
                if (i < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }

                inp = sb.toString();
            }
            count++;
        }

        System.out.println(count);
        sc.close();
    }
}
```
