import java.util.*;
import java.lang.*;

public class Ticket {

    protected static String name;
    protected CalendarDate d;
    protected double price = 0.0;

    public Ticket(String name, CalendarDate d){
        this.name = name;
        this.d = d;
    }
    public String getNameOfEvent(){
        return this.name;
    }
    public CalendarDate getDateOfEvent(){
        return this.d;
    }
    public double getPrice(){
        return this.price;
    }
    public String toString(){
        return "Event: " + this.name + ", Date of Event: " + this.d;
    }

}
