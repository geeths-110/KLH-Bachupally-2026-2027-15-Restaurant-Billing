## Title
Restaurant Order, Kitchen & Billing System

## Objective
To develop a Java program that allows a customer to select multiple food items using a menu loop, calculates the subtotal, discount, tax, and final bill, and displays the kitchen status.

## Problem
A restaurant needs a system that allows customers to order multiple food items, repeat the ordering process until they finish, and automatically calculate the final bill.

## Input
Customer name
Menu choice
Quantity
Kitchen status

## Process
Read the customer name.
Display the restaurant menu.
Accept the customer's menu choice.
Use switch to determine the food item's price.
Accept the quantity.
Add the item cost to the subtotal.
Continue displaying the menu until the customer selects Finish Order.
Calculate the discount based on the subtotal.
Calculate 5% tax after discount.
Calculate the final bill.
Display the kitchen status using switch.
Display the final bill details.

## Output
Customer name
Total number of items
Kitchen status
Subtotal
Discount
Tax
Total bill

## Algorithm
1.Start.
2.Create a Scanner object.
3.Read the customer name.
I4.nitialize subtotal and itemCount to zero.
5.Display the menu.
6.Read the customer's choice.
7.If the choice is 4, exit the loop.
8.If the choice is invalid, use continue.
9.Read the quantity.
10.If the quantity is invalid, use continue.
11.Use switch to determine the price.
12.Add the item cost to subtotal.
13.Add the quantity to itemCount.
14.Repeat the menu using do-while.
15.Apply discount using the if-else if-else ladder.
16.Calculate tax and total bill.
17.Read the kitchen status.
18.Use switch to display the kitchen status.
19.Display the final bill.
20.Close the Scanner.
21.Stop.

## Concepts Used
do-while loop
switch
if-else if-else
break
continue
Accumulation
Counting
Sentinel value
Arithmetic expressions
Scanner
Variables
Constants
Formatted output using printf