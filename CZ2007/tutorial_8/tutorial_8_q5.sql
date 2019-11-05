-- part (a)
CREATE ASSERTION NoRedGreenParts CHECK (
    NOT EXISTS (
        (SELECT     C1.sid
        FROM        Catalog C1, Parts P1
        WHERE       C1.sid = P1.pid
        AND         P1.color = 'Red')
        INTERSECT
        (SELECT     C2.sid
        FROM        Catalog C2, Parts P2
        WHERE       C2.sid = P2.pid
        AND         P2.color = 'Green')
    )
);

-- (b)
CREATE ASSERTION NoLowerPriceThanSid1 CHECK (
    NOT EXISTS (
        SELECT      C
        FROM        Catalog C1, Catalog C2
        WHERE       C1.pid = C2.pid
        AND         C2.sid = 1
        AND         C1.price < C2.price
    )
);