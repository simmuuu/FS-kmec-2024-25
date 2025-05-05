
### **Schema:**

```sql
/*
Database : univ
---------------

employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary INT,
    hire_date DATE
);

projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    department VARCHAR(50)
);

employee_projects (
    employee_id INT,
    project_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id)
);

*/
```

---

### 1. **Rank employees based on their salary within their department**

```sql
/*
Write a query to assign a rank to each employee based on their salary within 
their department (higher salary → higher rank). If multiple employees have the 
same salary, they should share the same rank.
*/

use univ;
select name, department, salary, RANK() over (Partition by department order by salary desc) as dept_rank 
from employees;
```

#### Sample Output:

| name    | department  | salary | dept\_rank |
| ------- | ----------- | ------ | ---------- |
| Diana   | Engineering | 71000  | 1          |
| Charlie | Engineering | 70000  | 2          |
| Alice   | Engineering | 68000  | 3          |

---

### 2. **Rank employees in each department based on their hire date**

```sql
/*
Write a query to rank employees in each department based on their hire date, 
such that the earliest hired employee gets the highest rank (1).
*/

use univ;
select name, department, hire_date, RANK() over (Partition by department order by hire_date asc) as seniority_rank 
from employees;
```

#### Sample Output:

| name    | department  | hire\_date | seniority\_rank |
| ------- | ----------- | ---------- | --------------- |
| Grace   | Engineering | 2018-12-05 | 1               |
| Charlie | Engineering | 2019-06-01 | 2               |
| Alice   | Engineering | 2020-01-01 | 3               |

---

### 3. **Assign a unique row number to each employee in a department, ordered by their hire date**

```sql
/*
Write a query that assigns a unique row number to each employee in a department, 
ordered by their hire date.
*/

use univ;
select name, department, hire_date, ROW_NUMBER() over (Partition by department order by hire_date) as row_num 
from employees;
```

#### Sample Output:

| name    | department  | hire\_date | row\_num |
| ------- | ----------- | ---------- | -------- |
| Grace   | Engineering | 2018-12-05 | 1        |
| Charlie | Engineering | 2019-06-01 | 2        |
| Alice   | Engineering | 2020-01-01 | 3        |

---

### 4. **Number employees across the company based on descending salary (highest salary = row number 1)**

```sql
/*
Write a query that numbers employees across the company based on descending 
salary (highest salary = row number 1).
*/

use univ;
select name, department, salary, ROW_NUMBER() over (order by salary desc) as salary_position 
from employees;
```

#### Sample Output:

| name    | department  | salary | salary\_position |
| ------- | ----------- | ------ | ---------------- |
| Diana   | Engineering | 71000  | 1                |
| Charlie | Engineering | 70000  | 2                |
| Alice   | Engineering | 68000  | 3                |

---

### 5. **Display each employee's name, department, salary, and the average salary of employees in the same department**

```sql
/*
Write a query that displays each employee's name, department, salary, and 
the average salary of employees in the same department.
*/

use univ;
select name, department, salary, AVG(salary) over (Partition by department) as avg_dept_salary 
from employees;
```

#### Sample Output:

| name    | department  | salary | avg\_dept\_salary |
| ------- | ----------- | ------ | ----------------- |
| Charlie | Engineering | 70000  | 70000.0000        |
| Diana   | Engineering | 71000  | 70000.0000        |
| Alice   | Engineering | 68000  | 70000.0000        |

---

### 6. **Calculate the running total of employee salaries ordered by their hire date**

```sql
/*
Write a query to calculate the running total of employee salaries ordered by 
their hire date.
*/

use univ;
select name, hire_date, salary, Sum(salary) over (order by hire_date) as running_salary_total 
from employees;
```

#### Sample Output:

| name    | hire\_date | salary | running\_salary\_total |
| ------- | ---------- | ------ | ---------------------- |
| Grace   | 2018-12-05 | 69000  | 69000                  |
| Charlie | 2019-06-01 | 70000  | 139000                 |
| Alice   | 2020-01-01 | 68000  | 207000                 |

---

### 7. **Show each employee and the total number of employees in their department**

```sql
/*
Write a query to show each employee and the total number of employees in their 
department.
*/

use univ;
select name, department, count(name) over (Partition by department) as dept_count 
from employees;
```

#### Sample Output:

| name    | department  | dept\_count |
| ------- | ----------- | ----------- |
| Grace   | Engineering | 3           |
| Charlie | Engineering | 3           |
| Alice   | Engineering | 3           |

---

### 8. **Find the maximum salary among employees who were hired after January 1, 2020**

```sql
/*
Write a query to find the maximum salary among employees who were hired after 
January 1, 2020.
*/

use univ;
select name, hire_date, salary, MAX(salary) over () as max_recent_salary 
from employees 
where hire_date > '2020-01-01';
```

#### Sample Output:

| name  | hire\_date | salary | max\_recent\_salary |
| ----- | ---------- | ------ | ------------------- |
| Alice | 2020-01-15 | 50000  | 71000               |
| Bob   | 2021-03-10 | 52000  | 71000               |

---

