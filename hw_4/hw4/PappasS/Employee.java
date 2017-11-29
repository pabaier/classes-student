
/**
 * Models an Employee.
 *  -- simple version --
 */
public class Employee{

   private static int empCount = 0;
   // instance variables
   private String name;
   //private int salary;

   public Employee(String name){
  	this.name = name;
	//salary = sal;
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
    public String toString() {return name;}
   
  /* public void displayEmployee( ){
     System.out.printf("Name: %s, Salary: %.2f", name, salary);
    }*/

   // return String representation of an Employee
   /*public String toString(){
       return "Name: " + name + ", Salary: " + salary;
   }*/
  
} // end Employee
