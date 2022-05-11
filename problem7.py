def general_poly(L):
    """ L, a list of numbers (n0, n1, n2, ... nk)
    Returns a function, which when applied to a value x, returns the value 
    n0 * x^k + n1 * x^(k-1) + ... nk * x^0 """
    
    def myFunction(val):
        l = len(L)-1
        total = 0
        for i in L:
            total += i * val ** (l)
            l -= 1
        return total
        
    return myFunction


print(general_poly([1, 2, 3, 4, 5])(10))