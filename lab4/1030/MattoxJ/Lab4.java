
/**
 * Method creation to provide min, max, mean, and variance
 *
 * Jacob Mattox

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        
        double check = x[0];
        for(int i = 0; i < x.length; ++i){
            if(x[i] < check)
                check = x[i];
            }
          
        return check;
        
    }
    public static double maximum (double [] x){
        
        double check = x[0];
        for(int i = 0; i < x.length; ++i){
            if(x[i] > check)
                check = x[i];
            }
          
        return check;
        
    }
    public static double average (double [] x){
        double total = 0;
        for(int i = 0; i < x.length; ++i){
            total = total + x[i];
            }
        return total/x.length;
    }
    public static double variance (double [] x, double mean){
        double total = 0;
        double tempVar;
        for(int i = 0; i < x.length; ++i){
            tempVar = Math.pow((x[i] - mean), 2);
            total = total + tempVar;
        }
        total = total * (1.0/x.length);
        return total;
    }
}
    
    // Add other methods here.
