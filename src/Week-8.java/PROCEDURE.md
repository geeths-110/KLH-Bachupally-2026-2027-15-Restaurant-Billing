# Week 8 — Inheritance, Abstraction and Exception Handling
## Aim
To implement inheritance, abstraction, interfaces, polymorphism, lambda expressions, and exception handling in the Restaurant Order and Billing System.
## Problem Statement
Develop a restaurant billing program that manages food orders, calculates discounts and taxes, displays kitchen status, and handles invalid quantities.
## Procedure
1. Create a Billable interface containing the subtotal calculation method.
2. Create a DiscountStrategy functional interface for discount calculation.
3. Define an abstract MenuItem class containing food name and price.
4. Create a FoodItem class that extends MenuItem and overrides methods.
5. Create a custom InvalidQuantityException to handle quantities that are zero or negative.
6. Create an Order class to store food items and calculate the subtotal.
7. Use a lambda expression to calculate discounts.
8. Use try-catch-finally to handle invalid quantities.
9. Calculate tax and the final bill.
10. Display order details, kitchen status, and billing information.
## Concepts Used
- Inheritance: FoodItem extends MenuItem
- Abstraction: MenuItem
- Interface: Billable
- Functional interface: DiscountStrategy
- Method overriding: calculateSubtotal() and toString()
- Polymorphism: using the Billable method contract
- Lambda expression: discount calculation
- Custom checked exception: InvalidQuantityException
- Exception handling: try, catch, finally
- Static members and encapsulation
## Result
The restaurant billing system calculates bills, applies discounts, displays kitchen status, and handles invalid quantities using object-oriented Java features.