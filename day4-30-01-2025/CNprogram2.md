# Network and Broadcast Address Calculator

## Problem Description

Write a program that takes an IP address and subnet mask (in CIDR notation, e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

### Input Format
- **Line-1:** A String, `IPAddress`
- **Line-2:** An integer, `CIDR`

### Output Format
- Space-separated IP addresses, network IP and broadcast IP.

### Sample Input-1
```
192.168.1.10
24
```

### Sample Output-1
```
192.168.1.0 192.168.1.255
```

### Sample Input-2
```
192.0.2.1
24
```

### Sample Output-2
```
192.0.2.0 192.0.2.255
```

## Solution

```java
import java.net.*;
import java.nio.*;
import java.util.*;

public class CNprogram2 {

    public static String sol(String ipAddr, int cidr) throws Exception {
        int ip = ByteBuffer.wrap(
            InetAddress.getByName(ipAddr).getAddress()
        ).getInt();
        int mask = 0xffffffff << (32 - cidr);
        int network = ip & mask;
        int broadcast = network | ~mask;
        return toIp(network) + " " + toIp(broadcast);
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
        String ipAddr = sc.nextLine();
        int cidr = sc.nextInt();
        System.out.println(sol(ipAddr, cidr));
        sc.close();
    }
}