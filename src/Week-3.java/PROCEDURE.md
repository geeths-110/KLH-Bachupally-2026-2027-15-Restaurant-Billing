## Title
Restaurant Order, Kitchen & Billing System

## Objective
To develop a Java program that manages a restaurant order, applies a discount based on the subtotal, calculates tax and the final bill, and displays the kitchen order status.

## Problem
A restaurant needs a billing system that can calculate discounts based on the order amount and display the current kitchen status.

## Input
Customer name
Food item
Quantity
Price per item
Kitchen status

## Process
Read customer and order details using Scanner.
Calculate the subtotal using quantity and price.
Check the subtotal and apply the appropriate discount.
Calculate 5% tax after the discount.
Calculate the final bill.
Use switch to display the kitchen status.
Display the order and bill details.
Output
Customer name
Food item
Quantity
Price per item
Kitchen status
Subtotal
Discount
Tax
Total bill

## Algorithm
1.Start.
2.Create a Scanner object.
3.Read customer name.
4.Read food item.
5.Read quantity.
6.Read price per item.
7.Check whether the quantity and price are valid.
8.Calculate subtotal = quantity × price.
9.If subtotal is ₹1000 or more, apply 10% discount.
10.Else if subtotal is ₹500 or more, apply 5% discount.
11.Otherwise, apply no discount.
12.Calculate tax on the discounted amount.
13.Calculate the final bill.
14.Read the kitchen status.
15.Use switch to display the kitchen status.
16.Display the bill details.
17.Close the Scanner.
18.Stop.

## Concepts Used
if
if-else if-else ladder
switch
case
break
default
&& / ||
Relational operators
Arithmetic operators
Variables
Constants
Scanner
printf