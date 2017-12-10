
/**
 * interface Incrementable - An interface for classes that can increment values in various ways
 *
 * @author Richard Marshall
 * @version 11/17/17
 */
public interface Incrementable
{
    
    /** 
     * increment - the method signiture for the increment methods 
     */
    void increment();
    
    /**
     * getValue - a method signiture for a getter method.
     * 
     * @return    the value stored by the class which implements this interface
     */
    int getValue();
}
