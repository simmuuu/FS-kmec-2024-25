# Comparing Typed Words on a Defective Keyboard  

## Problem Description  

Ram and Bheem are using a defective keyboard where pressing the backspace button (`$`) does not remove the last character but instead prints a `$`. They both tried to type a word on the same keyboard.  

Your task is to determine whether both typed the same word after considering the backspace behavior.  

Return **true** if both words match, otherwise return **false**.  

**Note:**  
- A backspace (`$`) for an empty text will keep it empty.  



## Input Format  
- A single line containing two space-separated strings `w1` and `w2`.  

## Output Format  
- Print a boolean result (`true` or `false`).  



## Constraints  
- $1 <= w1.length, w2.length <= 200$
- `w1` and `w2` contain only lowercase letters and the `$` character.  



## Sample Input 1  
```
pq$r  pt$r
```

## Sample Output 1  
```
true
```

### Explanation  
Both resolve to `"pr"`, so the words match.



## Sample Input 2  
```
se$$at cea$$t
```

## Sample Output 2  
```
false
```



## Sample Input 3  
```
s$$at ce$$at
```

## Sample Output 3  
```
true
```

### Explanation  
Both resolve to `"at"`, so the words match.



## Solution Code  

```java
import java.util.*;

public class DSAprogram2 {
    private static boolean sol(String s1, String s2) {
        return process(s1).equals(process(s2));
    }

    private static String process(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '$') stack.push(c);
            else if (!stack.isEmpty()) stack.pop();
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(sol(s1, s2));
        sc.close();
    }
}
```

