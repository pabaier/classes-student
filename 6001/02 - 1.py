# -*- coding: utf-8 -*-

balance = 42
annualInterestRate = 0.2
monthlyPaymentRate = 0.04

monthlyInterestRate = annualInterestRate / 12

for m in range(12):
    minPayment = balance * monthlyPaymentRate
    balance -= minPayment
    balance = balance + monthlyInterestRate * balance
    
print("Remaining balance: " + str(round(balance,2)))
