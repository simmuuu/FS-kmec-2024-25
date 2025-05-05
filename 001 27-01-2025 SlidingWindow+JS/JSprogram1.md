# Vowel and Consonant Counter

## Problem Description

You are given a string `str`, and your task is to find the number of vowels and consonants in the string.

### Input Format
- **Line-1:** A string

### Output Format
- **Line-1:** A number, Vowels count
- **Line-2:** A number, Consonants count

### Sample Input-1
```
Hello
```

### Sample Output-1
```
Vowels: 2
Consonants: 3
```

### Sample Input-2
```
Hello world
```

### Sample Output-2
```
Vowels: 3
Consonants: 7
```

## Solution

```javascript
const countVowels = (str) => {
    str = str.toLowerCase();
    let vowels = 'aeiou';
    let count1 = 0, count2 = 0;
    
    for(let i = 0; i < str.length; i++) {
        if (vowels.includes(str[i])) count1++;
        else if (str[i] >= 'a' && str[i] <= 'z') count2++;
    }

    // better code | uses REGEX
    for(let char of str) {
        if(/[a-zA-Z]/.test(char)) {
            if(vowels.includes(char)) count1++;
            else count2++;
        }
    }
    
    return {
        count1, count2
    }
};
```