SELECT  DISTINCT issueID, articleID
FROM    WordAppears wa1, WordIs wi1,
        WordAppears wa2, WordIs wi2
WHERE   wa1.issueID = wi1.issueID 
        AND wa1.articleID = wi1.articleID 
        AND wi1.wordText = 'politican'
AND     wa2.issueID = wi2.issueID 
        AND wa2.articleID = wi2.articleID 
        AND wi2.wordText = 'corruptiom';