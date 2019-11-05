-- part (a)
SELECT      Author
FROM        Book
GROUP BY    Author 
HAVING      COUNT(*) >= ALL (
        SELECT COUNT(*) FROM Book GROUP BY Author
)

-- part (b)
SELECT      RDNR, Firstname
FROM        Reader, Loan, Book
WHERE       Reader.RDNR = Loan.ReaderNr AND Loan.ISBN = Book.ISBN 
AND         Book.Author = 'Philip S. Yu'
GROUP BY    RDNR
HAVING      COUNT(Loan.ISBN) < (
        SELECT COUNT(*) FROM Book WHERE Author = 'Philip S. Yu'
)       