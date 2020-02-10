/*package Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Controller.MoviesController;
import Controller.ReviewsController;
import Model.*;

public class ReviewsControllerTest {
    public static void main(String[] args) throws Exception {

        MoviesController movieCtrl = new MoviesController();
        new File(movieCtrl.FILENAME).delete();
        ReviewsController reviewsController = new ReviewsController(movieCtrl);
        
        // creating test values + testing ReviewsController.create()
        ArrayList<Movie> movieListing = new ArrayList<Movie>();
        String currentDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());

        ArrayList<String> listCast =  new ArrayList<String>();
        listCast.add("A_cast1");
        listCast.add("A_cast2");
        //movieCtrl.create("A", MovieType.BLOCKBUSTER, "A_synopsis", "NC16", currentDate, "2020-01-01", "A_director", listCast);
        Movie movie1 = movieCtrl.readByID(0);

        listCast.clear();
        listCast.add("B_cast1");
        listCast.add("B_cast2");
        //movieCtrl.create("B", MovieType.BLOCKBUSTER, "B_synopsis", "NC16", currentDate, "2020-01-01", "B_director", listCast);
        Movie movie2 = movieCtrl.readByID(1);

        ArrayList<Review> reviewListing = new ArrayList<Review>();
        Review review1 = new Review("adrian1@gmail.com", 3.0, "average");
        Review review2 = new Review("adrian2@gmail.com", 3.0, "average");
        reviewListing.add(review2);

        System.out.println(".....Testing ReviewsController.create() - Before");
        readAllAndPrint(movieCtrl);
        System.out.println(".....Testing ReviewsController.create() - After (1)");
        reviewsController.create(movie1, review1);
        readAllAndPrint(movieCtrl);
        System.out.println(".....Testing ReviewsController.create() - After (2)");
        reviewsController.create(movie2, review1);
        readAllAndPrint(movieCtrl);
    }

    public static void readAllAndPrint(MoviesController movieCtrl){   
        ArrayList<Movie> movieListing = movieCtrl.read();
        ArrayList<Review> reviewListing;
        Movie m;
        for (int i=0; i<movieListing.size(); i++){
            m = movieListing.get(i);
            System.out.println("Movie: " + m.getTitle());
            reviewListing = m.getReviews();
            for (int j=0; j<reviewListing.size(); j++){
                System.out.println(reviewListing.get(j));
            }
        }  
    }
}*/