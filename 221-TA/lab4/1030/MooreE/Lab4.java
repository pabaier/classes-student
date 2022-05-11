public class Lab4 {
	/**
	 * The code below is supposed calculate the minimum, maximum, mean, and variance
	 * for the array in the main method.
	 *
	 * Elex Moore

	 */    
	    public static void main(String [] args){
	        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
	        double min = minimum(data);
	        double max = maximum(data);
	        double mean = average(data);
	        double var = variance(data, mean);
	        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
	              min, max, mean, var); 
	    }
	    
	    // Finds and returns the minimum value in
	    // an array of doubles
	    public static double minimum (double [] x){
	    	int i = 0;
	    	double min = x[0];
	    	for( i = 0; i< x.length; i++){
	    		if(x[i] < min){
	    			min = x[i];
	    		}
	    	}
	          
	        return min;
	        
	    }
	    
	   public static double maximum (double [] x){
		   int i = 0;
		   double max = x[0];
		   for( i = 0; i < x.length; i++){
			   if(max < x[i]){
				   max = x[i];
			   }
		   }
		   return max;
	   }
	   
	   public static double average (double [] x){
		   int i = 0;
		   double avg = 0.0;
		   double tot = 0;
		   for( i = 0; i < x.length; i++){
			   tot += x[i];
		   }
		   avg = tot/ x.length;
		   return avg;
	   }
	   
	   public static double variance (double [] x, double avg){
		   int i = 0;
		  double total = 0.0;
		  double N = x.length;
		   for(i = 0; i < x.length; i++){
			   total += (x[i] - avg)* (x[i] - avg);
		   }
		   avg = (1/N)*(total);
		   
		   
		   return(avg);
	   }

}
