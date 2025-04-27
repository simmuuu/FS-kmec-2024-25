CREATE DATABASE IF NOT EXISTS sfd_demo_day1; 
USE DATABASE sfd_demo_day1; 
CREATE SCHEMA IF NOT EXISTS public; 
USE SCHEMA public;

CREATE OR REPLACE TABLE employee (
    employee_id INT,
    first_name STRING,
    last_name STRING,
    email STRING,
    department STRING
);

-- load csv here

SELECT * FROM employee ORDER BY employee_id;

CREATE MATERIALIZED VIEW IF NOT EXISTS mv_employee_department_count AS
SELECT department, COUNT(*) AS employee_count
FROM employee
GROUP BY department;

SELECT * FROM mv_employee_department_count;