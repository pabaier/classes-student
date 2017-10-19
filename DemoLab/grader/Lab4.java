
/**
 * Takes in an array and calculates min max avg and var and spits it back out
 *
 * Gabe Jurecki

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data);
        // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        int i;
        double min = 0.0;
        
        for(i = 0; i < x.length; i++){
            if(min > x[i]){
                min = x[i];
            }
        }
        return min;
        
    }
    
    public static double maximum (double [] x){
        int i;
        double max = 0.0;
        
        for(i = 0; i < x.length; i++){
           if(max < x[i]){
               max = x[i];
           };
        }
        return max;
    }
    
    public static double average (double [] x ){
        int i;
        double avg = 0.0;
        double sum = 0.0;
        
        for(i = 0; i < x.length; i++){
            sum = sum + x[i];
            
        }
        avg = sum / x.length;
    return avg;
    }
    public static double variance (double [] x, double avg){
        int i;
        double sum = 0.0 ;
        double var = 0.0;
        double length = x.length;
        
        for(i = 0; i < x.length; i++){
            sum = sum + (x[i] - avg) * (x[i] - avg) ;
        
        }
        var = sum* (1 / length);
        
        return var;
    }// Add other methods here.
   
}
//Lab4Jurecki