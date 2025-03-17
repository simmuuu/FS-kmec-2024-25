# Prime Sequence Beauty Calculator

## Problem Description

In a distant galaxy, there exists an ancient space station covered in a vast array of digital codes. These codes are believed to hold the key to unlocking powerful alien technology. The interstellar explorers call these codes "prime sequences."

The prime-sequence beauty of the digital code is defined as the number of prime sequences that meet the following conditions:
- The prime sequence has a length of `k`.
- The prime sequence is a divisor of the entire digital code.
- The prime sequence is a prime number.

Given the digital code on the space station, represented as an integer `code`, and the length of the prime sequences `k`, return the prime-sequence beauty of the code.

### Input Format
- **Line-1:** Space-separated string and integer, `code` and `k`.

### Output Format
- An integer, the prime-sequence beauty of the code.

### Sample Input-1
```
239246 2
```

### Sample Output-1
```
1
```

**Explanation:**
The following are the prime sequences of length `k`:
- `"23"` from `"239246"`: `23` is a divisor of `239246` and is a prime number.
- `"39"` from `"239246"`: `39` is not a divisor.
- `"92"` from `"239246"`: `92` is not a divisor.
- `"24"` from `"239246"`: `24` is not a divisor.
- `"46"` from `"239246"`: `46` is a divisor of `239246` but is not a prime number.
Therefore, the prime-sequence beauty is `1`.

### Sample Input-2
```
24224 1
```

### Sample Output-2
```
3
```

## Solution

```java
import java.util.*;

public class Program2 {
    public static int sol(String code, int window) {
        int i = 0;
        int totalPassed = 0;
        int intInp = Integer.valueOf(code);

        while (i + window - 1 < code.length()) {
            int subNum = Integer.valueOf(code.substring(i, i + window));

            if (intInp % subNum == 0 && isPrime(subNum)) totalPassed++;
            i++;
        }

        return totalPassed;
    }

    public static boolean isPrime(int x) {
        if (x == 0 || x == 1) return false;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digiCode = sc.next();
        int windowSize = sc.nextInt();

        System.out.println(sol(digiCode, windowSize));

        sc.close();
    }
}
```