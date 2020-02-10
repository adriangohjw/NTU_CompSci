# Database Schema explained

## movies

0. (String) title
1. (String) type
2. (String) synopsis
3. (String) rating
4. (String) movieReleaseDate
5. (String) director
6. (ArrayList<String>) cast
7. (ArrayList<Review>) reviews

## reviews

0. (User) user
1. (double) numOfStars
2. (String) additionalComment

## transactions

1. (String) TID 
2. (Movie_Goer) movieGoer

## users
- no need for a file as subclasses have their own attributes

## admin

0. (String) email
1. (String) passwordHashed
2. (int) role

## movieGoers

0. (String) email
1. (String) passwordHashed
2. (int) role
3. (String) name
4. (String) mobileNumber

## cineplexes

0. (String) name
1. (ArrayList<Cinema>) cinemas  // at least 3 cinemas

## cinemas

0. (String) code  // 3 characterss 
2. (String) cinemaClass
3. (SeatingPlan) seatingPlan
4. (ArrayList<Session>) sessions 

## sessions

0. (Movie) movie
1. (String) sessionDate
2. (String) sessionTime
3. (SeatingPlan) seatsAvailability