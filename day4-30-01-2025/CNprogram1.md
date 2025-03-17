# Subnet Mask Calculator

## Problem Description

Write a program that takes an IP address and subnet mask (in CIDR notation, e.g., `192.168.1.1/24`) as input and calculates the subnet mask in dotted decimal format.

### Input Format
- An integer, `CIDR`.

### Output Format
- A string, the subnet's IP address in dotted decimal format.

### Sample Input-1
```
25
```

### Sample Output-1
```
255.255.255.128
```

### Sample Input-2
```
22
```

### Sample Output-2
```
255.255.252.0
```

## Solution

```java
import java.util.*;

public class CNProgram1 {
    public static String sol(int cidr) {
        int mask = 0xffffffff << (32 - cidr);

        return String.format("%d.%d.%d.%d",
                                (mask >> 24) & 0xff,
                                (mask >> 16) & 0xff,
                                (mask >> 8) & 0xff,
                                mask & 0xff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cidr = sc.nextInt();
        System.out.println(sol(cidr));

        sc.close();
    }
}
```