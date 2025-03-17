# IP Address Range Checker

## Problem Description

Given two IP addresses `IP1` and `IP2`, and a subnet mask, your task is to check whether `IP1` and `IP2` belong to the same host range.

### Input Format
- **Line-1:** Two space-separated strings, `IP1` and `IP2`
- **Line-2:** An integer, `CIDR` (subnet mask)

### Output Format
- A boolean result indicating whether the IP addresses belong to the same host range.

### Sample Input-1
```
192.168.1.10 192.168.1.20
24
```

### Sample Output-1
```
true
```

### Sample Input-2
```
192.0.2.1 192.0.3.253
24
```

### Sample Output-2
```
false
```

## Solution

```java
import java.net.*;
import java.nio.*;
import java.util.*;

public class CNprogram1 {

    public static boolean sol(String ip1, String ip2, int cidr)
        throws Exception {
        int Bip1 = ByteBuffer.wrap(
            InetAddress.getByName(ip1).getAddress()
        ).getInt();
        int Bip2 = ByteBuffer.wrap(
            InetAddress.getByName(ip2).getAddress()
        ).getInt();
        int mask = 0xffffffff << (32 - cidr);
        int network1 = Bip1 & mask;
        int network2 = Bip2 & mask;
        return network1 == network2;
    }

    public static String toIp(int ip) {
        return String.format(
            "%d.%d.%d.%d",
            (ip >> 24) & 0xff,
            (ip >> 16) & 0xff,
            (ip >> 8) & 0xff,
            (ip) & 0xff
        );
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String ip1 = sc.next();
        String ip2 = sc.next();
        int cidr = sc.nextInt();

        System.out.println(sol(ip1, ip2, cidr));
        sc.close();
    }
}
```