-- part (a)
SELECT      citedArticleID, citedIssueID
FROM        Citation
GROUP BY    citedArticleID, citedIssueID
HAVING      COUNT(*) >= ALL (
    SELECT      COUNT(*)
    FROM        Citation
    GROUP BY    citedArticleID, citedIssueID
)

-- part (b)
SELECT      author, COUNT(*)
FROM        Article, Citation
WHERE       Article.issueID = Citation.citedIssueID
AND         Article.articleID = Citation.citedArticleID
AND EXISTS  (
            SELECT      *
            FROM        Issue
            WHERE       Issue.issueID = Article.issueID
            AND         year(getDate()) - year(Issue.date) > 10
)
GROUP BY    author