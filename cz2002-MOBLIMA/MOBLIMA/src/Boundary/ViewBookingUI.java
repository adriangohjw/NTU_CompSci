package Boundary;

import Controller.*;
import Model.*;

import java.util.*;

public class ViewBookingUI {
	/** 
     * Variable to store user's email and transaction controller
     */
    private String email;
    private TransactionsController transCtrl;
    
    /** 
     * Default constructor
     */
    public ViewBookingUI() {
        this.transCtrl = new TransactionsController();
    }

    /** 
     * Constructor with controller's state
     * @param transCtrl		State of transaction controller
     */
    public ViewBookingUI(TransactionsController transCtrl) {
        this.transCtrl = transCtrl;
    }
    
    /** 
     * Set controller's state
     * @param transCtrl		State of transaction controller
     */
    public void setTransCtrl(TransactionsController transCtrl) {
        this.transCtrl = transCtrl;
    }
    
    /** 
     * Main method for the UI
     */
    public void main(){
        System.out.print("Enter your email: ");
        email = InputController.getEmailFromUser();
        System.out.println("\nHere is booking history of " + email + ":\n");
        display();
    }

    /** 
     * Display all transactions made with an user's email
     */
    public void display(){
        int input;
        ArrayList<Transaction> transactionList = transCtrl.readByMovieGoerUsername(email);
        if(transactionList.isEmpty()){
            System.out.println("Your booking history is empty. Book a ticket now!");
        }
        else{
            transactionList.forEach(transaction -> System.out.println(transaction.toString()));
        }
        do{
            System.out.print("Insert 1 to exit: ");
        }while((input = InputController.getIntFromUser())!=1);
    }
}
