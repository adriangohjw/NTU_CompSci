-- part (a)
SELECT  employee-name
FROM    works a
WHERE   salary > (
    SELECT  AVG(salary) 
    FROM    works b
    WHERE   a.company-name = b.company-name
);

-- part (b)
SELECT  employee-name 
FROM    employee emp, employee mng, manages mn
WHERE   emp.employee-name = mn.employee-name 
AND     mn.manager-name = mng.employee-name 
AND     emp.street = mng.street
AND     emp.city = mng.city