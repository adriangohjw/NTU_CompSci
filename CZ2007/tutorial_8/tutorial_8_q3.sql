-- part (a)
UPDATE      employee
SET         street = 'Newstreet',
            city = 'Newtown'
WHERE       person-name = 'Mark';

-- part (b)
UPDATE      works
SET         salary = salary * 1.1
WHERE       company-name = 'FaceMatch';

-- part (c) 
UPDATE      works
SET         salary = salary * 1.1
WHERE       company-name = 'FaceMatch'
AND         person-name IN (
            SELECT      manager-name 
            FROM        mmanages 
);      