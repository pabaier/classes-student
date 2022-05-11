# -*- coding: utf-8 -*-

def calculateBalance(b, r, p):
    balance = b
    annualInterestRate = r
    
    monthlyInterestRate = annualInterestRate / 12
    
    for m in range(12):
        balance -= p
        balance = balance + monthlyInterestRate * balance
        
    return balance

balance = 3926
annualInterestRate = 0.2
minBalance = balance
payment = 0

while(minBalance > 0):
    payment += 0.01
    minBalance = calculateBalance(balance, annualInterestRate, payment)
    
print("Lowest Payment: " + str(payment))
