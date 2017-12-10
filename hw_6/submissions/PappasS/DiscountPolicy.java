/*
* Stephen Pappas
*
* This is an abstract class that provides a blueprint for discount policies.
 */
public abstract class DiscountPolicy {
    abstract double computeDiscount(int quantity, double itemCost);
}
