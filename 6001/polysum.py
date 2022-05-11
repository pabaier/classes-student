import math

def polysum(n, s):
    
    area = (0.25 * n * s * s) / (math.tan(math.pi / n))
    perim = n * s
    
    return round(area + (perim * perim), 4)
