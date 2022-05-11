/*
    Super class for all Discount classes

    author: Adam Dzierzko
 */


public abstract class DiscountPolicy {

    abstract double computeDiscount(int quantity, double itemCost);
}
