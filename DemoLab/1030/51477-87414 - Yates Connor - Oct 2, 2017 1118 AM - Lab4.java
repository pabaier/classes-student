
/**
 * Write a description of class Lab4 here.
 *
 * Your name Connor Yates

 */
 import java.lang.*

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        Lab4.maximum(data); // change this to a call to minimum method
        double max = 0.0; // change this to a call to maximum method
        double mean = 0.0; // change this to a call to average method
        double var = 0.0; // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
		double smallest = x[0];
		int i = 0;
		for (i < x.length; i++) {
			if (x[i] < smallest) {
				smallest = x[i];
			}
		}
          
        return smallest;
        
    }
    
    // Add other methods here.

    public static double maximum (double [] x){
		double largest = x[0];
		int i = 0;
		for (i < x.length; i++) {
			if (x[i] > largest) {
				largest = x[i];
			}
		}
          
        return largest;
	}

	public static double average (double [] x) {
		double sum = 0.0
		int i = 0
		for (i < x.length; i++) {
			double sum += x[i];
		}
		average = sum / (double)x.length;
		return average;

	}

	public static double variance (double [] x, double avg) {
		int N = x.length;
		int i = 0;
		double sum = 0.0;
		for (i < N; i++) {
			sum = x[i] - avg;
			sum = Math.pow(sum, 2);
		}
		double variance = sum / N;

		return variance;
	}


   
}
