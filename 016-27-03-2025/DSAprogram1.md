# Longest Harmonious Substring  

## Problem Description  

A **harmonious string** is a string where every letter appears in both **uppercase** and **lowercase** forms.  

Given a string **S**, your task is to return the **longest harmonious substring** in **S**.  

If multiple substrings meet this criterion, return the **earliest** one.  

If there is no harmonious substring, return an **empty string**.  


## Input Format  
- A single string **S** containing uppercase and lowercase letters.  

## Output Format  
- Print the **longest harmonious substring**.  


## Constraints  
- $1 \leq S.length \leq 200$  
- S contains only uppercase and lowercase letters.  


## Sample Input 1  
```
QcvcCcq
```

## Sample Output 1  
```
cCc
```

### Explanation  
- The substring `"cCc"` contains both `'C'` and `'c'`.  
- No longer harmonious substring exists.  


## Sample Input 2  
```
pqrs
```

## Sample Output 2  
```
""
```

### Explanation  
- No uppercase-lowercase pairs exist, so the output is an empty string.  

## Solution Code  

```java
import java.util.*;

public class DSAprogram1 {
    private static boolean isHarmonious(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : set) {
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                return false;
            }
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();

        int maxLen = 0;
        String res = "";

        for (int i = 0; i < inp.length(); i++) {
            for (int j = i; j < inp.length(); j++) {
                String s = inp.substring(i, j + 1);
                if (s.length() > maxLen && isHarmonious(s)) {
                    maxLen = s.length();
                    res = s;
                }
            }
        }

        System.out.println(res);
        sc.close();
    }
}
```

