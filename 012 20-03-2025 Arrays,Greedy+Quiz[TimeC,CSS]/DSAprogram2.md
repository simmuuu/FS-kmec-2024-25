# Minimum Sum of Two Numbers from Digits of N

## Problem Description
A math teacher gives students a **4-digit number (N)** ranging from **1000 to 9999**. The task is to create two numbers **N1** and **N2** using all the digits of **N**, such that:
- Each digit must be used exactly **once**.
- Both **N1** and **N2** must be between **0 to 999** (leading zeros allowed).
- The sum **N1 + N2** should be **minimum**.

Your task is to compute and print this minimum sum.

---

### Input Format:
- A single integer **N** (1000 ≤ N ≤ 9999).

### Output Format:
- Print a single integer, the minimum sum of **N1** and **N2**.

---

### Sample Input-1:
```text
7512
```

### Sample Output-1:
```text
42
```

#### Explanation:
Possible pairs of **N1** and **N2** include:
- (125,7) → 125 + 7 = **132**
- (12,57) → 12 + 57 = **69**
- (157,2) → 157 + 2 = **159**
- (17,25) → 17 + 25 = **42** (Minimum sum)
- (15,27) → 15 + 27 = **42** (Minimum sum)

---

### Sample Input-2:
```text
5004
```

### Sample Output-2:
```text
9
```

#### Explanation:
- (04, 5) → 4 + 5 = **9** (Minimum sum)



## Solution
```java
import java.util.*;

public class DSAprogram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inp = sc.nextLine().split("");
        Arrays.sort(inp);

        System.out.println(Integer.parseInt(inp[0] + inp[2]) + Integer.parseInt(inp[1] + inp[3]));
        sc.close();
    }
}
```

