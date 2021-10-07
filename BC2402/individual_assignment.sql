# Adrian Goh Jun Wei
# U1721134D

# 1 ############################

SELECT 
    date, total_vaccinations
FROM
    country_vaccinations
WHERE
    country = 'Singapore';


# 2 ############################

SELECT 
    vaccines, SUM(daily_vaccinations) AS `total_administrated`
FROM
    country_vaccinations
WHERE
    country IN ('Brunei' , 'Cambodia',
        'Indonesia',
        'Laos',
        'Malaysia',
        'Myanmar',
        'Philippines',
        'Singapore',
        'Thailand',
        'Vietnam')
GROUP BY vaccines
ORDER BY `total_administrated` DESC;


# 3 ############################

SELECT 
    country, MAX(daily_vaccinations_per_million)
FROM
    country_vaccinations
GROUP BY country
ORDER BY MAX(daily_vaccinations_per_million) DESC;


# 4 ############################

SELECT 
    vaccine, SUM(total_vaccinations) AS `total_administrated`
FROM
    country_vaccinations_by_manufacturer
GROUP BY vaccine
ORDER BY `total_administrated` DESC;


# 5 ############################

SELECT 
    vaccine, MIN(date) AS 'date'
FROM
    country_vaccinations_by_manufacturer
WHERE
    location = 'Italy'
GROUP BY vaccine
ORDER BY MIN(date) ASC;

SELECT 
    DATEDIFF(MAX(`date`), MIN(`date`)) AS 'Difference_In_Days'
FROM
    (SELECT 
        vaccine, MIN(date) AS 'date'
    FROM
        country_vaccinations_by_manufacturer
    WHERE
        location = 'Italy'
    GROUP BY vaccine
    ORDER BY MIN(date) ASC) AS italy_vaccine_first_dose_date;


# 6 ############################

SELECT 
    location, vaccine
FROM
    country_vaccinations_by_manufacturer
GROUP BY location, vaccine
HAVING location IN (SELECT 
        location
    FROM
        country_vaccinations_by_manufacturer
    GROUP BY location
    HAVING COUNT(DISTINCT vaccine) = (SELECT 
            COUNT(DISTINCT vaccine) AS `num_vaccine_type`
        FROM
            country_vaccinations_by_manufacturer
        GROUP BY location
        ORDER BY `num_vaccine_type` DESC
        LIMIT 1));


# 7 ############################

SELECT 
    country,
    vaccines,
    MAX(people_fully_vaccinated_per_hundred) AS 'vaccinated_percentage'
FROM
    country_vaccinations
GROUP BY country
HAVING `vaccinated_percentage` >= 60
ORDER BY `vaccinated_percentage` DESC;


# 8 ############################

SELECT 
    MONTHNAME(date) as 'month',
    vaccine,
    SUM(total_vaccinations) AS 'monthly_total_vaccinations'
FROM
    country_vaccinations_by_manufacturer
WHERE
    location = 'United States'
GROUP BY MONTHNAME(date), vaccine
ORDER BY MONTH(date);


# 9 ############################

SELECT 
    country,
    DATEDIFF(MIN(CASE
                WHEN total_vaccinations_per_hundred > 50 THEN STR_TO_DATE(`date`, '%m/%d/%Y')
                ELSE NULL
            END),
            MIN(STR_TO_DATE(`date`, '%m/%d/%Y'))) AS `Days_to_over_50%`
FROM
    country_vaccinations
GROUP BY country
HAVING MIN(CASE
    WHEN total_vaccinations_per_hundred > 50 THEN STR_TO_DATE(`date`, '%m/%d/%Y')
    ELSE NULL
END) IS NOT NULL;


# 10 ############################

SELECT 
    vaccine, SUM(total_vaccination) AS `global_total`
FROM
    (SELECT 
        vaccine,
            location,
            MAX(total_vaccinations) AS `total_vaccination`
    FROM
        country_vaccinations_by_manufacturer
    GROUP BY vaccine , location) total_vaccination_by_vaccine_and_country
GROUP BY vaccine
ORDER BY `global_total` DESC;
