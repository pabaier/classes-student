import java.text.NumberFormat;
/**
 * In class lab 6 starter code, CSCI 221, Fall 2017
 * 
 * Name: Carter Haley
 * Each BankAccount object represents one user's account
 */
public class BankAccount
{
    // instance variable 
    private double balance;
    private double transactionFee = .5;

    /**
     * Constructor for objects of class BankAccount
     */
    public BankAccount()
    {
        // initialise instance variables
        balance = 0.0;
    }

    /*
     * Add money to an account
     */
    public void deposit (double amount){
        
       balance = balance + amount;
       
    }
    
    /* 
     * Remove money from an account
     */
    public void withdraw (double amount){
       if((balance >= (amount+transactionFee))){ 
           balance = balance - (amount+transactionFee);
        }
       
    }
    
  

    /*
     * Convert a double that represents money to
     * a String.
     * Precondition: it is expected that the quanitity 
     *   is non-negative.
     */
    public String makeDollarsAndCents() {
        
        // Return a balance in $ and cents format
        return NumberFormat.getCurrencyInstance().format(balance);
       
        
    }
    
    public void transfer(BankAccount destAcc, double amt){
        transactionFee = 5;
        double amtCheck = this.balance - 5;
        if (this.balance >= (transactionFee + amt)){
            this.balance -= (transactionFee + amt);
            destAcc.deposit(amt);
        }
        else if (amtCheck < amt && amtCheck > 0){
            destAcc.deposit(amtCheck);
            this.balance = 0;
         
        }
    
    }

    public String toString(){
        return NumberFormat.getCurrencyInstance().format(balance);
    }
  
}
