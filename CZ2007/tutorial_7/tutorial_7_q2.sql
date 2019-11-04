-- part (a)
SELECT  CategoryName
FROM    Category
WHERE   CategoryName NOT IN (
    SELECT DISTINCT BelongsTO FROM Category
);

-- part (b)
SELECT  Title
FROM    Book
WHERE   ISBN IN (
    SELECT  ISBN 
    FROM    Copy, Loan
    WHERE   Copy.ISBN = Loan.ISBN
    AND     Copy.CopyNumber - Loan.Copy >= 1 
);

-- part (c)
SELECT  Title
FROM    Book 
WHERE   NoPages > (
    SELECT 2 * AVG(NoPages) FROM Book
);

-- part (d)
SELECT  DISTINCT Surname
FROM    Reader 
WHERE   City = 'New York';