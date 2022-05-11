
/**
 * Write a description of class SudentAdvanceTicket here.
 * tickets purchased for students that is inherited from the advanceticket class 
 * Julie Yib 
 */
import java.util.*;
public class StudentAdvanceTicket extends AdvanceTicket
{
    private double price;
    public StudentAdvanceTicket (String name, CalendarDate date, CalendarDate datePurchased){
        super(name, date, datePurchased);
    }
    public double getPrice(){
        price = super.getPrice()/2;
        return price;
    }
    public String toString(){
        return "Student " + super.toString() + " (ID Required)";
    }
}
