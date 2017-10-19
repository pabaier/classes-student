/**
 * Write a description of class Lab4 here.
 *
 * Michael Dudley

 */
import java.util.*;

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
        int max = 0;
        double smallest = 0.0;
        for(int i=0; i<x.length; i++){
            if(x[i] < max){
                 smallest = x[i];
            }      
        }   
        return smallest;
    }
    
    public static double maximum(double[]x){
       int lowest = 0;
       double maximum = 0.0;
        for(int i=0; i<x.length; i++){
            if(x[i] > lowest){
                maximum = x[i];
        }
       }
        return maximum;
    }
    public static double mean(double [] x){
        double average = 0.0;
        double total = 0.0;
        int count = 0;
        for(int i=0;i<x.length; i++){
            total += x[i];
            count++;
        }
        average = total/count;
        
        return average;
    }
    
    public static double variance(double[]x , double avg){
        double variance = 0.0;
        for(int i =0;i<x.length; i++){   
            //variance += Math.pow((x[i]- avg(i)),2);
        }
        return variance;
    }
     
   
}