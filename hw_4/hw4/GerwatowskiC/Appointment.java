
/**
 * Creates an appointment.
 *
 * Claire Gerwatowski
 * 25 October 2017
 */
public class Appointment
{
   private CalendarDate date;
   private Employee employee;
   public Appointment(CalendarDate apptDate, Employee employeeName) {
       this.date = apptDate;
       this.employee = employeeName;
   }
   
   public CalendarDate getDate() {
       return this.date;
   }
    
   public String getEmployee() {
       return this.employee.getName();
   }
   
   public String toString() {
       return ("" + this.date + " " + this.employee);
   }
}
