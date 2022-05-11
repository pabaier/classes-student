/**
 * Methods to find the minimum, maximum, mean and variance values in an 
 * array of doubles. Each method is called in the main method to find those
 * values in a specific array.
 *
 * Sydney Jackson

 */
public class Lab4
{  
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double minVal = minimum(data); // change this to a call to minimum method
        double maxVal = maximum(data); // change this to a call to maximum method
        double meanVal = average(data); // change this to a call to average method
        double varVal = variance(data,meanVal); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              minVal, maxVal, meanVal, varVal); 
    }

    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double min = x[0];
        for (int i = 0; i < 10; ++i){
            if (x[i] < min){
                min = x[i];
            }
        }
        return min;
        
    }
    
    //Finds and returns the maximum value in an array of doubles
    public static double maximum (double [] x){
        double max = x[0];
        for (int j = 0; j < 10; ++j){
            if (x[j] > max){
                max = x[j];
            }
        }
        return max;
    }
    
    //Finds and return the mean value in an array of doubles
    public static double average (double [] x){
        double mean = 0.0;
        for (int k = 0; k < 10; ++k){
            mean += x[k];
        }
        mean = mean/10;
        return mean;
    }
    //Finds and returns the variance in an array of doubles
    public static double variance (double [] x, double avg){
        double variance = 0.0;
        double meanVal = average(x);
        for (int r = 0; r < 10; ++r){
            variance += (x[r] - meanVal)*(x[r] - meanVal);
        }
        variance = variance /10;
        return variance;
   
        }
}
