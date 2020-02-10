# Model (class) explained

## Movie

~~~java
// Attributes
private int id;  // automatically genetated
private String title;
private MovieType type;
private String synopsis;
private String rating;
private double duration;
private String movieReleaseDate;
private String movieEndDate;
private String director;
private ArrayList<String> cast;
private ArrayList<Review> reviews;

// Constructor
public Movie(
  int id,
  String title, 
  MovieType type, 
  String synopsis, 
  String rating, 
  double duration,
  String movieReleaseDate, 
  String movieEndDate,
  String director, 
  ArrayList<String> cast
){...};
~~~

## Review

~~~java
// Attribute
private String username;
private double numOfStars;
private String additionalComment;

// Constructor
public Review(
  String username, 
  double numOfStars, 
  String additionalComment
){...};
~~~


## Transaction

~~~java
// Attributes
private String TID; 
private Movie_Goer movieGoer; 

// Constructor
public Transaction(
  String cinemaCode, 
  Movie_Goer movieGoer
){...};
~~~

## User

~~~java
// Attributes
private String email;  // username 
private String passwordHashed;
private int role; 

// Constructor
public User (
  String email, 
  String password, 
  int role
){...};

// password validation and encryption
public boolean validatePassword(String passwordToCompare){...};
public String PasswordSHA256(String passwordToHash, String salt){...}
public void updatePassword(String currentPassword, String newPassword){...}
~~~

<b>Movie_Goer</b>
- subclass of Users
- During instantiation, `role` = 1
~~~java
// Attribute
private String name;
private String mobileNumber;
~~~

<b>Admin</b>
- subclass of Users
- During instantiation, `role` = 2 

## Seat

~~~java
// Attributes
private int seatID;
private boolean occupied;

// Constructor
public Seat(
  int id
) {...};

public Seat(
  int id, 
  boolean state
) {...}

// methods
public void assign() {...};
public void unassign() {...};
~~~

## SeatingPlan

~~~java
// Attributes
private Seat [][] layout;
private int row;
private int column;

// Constructor
public SeatingPlan(
  int row, 
  int column
) {...};

// methods
public void printLayout(){...}; 
public int getNumSeats(){...};
public void assignSeats(int id){...};
public void unassignSeats(int id){...};
~~~

## Cineplex

~~~java
// Attribute
private String name;
private ArrayList<Cinema> cinemas;

// Constructor
public Cineplex(
  String name, 
  ArrayList<Cinema> cinemas
){...};
~~~

## Cinema

~~~java
// Attributes
private String code;
private CinemaType cinemaClass;
protected SeatingPlan seatingPlan;
private ArrayList<Session> sessions;

// Constructor
public Cinema (
  String code, 
  String cinemaClass, 
  SeatingPlan seatingPlan
){...};
~~~

## Session

~~~java
// Attributes
private Movie movie;
private String sessionDateTime;
private SeatingPlan seatsAvailability;
private int id;

// Constructor
public Session(
  Movie movie, 
  String sessionDateTime,
  SeatingPlan seatingPlan
  int id
){...}

// methods
public boolean isWeekend(){...};
private String getDayOfWeekString(){...};
private LocalTime getTime(){...}
public LocalTime getStartTime(){...}
public LocalTime getEndTime(){...}
~~~

## Holiday

~~~java
// Attributes
private String holidayDate;

// Constructor
public Holiday(String holidayDate);
~~~