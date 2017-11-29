public abstract class TemplateMethod {
    public final String RESET = "\u001B[0m";
    public final String CORRECT = "\u001B[32m";
    public final String PARTCORRECT = "\u001B[34m";
    public final String INCORRECT = "\u001B[31m";
    public final String TESTHEAD = "\u001B[35m";
    public final String TESTEXPECT = "\u001B[36m";

    // public final String RESET = "";
    // public final String CORRECT = "";
    // public final String PARTCORRECT = "";
    // public final String INCORRECT = "";
    // public final String TESTHEAD = "";
    // public final String TESTEXPECT = "";

    public int runTest(String testName) {
        System.out.println(TESTHEAD + "\t" + testName + RESET);
        int points = 0;

        int[] result  = testMethod();
        
        if(result[0] == 404){
            System.out.println(INCORRECT + "\t\tError running test - " + 0 + "/" + result[1] + RESET);
            return 0;
        }
        else if(result[0] > 100) {
            result[0] -= 100;
            System.out.println(CORRECT + " - Correct - " + result[0] + "/" + result[1] + RESET);
        }
        else if(result[0] > 0) {
            System.out.println(PARTCORRECT + " - Partially Correct - " + result[0] + "/" + result[1] + RESET);
        }
        
        points += result[0];

        return points;
    }

    public abstract int[] testMethod();
    
    public static class ToStringTest extends TemplateMethod {
        public int[] testMethod() {
            // {score, out of}
            // correct answer generates 100 + max score
            int[] result = {0,7};

            AppointmentKey key = new AppointmentKey(new CalendarDate(1762, 9, 12),  new Employee("Yekaterina Alekseyevna"));
            try {
                Appointment student = new Appointment(key.getDate(), key.getEmployee());
                String studentAnswer = student.toString().toUpperCase();
                System.out.print("\t\t" + key + " | " + student);
                if(studentAnswer.contains(key.getDate().toString().toUpperCase()) &&
                studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    result[0] = 105;
                }
                else if(studentAnswer.contains(key.getDate().toString().toUpperCase())) {
                    result[0] = 3;
                }
                else if(studentAnswer.contains(key.getEmployee().getName().toUpperCase())) {
                    result[0] = 3;
                }
            }
            catch(Exception e) {
                result[0] = 404;
            }

            return result;
        }
    }

}