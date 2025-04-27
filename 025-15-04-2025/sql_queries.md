/*
Write a query to display all records from the Students table.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id  name    email               enrollment_year                                 
1           Alice   alice@example.com   2023                                    
2           Bob     bob@example.com     2022 


*/
USE univ;

SELECT * FROM Students;


/*
Write a query to display all records from the Students table.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id  name    email               enrollment_year                                 
1           Alice   alice@example.com   2023                                    
2           Bob     bob@example.com     2022 


*/
USE univ;

SELECT * FROM Students;


/*
Write a query to retrieve students who enrolled in the year 2023.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id  name    email               enrollment_year                                 
1           Alice   alice@example.com       2023                                    
3           Charlie charlie@example.com     2023 


*/

USE univ;

SELECT * FROM Students
WHERE enrollment_year=2023;

/*
Write a query to find students who have a example.com email address.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id      name    email           enrollment_year 
1               Alice   alice@kmec.com      2023                                            


*/

USE univ;

SELECT * FROM Students
WHERE email LIKE '%kmec.com';

/*
Write a query to find students enrolled in the course having course ID is 101.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id  name    email           enrollment_year                                 
1           Alice   alice@kmec.com  2023                                            
2           Bob     bob@ngit.com    2022                                            

*/

USE univ;

SELECT S.student_id, S.name, S.email, S.enrollment_year 
FROM Students S
JOIN Enrollments E
    ON S.student_id = E.student_id
WHERE E.course_id = 101;

## Advanced

/*
Write a query that shows the number of students enrolled per course.


---------------
Database Schema
---------------

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


Sample Output:
--------------
course_name         total_students                                                  
Database Systems        10                                                      
Operating Systems       9                                                       

*/

USE univ;

SELECT C.course_name, COUNT(*) as total_students
FROM Courses C
JOIN Enrollments E
    ON C.course_id = E.course_id
GROUP BY C.course_name;


/*
Write a query to find the number of courses each student is enrolled in.


---------------
Database Schema
---------------

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


Sample Output:
--------------
name    courses_enrolled                                                        
Alice   3                                                                       
Bob     3


*/

USE univ;

SELECT S.name, COUNT(*) as courses_enrolled
FROM Students S
JOIN Enrollments E
    ON S.student_id = E.student_id
GROUP BY S.student_id;

/*
How many students enrolled in each year? Write a query using GROUP BY


---------------
Database Schema
---------------

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


Sample Output:
--------------
enrollment_year student_count                                                   
2023            12                                                                      

*/

USE univ;

SELECT enrollment_year, COUNT(*) as student_count
FROM Students S
GROUP BY enrollment_year;

/*
Find students enrolled in more than 2 courses using GROUP BY and HAVING.


---------------
Database Schema
---------------

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


Sample Output:
--------------
student_id  course_count                                                    
1               3                                                                       
2               3                                                                       


*/
USE univ;

SELECT S.student_id, COUNT(*) as course_count
FROM Students S
JOIN Enrollments E
    ON S.student_id = E.student_id
GROUP BY E.student_id
HAVING COUNT(*) >= 3;

/*
Write a query to find courses with atleast 10 students enrolled.


---------------
Database Schema
---------------

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


Sample Output:
--------------
course_id   student_count                                                   
101             10                                                                      

*/
USE univ;

SELECT C.course_id, COUNT(*) as student_count
FROM Courses C
JOIN Enrollments E
    ON C.course_id = E.course_id
GROUP BY C.course_id
HAVING COUNT(*) >= 10;