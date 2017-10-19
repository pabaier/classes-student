
/**
 * The purpose of this program is to use methods to calculate the minimum,
 * maximum, average, and variance given a data set. 
 * 
 *
 * Connor Matthews

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
        int i = 0;
        double smallest = x[i];
        for(i = 0; i < x.length; i ++){
            
            //double smallest = x[i];
            if(x[i] < smallest){
                smallest = x[i];
                
        //return 0.0;
      }
    }
    return smallest;
  }
  public static double maximum (double []x){
      int i =0;
      double biggest = x[i];     
      for(i = 0; i < x.length; i ++){
          //double biggest = x[i];
          if(i> biggest){
              biggest = x[i];
              
            }
   }
   return biggest;
  }
  public static double average(double []x){
    int i = 0;
    double total = 0.0;
      for(i = 0; i < x.length; i++){
        total = total + x[i];  
    } 
    double avg = 0.0;
    avg = total/x.length;
    return avg;
  } 
  public static double variance(double[] x, double avg){
    int i = 0;
    double var = 0.0;
    for(i =0; i < x.length; i++){
     var = Math.pow((x[i]- avg),2);
     var = var + x[i];
    }
    var = var/x.length;
    
    return var;  
    }
  }
