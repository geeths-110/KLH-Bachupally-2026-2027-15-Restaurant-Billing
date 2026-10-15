## Title
Restaurant Order, Kitchen & Billing System

## Objective
To develop a Java program for managing restaurant orders, calculating bills, and displaying kitchen status using methods and recursion.

## Problem
The restaurant needs a system to accept customer orders, calculate the subtotal, discount, tax and total bill, count items, and display the kitchen status.

## Input
Customer name
Menu choice
Quantity
Kitchen status

## Process
Read the customer name.
Display the restaurant menu.
Accept the menu choice and quantity.
Calculate the item subtotal using a method.
Use recursion to count the ordered items.
Calculate the discount using a method.
Calculate the tax using a method.
Calculate the final bill.
Display the kitchen status using a method.
Display the final bill.

## Output
The program displays:
Customer name
Total number of items
Kitchen status
Subtotal
Discount
Tax
Total bill

## Algorithm
Start.
Read customer name.
Initialize subtotal = 0 and itemCount = 0.
Display the menu using a do-while loop.
Read the user's choice.
If choice is 4, finish the order.
If the choice is invalid, continue to the next iteration.
Read the quantity.
Select the price using switch.
Call calculateSubtotal() and add the result to subtotal.
Call countItems() to count the items recursively.
Call calculateDiscount() to calculate discount.
Call calculateTax() to calculate tax.
Calculate the total bill.
Read the kitchen status.
Call displayKitchenStatus().
Display the bill.
Stop.

## Concepts Used
Static methods
Method parameters
Return values
void methods
Method decomposition
if-else-if
switch
do-while
break
continue
Recursion
Base case
Recursive case