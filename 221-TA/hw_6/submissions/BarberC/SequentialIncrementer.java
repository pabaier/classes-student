/**
 * Incrementer which starts at zero and increases by 1 each increment call
 * 
 * @author Carson Barber
 */
public class SequentialIncrementer implements Incrementable
{
    private int intVal;
    public SequentialIncrementer()
    {
       intVal = 0;
    }
    public void increment(){
        intVal++;
    }
    public int getValue(){
        return intVal;
    }
}
