
public class Lab4 {
/**
		 * Calling the data from the methods
		 *
		 * Angelica Rodriguez

		*/
	public static void main(String[] args) {
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
		    	int i =0;
		    	double min=x[0];
		    	for(i=1; i < x.length; i++){
		    		if(x[i]<min){
		    		min=x[i];	
		    		}
		    		
		    	}
		        return min;
		        
		    }
		    
		   public static double maximum (double [] x){
			   int i=0;
			   double max=x[0];
			   for(i=1; i<x.length; ++i){
				  if(x[i]<max){
					max=x[0];  
				  }
			   }
			   
			   return max;
			   
		   }
		   public static double average (double [] x){
			   int i=0;
			   double avg=x[0];
			   double total= 0.0;
			   for(i=1; i<x.length; ++i){
				   if(x[i]<avg)
				   avg= total + x[0];
			   }
			   
			   return avg;
			   
		   }
		   public static double variance (double [] x, double avg){
			   int i=0;
			   double variance=x[0];
			   for(i=0; i<x.length; i++){
				   if(x[i]<variance){
					variance=1.0/x.length*(x[i])-avg;   
				   }
			   }
			   
			   return variance;
		   }
		   
		

	}


