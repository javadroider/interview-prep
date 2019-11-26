
create table if not exists employee (emp_id INT AUTO_INCREMENT PRIMARY KEY, name varchar(20), mgr_id varchar(10), doj date);
create table if not exists employee_salary (emp_id INT, project varchar(20), salary int(10));

insert into employee values(121,'John',321,'2014-01-31');
insert into employee values(321,'Walter',986,'2015-01-30');
insert into employee values(421,'Kuldeep',876,'2016-11-27');
insert into employee values(431,'Tim',321,'2017-10-21');

insert into employee_salary values(121,'P1',8000);
insert into employee_salary values(321,'P2',1000);
insert into employee_salary values(421,'P1',12000);


select * from employee;
select * from employee_salary;

-- Fetch the count of employees working in project 'P1'

select count(*) from employee_salary where project='P1';

-- Fetch employee names having salary greater than or equal to 5000 and less than or equal 10000.

select name from employee_salary, employee where salary between 5000 and 10000 and employee_salary.emp_id=employee.emp_id;

select name from employee where emp_id in(select emp_id from employee_salary where salary between 5000 and 10000);

-- Fetch project-wise count of employees sorted by project's count in descending order.

select project,count(emp_id) cnt from employee_salary group by project order by cnt desc;

-- Fetch employee names and salary records. Return employee details even if the salary record is not present for the employee

select name, salary from employee left join employee_salary on employee.emp_id=employee_salary.emp_id;

-- Fetch all the Employees who are also managers from EmployeeDetails table.

select * from employee where emp_id in(select mgr_id from employee);

select distinct e.name from employee e inner join employee m on e.emp_id=m.mgr_id;

-- Fetch all employee records from Employee table who have a salary record in EmployeeSalary table.

select * from employee e inner join employee_salary s where e.emp_id=s.emp_id;

SELECT * FROM employee E WHERE EXISTS (SELECT * FROM employee_salary S WHERE  E.Emp_Id = S.Emp_Id);

-- Fetch duplicate records from a table

select emp_id, project, salary, count(*) from employee_salary group by emp_id, project, salary 
having count(*)>1;

select project, count(*) from employee_salary group by project having count(*)>1;

-- Remove duplicates from a table without using temporary table.

DELETE FROM employee_salary WHERE emp_id IN (SELECT emp_id FROM employee_salary GROUP BY project, salary HAVING COUNT(*) > 1);

-- Fetch top n records

select * from employee_salary order by salary desc limit 3;

-- Find the 2nd highest salary from table.

select max(salary) from employee_salary where salary not in(select max(salary) from employee_salary);

-- Find the nth highest salary from table.
-- http://www.mysqltutorial.org/mysql-limit.aspx

select * from employee_salary order by salary desc limit 2,1;

-- Find the 3rd highest salary from table without using TOP/limit keyword.
-- https://www.programmerinterview.com/database-sql/find-nth-highest-salary-sql/

select salary from employee_salary emp1 where 2 = (select count(distinct (emp2.salary)) from employee_salary emp2 where emp2.salary > emp1.salary);


