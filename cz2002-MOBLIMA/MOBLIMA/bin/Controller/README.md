#  Controller

## moviesController

create
~~~java
public void create(String title, String type, String synopsis, String rating, String movieReleaseDate, String director, ArrayList<String> cast);
~~~

read
~~~java
public ArrayList<Movie> read(); 
public Movie readByID(int valueToSearch);
public ArrayList<Movie> readByAttribute(int col, String valueToSearch);
public ArrayList<Movie> readAvailableMovies();
~~~

update
~~~java
public void updateById(int col, int id, Object newValue);
~~~

delete
~~~java
public void deleteById(int id);
~~~

others
~~~java
public int getLastId();
~~~

## reviewsController

constructor
~~~java
public ReviewsController(MoviesController movieCtrl);
~~~

create
~~~java
public void create(Movie movie, String username, double numOfStars, String additionalComment);
~~~

others
~~~java
public MoviesController getMovieCtrl();
~~~

## transactionsController

create
~~~java
public void create (Transaction transaction);
~~~

read
~~~java
public ArrayList<Transaction> read();
public Transaction readByTID(String TID);
public ArrayList<Transaction> readByMovieGoerUsername(String movieGoerUsername);
~~~

update
- `TID` should not need to be updated
- Do not allow for updating of `email` of `Movie_Goer` for now

delete
~~~java
public void delete(String TID, String username);
~~~

## AdminsController

create
~~~java
public void create(String username, String password) 
~~~

read
- no need to retrieve users by password (security bleach)
~~~java
public ArrayList<Admin> read(); 
public Admin readByEmail(String valueToSearch);
~~~

update
- Currently do NOT allow for `email` to be updated as it's a foreign KEY
- DO NOT allow users to change the `role` of an user at the moment
~~~java
public void updatePasswordHashed(String username, String currentPassword, String newPassword);
~~~

delete
- NO NEED to delete by `passwordHashed`, `role`
~~~java
public void deleteByEmail(String email);
~~~

## MovieGoersController

create
~~~java
public void create(String username, String password);
public void create(String username, String password, String name, String mobileNumber);
~~~

read
- no need to retrieve users by password (security bleach)
~~~java
public ArrayList<Movie_Goer> read(); 
public Movie_Goer readByEmail(String valueToSearch);
~~~

update
- Currently do NOT allow for `email` to be updated as it's a foreign KEY
- DO NOT allow users to change the `role` of an user at the moment
~~~java
public void updatePasswordHashed(String username, String currentPassword, String newPassword);
public void updateByAttribute(int col, Object oldValue, Object newValue);
~~~

delete
- NO NEED to delete by `passwordHashed`, `role`, `name`, `mobileNumber`
~~~java
public void deleteByEmail(String email);
~~~

## sessionsController

constructor
~~~java
public SessionsController(CinemasController cinemasCtrl);
~~~

create
~~~java
public void create(String cinemaCode, Movie movie, String sessionDateTime, SeatingPlan seatingPlan);
~~~

read
~~~java
public ArrayList<Session> read(); 
public ArrayList<Session> readByAttributes(int col, Object valueToSearch);
public ArrayList<Session> readByAttributes(String cinemaCode, LocalDate sessionDate);
public Session readBySession(String cinemaCode, String sessionDateTime);
public Session readById(int id);
~~~

update
~~~java
public void updateByAttribute(int col, String cinemaCode, Object oldValue, Object newValue);
public void updateById(int col, int id, Object newValue);
public void updateSeatsAvailability(int id, SeatingPlan newSeatsAvailabiity);
public void updateByMovie(int col, int movieID, Object newValue);
~~~

delete
~~~java
public void delete(String cinemaCode, String sessionDateTime);
public void delete(int id);
public void deleteByMovie(int movieID);
~~~

others
~~~java
public int getLastId();
~~~

## cineplexesControllers

create
~~~java
public void create(String name, ArrayList<Cinema> cinemas);
~~~

read
- no need to implement reading by cinemas as it is not as useful
~~~java
public ArrayList<Cineplex> read(); 
public Cineplex readByName(String name);
~~~

update
~~~java
public void updateByName(String oldName, String newName);
~~~

delete
~~~java
public void deleteByName(String name);
~~~


## cinemasControllers

constructor
~~~java
public CinemasController(CineplexesController cineplexesCtrl);
~~~

create
~~~java
public void create (Cineplex cineplex, Cinema cinema);
~~~

read
~~~java
public ArrayList<Cinema> read();
public ArrayList<Cinema> readByAttribute(int col, Object valueToSearch);
~~~

update
~~~java
public void updateByAttribute(int col, String code, Object newValue);
~~~

delete
~~~java
public void deleteByCode(Cineplex cineplex, String code);
~~~


## HolidaysController

create
~~~java
public void create(String holidayDate);
~~~

read
~~~java
public ArrayList<Holiday> read();
~~~

delete
~~~java
public void delete(String valueToSearch);
~~~

others
~~~java
public boolean isHoliday(String valueToSearch);
~~~