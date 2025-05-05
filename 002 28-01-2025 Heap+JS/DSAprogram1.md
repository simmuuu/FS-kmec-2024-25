# Student Organizer

## Problem Description

You are a student organizer, and you are given `n` students. Each student has two values:
- **Student Name:** A unique identifier for the student.
- **Score:** The score achieved by the student.

Your goal is to organize these students in the order of their scores (highest score first). If two students have the same score, order them alphabetically by their names.

Write a program to simulate how the students are organized using a priority queue.

### Input Format
- **Line-1:** An integer, `N`.
- **Next N lines:** Space-separated string and integer, name and score of each student.

### Output Format
- Organized students data as shown in samples.

### Sample Input-1
```
5
Alice 85
Bob 92
Charlie 78
Diana 95
Eve 88
```

### Sample Output-1
```
(Diana, 95)
(Bob, 92)
(Eve, 88)
(Alice, 85)
(Charlie, 78)
```

### Sample Input-2
```
4
Bob 90
Charlie 85
Diana 92
Alice 85
```

### Sample Output-2
```
(Diana, 92)
(Bob, 90)
(Alice, 85)
(Charlie, 85)
```

## Solution

```java
import java.util.*;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("(%s, %d)", name, score);
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return a.name.compareTo(b.name);
            }

            return b.score - a.score;
        });

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            pq.add(new Student(sc.next(), sc.nextInt()));
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        sc.close();
    }
}
```