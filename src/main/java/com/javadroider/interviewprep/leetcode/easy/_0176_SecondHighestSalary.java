package com.javadroider.interviewprep.leetcode.easy;

public class _0176_SecondHighestSalary {
    /*

        SELECT
        IFNULL(
          (SELECT DISTINCT Salary
           FROM Employee
           ORDER BY Salary DESC
            LIMIT 1 OFFSET 1),
        NULL) AS SecondHighestSalary

     */
}
