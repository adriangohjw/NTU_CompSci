-- Part i
SELECT  Pname
FROM    PROF, DEPT
WHERE   PROF.Dname = DEPT.Dname
AND     Numphds < 50;

-- Part ii
SELECT  Sname, Dname
FROM    STUDENT S, COURSE C, MAJOR M, ENROLL E
WHERE   S.Sid = E.Sid  
AND     M.Sid = E.Sid
AND     E.Cno = C.Cno
AND     C.Dname = E.Dname 
AND     C.Cname = 'Database System'

-- Part iii
SELECT  Sid, Sname, GPA 
FROM    STUDENT S
WHERE   NOT EXISTS
        (
            SELECT  C.CID 
            FROM    COURSE C 
            WHERE   Dname = 'Civil Engineering'
            EXCEPT  
            SELECT  E.CID 
            FROM    ENROLL E 
            WHERE   Dname = 'Civil Engineering' AND E.Sid = S.Sid
        );