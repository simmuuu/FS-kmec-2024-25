# ===22-4-25===

```sql
/*
Write a query to assign a rank to each employee based on their salary within 
their department (higher salary → higher rank). If multiple employees have the 
same salary, they should share the same rank.


---------------
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


Sample Output:
--------------
name    department      salary  dept_rank                                       
Diana   Engineering     71000   1                                               
Charlie Engineering     70000   2                                                   


*/
use univ;
select name,department,salary,RANK() over(Partition by department order by salary desc) as dept_rank from employees;
/*
Write a query to rank employees in each department based on their hire date, 
such that the earliest hired employee gets the highest rank (1).


---------------
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


Sample Output:
--------------
name    department      hire_date       seniority_rank                          
Grace   Engineering     2018-12-05      1                                       
Charlie Engineering     2019-06-01      2                                       

*/
use univ;
select name,department,hire_date,RANK() over(Partition by department order by hire_date asc) as seniority_rank from employees;
/*
Write a query that assigns a unique row number to each employee in a department, 
ordered by their hire date.

---------------
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


Sample Output:
--------------
name    department      hire_date       row_num                                 
Grace   Engineering     2018-12-05      1                                       
Charlie Engineering     2019-06-01      2 

*/
use univ;
select name,department,hire_date,RANK() over(Partition by department order by hire_date ) as row_num from employees;
/*
Write a query that numbers employees across the company based on descending 
salary (highest salary = row number 1).


---------------
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


Sample Output:
--------------
name    department      salary  salary_position                                 
Diana   Engineering     71000   1                                               
Charlie Engineering     70000   2                                               


*/
use univ;
select name,department,salary,RANK() over(order by salary desc) as salary_position from employees;
/*
Write a query that displays each employee's name, department, salary, and 
the average salary of employees in the same department.


---------------
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


Sample Output:
--------------
name    department      salary  avg_dept_salary                                 
Charlie Engineering     70000   70000.0000                                      
Diana   Engineering     71000   70000.0000 

*/
use univ;
select name,department,salary,AVG(salary) over(Partition by department) as avg_dept_salary from employees;
/*
Write a query to calculate the running total of employee salaries ordered by 
their hire date.


---------------
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


Sample Output:
--------------
name    hire_date       salary  running_salary_total                            
Grace   2018-12-05      69000   69000                                           
Charlie 2019-06-01      70000   139000  

*/
use univ;
select name,hire_date,salary,Sum(salary) over(order by hire_date) as running_salary_total from employees;
/*
Write a query to show each employee and the total number of employees in their 
department.


---------------
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


Sample Output:
--------------
name    department      dept_count                                              
Charlie Engineering     3                                                       
Diana   Engineering     3                                                       

*/
use univ;
select name,department,count(name) over(Partition by department) as dept_count from employees;
/*
Write a query to find the maximum salary among employees who were hired after 
January 1, 2020.


---------------
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


Sample Output:
--------------
name    hire_date       salary  max_recent_salary                               
Alice   2020-01-15      50000   71000                                           
Bob     2021-03-10      52000   71000                                           

*/
use univ;
select name,hire_date,salary,MAX(salary) over() as max_recent_salary from employees where hire_date>'2020-01-01';


```