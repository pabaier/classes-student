public class Appointment{
    //constructor that initializes appointment objects
    //provided a vald CalendarDate and Employee; 9.4
    private Employee employee;
    private CalendarDate date;
    
    //method that initializes appointment objects
    public Appointment(CalendarDate c, Employee e){
        employee = e;
        date = c;
    }
    //getter method that returns an Employee
    public Employee getEmployee(){
        return employee; 
    }
    
    //getter method that return a CalendarDate
    public CalendarDate getCalendarDate(){
        return date; 
    }
    
    //method that returns string with date of appointment and employee's name
    public String toString(){
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        String emName = employee.getName();
        return year + "/" + month + "/" + day + " " + emName; 
    }
}   
 