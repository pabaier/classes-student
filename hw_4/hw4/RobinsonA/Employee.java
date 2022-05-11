
/**
 * Ariel Robinson
 * Models an Employee.
 *  -- simple version --
 */
public class Employee{

    private static int empCount = 0;
    // instance variables
    private String name;

    public Employee(String name){
        this.name = name;
        empCount++;
    }

    // return name
    public String getName(){
        return name;
    }

    // show how many Employee objects exist
    public static void displayCount( ){
        System.out.println("Total Employee " + 
            empCount); 
    }

    // return String representation of an Employee
    public String toString(){
        return "Name: " + name; 
    }

} // end Employee
