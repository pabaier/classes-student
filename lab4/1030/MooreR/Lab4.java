
/**
 * Write a description of class Lab4 here.
 *
 * Riley Moore

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = 0.0; // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        int i = 0;
        int j = 0;
        double smallest = 0.0;
        for(i=0; i<x.length; i++){
            for(j=1; j<x.length; j++){
                if(x[i] < x[j]){
                    smallest = x[i];
                }
                else{
                    smallest = x[j];
                }
            }
                
            }
        
        return smallest;
    }
    
    public static double maximum (double [] x){
        int i =0;
        int j = 0;
        double largest = 0.0;
        largest = x[0];
        for(i=0; i<x.length; i++){
            for(j=1; j<x.length; j++){
                if(largest > x[j]){
                    largest = largest;
                }
                else{
                    largest = x[j];
                }
            }    
        }     

    return largest;
}
        public static double average(double [] x){
            int i = 0;
            double sum = 0.0;
            double avg = 0.0;
            for(i=0; i<x.length; i++){
                sum = sum + x[i];
            }
            avg = sum/ x.length;
            return avg;
}
}