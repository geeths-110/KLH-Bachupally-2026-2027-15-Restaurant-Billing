## Title
Restaurant Order, Kitchen & Billing System

## Objective
To develop a Java program that accepts customer and order details, calculates the subtotal, tax, and total bill using appropriate data types, and displays the order and bill details.

## Problem
A restaurant needs a simple system to store customer orders and calculate the final bill by adding a 5% tax to the order subtotal.

## Input

Customer name
Food item
Quantity
Price per item

## Process
Read customer and order details using Scanner.
Store the customer name and food item as String.
Store quantity as int.
Store price as double.
Calculate the subtotal.
Calculate 5% tax.
Add the tax to the subtotal to get the total bill.
Display the order and kitchen status.
Display the subtotal, tax, and total using formatted output.

## Output
Customer name
Food item
Quantity
Price per item
Kitchen order status
Subtotal
5% tax
Total bill

## Algorithm
1.Start.
2.Create a Scanner object.
3.Declare the currency constant.
4.Read customer name.
5.Read food item.
6.Read quantity.
7.Read price per item.
8.Calculate subtotal = quantity × price.
9.Calculate tax = subtotal × 0.05.
10.Calculate total = subtotal + tax.
11.Display order details.
12.Display kitchen status.
13.Display subtotal, tax, and total bill using printf.
14.Close the Scanner.
15.Stop.

## Concepts Used
Variables
String
int
double
Constants using final
Literals
Arithmetic operators
Expressions
Scanner
nextLine()
nextInt()
nextDouble()
Formatted output using printf
Floating-point calculations