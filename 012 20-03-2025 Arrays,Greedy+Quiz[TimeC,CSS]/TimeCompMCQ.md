# Time Complexity - MCQ

### Question 1
```java
for (int i = 1; i <= n; i*=2){
    for (int j = 1; j <= i; j++) {
        // Constant time operation
    }
}
```
What is the time complexity of the above code?
- a. O(n)
- b. O(n^2)
- c. O(n log n)
- d. O(log^2 n)

<details>
  <summary>Answer</summary>

  - d. O(log^2 n)

  **Explanation:** The outer loop runs log n times, and the inner loop runs i times, where i doubles each time. The total complexity is O(log^2 n).
</details>

### Question 2
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= sqrt(n); j++) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n sqrt{n})
- b. O(n log n)
- c. O(n^2)
- d. O(n)

<details>
  <summary>Answer</summary>

  - a. O(n sqrt{n})

  **Explanation:** The outer loop runs n times, and the inner loop runs sqrt(n) times. The total complexity is O(n sqrt{n}).
</details>

### Question 3
```java
void recursive(int n) {
    if (n <= 1) return;
    recursive(n/2);
    recursive(n/2);
}
```
What is the time complexity?
- a. O(n)
- b. O(n log n)
- c. O(log n)
- d. O(2^log n)

<details>
  <summary>Answer</summary>

  - a. O(n)

  **Explanation:** This is a binary recursive function where each call makes two more calls, halving n each time. The total complexity is O(n).
</details>

### Question 4
```java
for (int i = 1; i < n; i *= 3) {
    // Constant time operation
}
```
What is the time complexity?
- a. O(n)
- b. O(n log n)
- c. O(n^2)
- d. O(log n)

<details>
  <summary>Answer</summary>

  - d. O(log n)

  **Explanation:** The loop runs until i exceeds n, tripling each time. The total complexity is O(log n).
</details>

### Question 5
```java
void recur(int n) {
    if (n <= 1) return;
    recur(n/3);
    recur(n/3);
    recur(n/3);
}
```
What is the time complexity?
- a. O(n log n)
- b. O(n)
- c. O(3^log n)
- d. O(log n)

<details>
  <summary>Answer</summary>

  - b. O(n)

  **Explanation:** This is a ternary recursive function where each call makes three more calls, dividing n by 3 each time. By the Master Theorem, this follows T(n) = 3T(n/3) + O(1), which gives us O(n^(log_3 3)) = O(n^1) = O(n).
</details>

### Question 6
```java
for (int i = n; i > 1; i /= 2) {
    for (int j = 1; j <= i; j++) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n log n)
- b. O(n)
- c. O(n^2)
- d. O(log n)

<details>
  <summary>Answer</summary>

  - b. O(n)

  **Explanation:** The outer loop runs log n times (i halves each iteration from n to 1). The inner loop runs i times, where i is n, n/2, n/4, ..., 1. This gives us n + n/2 + n/4 + ... + 1 ≈ 2n operations, which is O(n).
</details>

### Question 7
```java
int fib(int n) {
    if (n <= 1) return 1;
    return fib(n-1) + fib(n-2);
}
```
What is the time complexity?
- a. O(n)
- b. O(log n)
- c. O(n^2)
- d. O(2^n)

<details>
  <summary>Answer</summary>

  - d. O(2^n)

  **Explanation:** This is the classic Fibonacci recursive function, which has exponential time complexity due to repeated calculations.
</details>

### Question 8
```java
for (int i = 1; i <= n; i *= 2) {
    for (int j = i; j <= n; j++) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n^2)
- b. O(n log n)
- c. O(n)
- d. O(log n)

<details>
  <summary>Answer</summary>

  - b. O(n log n)

  **Explanation:** The outer loop runs log n times, and the inner loop runs n - i + 1 times. The total complexity is O(n log n).
</details>

### Question 9
```java
void recurse(int n) {
    if (n <= 1) return;
    recurse(n/2);
    recurse(n/3);
}
```
What is the time complexity?
- a. O(log n)
- b. O(n log n)
- c. O(n^0.788)
- d. O(2^n n)

<details>
  <summary>Answer</summary>

  - c. O(n^0.788)

  **Explanation:** This recursive function follows T(n) = T(n/2) + T(n/3) + O(1). This is more complex than standard cases in the Master Theorem. The solution is O(n^α) where α is the solution to 2^-α + 3^-α = 1, which is approximately 0.788.
</details>

### Question 10
```java
for (int i = 1; i <= n; i++) {
    for (int j = i; j <= n; j++) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n log n)
- b. O(n^2)
- c. O(n)
- d. O(n^3)

<details>
  <summary>Answer</summary>

  - b. O(n^2)

  **Explanation:** The outer loop runs n times, and the inner loop runs n - i + 1 times. The total complexity is O(n^2).
</details>

### Question 11
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n^3)
- b. O(n^2)
- c. O(n)
- d. O(n log n)

<details>
  <summary>Answer</summary>

  - b. O(n^2)

  **Explanation:** The outer loop runs n times, and the inner loop runs i times. The total complexity is O(n^2).
</details>

### Question 12
```java
void divRecur(int n) {
    if (n <= 1) return;
    divRecur(n / 4);
}
```
What is the time complexity?
- a. O(n)
- b. O(log n)
- c. O(n log n)
- d. O(2^n n)

<details>
  <summary>Answer</summary>

  - b. O(log n)

  **Explanation:** This recursive function divides n by 4 each time. The number of recursive calls is log_4(n), which is O(log n).
</details>

### Question 13
```java
for (int i = 1; i < n; i *= 2) {
    for (int j = i; j < n; j += i) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(log n)
- b. O(n log n)
- c. O(n^2)
- d. O(n)

<details>
  <summary>Answer</summary>

  - d. O(n)

  **Explanation:** The outer loop runs log n times, and the inner loop runs (n - i) / i times. The total complexity is O(n).
</details>

### Question 14
```java
void expRecur(int n) {
    if (n <= 1) return;
    expRecur(n-1);
    expRecur(n-1);
}
```
What is the time complexity?
- a. O(n log n)
- b. O(log n)
- c. O(n)
- d. O(2^n)

<details>
  <summary>Answer</summary>

  - d. O(2^n)

  **Explanation:** This recursive function makes two calls, decrementing n by 1 each time. The total complexity is O(2^n).
</details>

### Question 15
```java
for (int i = 1; i < n; i *= 2) {
    for (int j = i; j < n; j *= 2) {
        // Constant time operation
    }
}
```
What is the time complexity?
- a. O(n^2)
- b. O(log^2 n)
- c. O(n log n)
- d. O(n)

<details>
  <summary>Answer</summary>

  - b. O(log^2 n)

  **Explanation:** Both loops run log n times. The total complexity is O(log^2 n).
</details>