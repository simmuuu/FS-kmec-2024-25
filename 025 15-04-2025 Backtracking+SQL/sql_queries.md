# SQL Queries on University Database

### Database Schema

```sql
Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    enrollment_year INT
);

Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    instructor VARCHAR(50)
);

Enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade CHAR(1),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);
```

---

##  Basic Queries

### 1. Display all records from the `Students` table

```sql
USE univ;

SELECT * FROM Students;
```

---

### 2. Retrieve students who enrolled in the year **2023**

```sql
USE univ;

SELECT * FROM Students
WHERE enrollment_year = 2023;
```

---

### 3. Find students with an `example.com` email address

```sql
USE univ;

SELECT * FROM Students
WHERE email LIKE '%example.com';
```

---

### 4. Find students enrolled in the course with `course_id = 101`

```sql
USE univ;

SELECT S.student_id, S.name, S.email, S.enrollment_year 
FROM Students S
JOIN Enrollments E ON S.student_id = E.student_id
WHERE E.course_id = 101;
```

---

## Advanced Queries

### 5. Number of students enrolled per course

```sql
USE univ;

SELECT C.course_name, COUNT(*) AS total_students
FROM Courses C
JOIN Enrollments E ON C.course_id = E.course_id
GROUP BY C.course_name;
```

---

### 6. Number of courses each student is enrolled in

```sql
USE univ;

SELECT S.name, COUNT(*) AS courses_enrolled
FROM Students S
JOIN Enrollments E ON S.student_id = E.student_id
GROUP BY S.student_id;
```

---

### 7. Number of students enrolled in each year

```sql
USE univ;

SELECT enrollment_year, COUNT(*) AS student_count
FROM Students
GROUP BY enrollment_year;
```

---

### 8. Students enrolled in more than 2 courses

```sql
USE univ;

SELECT S.student_id, COUNT(*) AS course_count
FROM Students S
JOIN Enrollments E ON S.student_id = E.student_id
GROUP BY E.student_id
HAVING COUNT(*) >= 3;
```

---

### 9. Courses with at least 10 students enrolled

```sql
USE univ;

SELECT C.course_id, COUNT(*) AS student_count
FROM Courses C
JOIN Enrollments E ON C.course_id = E.course_id
GROUP BY C.course_id
HAVING COUNT(*) >= 10;
```

---