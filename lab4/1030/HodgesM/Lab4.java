
/**
 * Methods Practice
 *
 * Mark Hodges

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = mean(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        int arrayL = 10;
        int i;
        double smallVal = x[0];
        for (i = 0; i < arrayL; i++){
            double otherVal = x[i];
            if (otherVal < smallVal){
                smallVal = otherVal;
            }   
        }    
        return smallVal;
        
    }
    
    // Add other methods here.
    public static double maximum (double [] x){
        int arrayL = 10;
        int i;
        double bigVal = x[0];
        for (i = 0; i < arrayL; i++){
            double otherVal = x[i];
            if (otherVal < bigVal){
                bigVal = otherVal;
            }   
        }    
        return bigVal;
        
    }
    
    public static double mean (double [] x){
        int arrayL = 10;
        int i;
        double sum = 0.0;
        for (i = 0; i < arrayL; i++){
            sum = sum + x[i];
        }    
        double average = sum / arrayL;
        return average;
        
    }
    
    public static double variance (double [] x, double avg){
        int arrayL = 10;
        int i;
        double sum = 0.0;
        for (i = 0; i < arrayL; i++){
            double otherVal = (x[i] - avg) * (x[i] - avg);
            sum = sum + otherVal;
        }    
        sum = sum / arrayL;
        return sum;
        
    }
               
}
