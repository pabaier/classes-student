# -*- coding: utf-8 -*-

def calculateBalance(b, r, p):
    balance = b
    annualInterestRate = r
    
    monthlyInterestRate = annualInterestRate / 12
    
    for m in range(12):
        balance -= p
        balance = balance + monthlyInterestRate * balance
        
    return balance

balance = 999999
annualInterestRate = 0.18
minBalance = balance
lower = balance/12
upper = (balance * (1 + annualInterestRate/12)**12)/12

while(True):
    payment = (lower + upper)/2
    minBalance = calculateBalance(balance, annualInterestRate, payment)
    if(minBalance < -0.01): #if i paid too much
        upper = payment
    elif(minBalance > 0.01): #if i paid too little
        lower = payment
    else:
        break
print("Lowest Payment: " + str(round(payment,2)))
