
/**
 * a program to compute the min, max, mean, and variance of an array
 *
 * Matthew Hancock

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data);
        double max = maximum(data);
        double mean = meanMethod(data); 
        double var = varMethod(data,mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum(double [] x){
        double minVal=x[0];
        for(int i = 0; i < x.length; ++i){
            if(x[i]< minVal){
                minVal = x[i];
            }
        }
        return minVal;
        
    }
    public static double maximum(double [] x){
        double maxVal=x[0];
        for(int i = 0; i < x.length; ++i){
            if(x[i]> maxVal){
                maxVal = x[i];
            }
        }
        return maxVal;
        
    }
    public static double meanMethod(double [] x){
        double sum = 0.0;
        for(int i = 0; i < x.length; ++i){
            sum += x[i];
        }
        double mean = sum / x.length;
        return mean;
        
    }
    public static double varMethod(double [] x, double avg){
        double sum = 0.0;
        for(int i=0; i < x.length; ++i){
             sum += Math.pow((x[i]-avg), 2);
        }
        double variance = (1.0/x.length)*sum;
        return variance;
        
    }
    
    // Add other methods here.
   
}
