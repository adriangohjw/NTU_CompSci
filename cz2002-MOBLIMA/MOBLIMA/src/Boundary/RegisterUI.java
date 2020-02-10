package Boundary;

import Controller.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class RegisterUI {

	/** 
     * Necessary variables to store info - email, password, password check, role
     */
    private String email;
    private String password;
    private String password2;
    private int role;
    private boolean consistentPassword = false;
    
    /** 
     * All controllers (movie goer, admin)
     */
    private MovieGoersController movieGoersCtrl;
    private AdminsController adminsCtrl;

    /** 
     * Default constructor to make controllers
     */
    RegisterUI() {
        this.movieGoersCtrl = new MovieGoersController();
        this.adminsCtrl = new AdminsController();
    }

    /** 
     * Default constructor to make controllers with specific states
     * @param movieGoersCtrl 	State of movie goer controller
     * @param adminsCtrl 		State of admin controller
     */
    RegisterUI(MovieGoersController movieGoersCtrl, AdminsController adminsCtrl){
        this.movieGoersCtrl = movieGoersCtrl;
        this.adminsCtrl = adminsCtrl;
    }

    /** 
     * Main method to display
     */
    public void main(){
        do {
            inputRegister();
            if(consistentPassword){
                adminsCtrl.create(email, password);
                System.out.println("You have registered successfully");
            }
            else {
                System.out.println("Password not consistent. Enter again");
            }
        }
        while(!consistentPassword);
    }

    /** 
     * Ask user to input their user name and password and ask user to verify said password
     */
    public void inputRegister(){
        System.out.println("Please enter your email: ");
        email = InputController.getEmailFromUser();
        System.out.println("Password: ");
        password = InputController.getStringFromUser();
        System.out.println("Password again to verify: ");
        password2 = InputController.getStringFromUser();
        consistentPassword = password.equals(password2);
    }
}
