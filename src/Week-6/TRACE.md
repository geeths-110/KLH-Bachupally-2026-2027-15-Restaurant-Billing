Trace – Restaurant Order, Kitchen & Billing System
Sample Input
Customer Name = Vaishnavi
Choice = 1
Quantity = 2
Choice = 2
Quantity = 2
Choice = 4
Kitchen Status = 2
Array Initialization
1-D Arrays
menuItems = {"Biryani", "Pizza", "Burger"}

prices = {200, 250, 120}
Index menuItems prices
0 Biryani 200
1 Pizza 250
2 Burger 120
2-D Array
menuDetails = {
    {1, 200},
    {2, 250},
    {3, 120}
}
Row Choice Price
0 1 200
1 2 250
2 3 120
Array Traversal Trace

The menu is displayed using:

for (int i = 0; i < menuItems.length; i++)
i menuItems[i] prices[i]
0 Biryani 200
1 Pizza 250
2 Burger 120

When i = 3, the condition i < menuItems.length becomes false and the loop stops.

Order Loop Trace
Iteration Choice Index Price Quantity Subtotal
1 1 0 ₹200 2 ₹400
2 2 1 ₹250 2 ₹900
3 4 - - - ₹900

For choice 1:

index = choice - 1
      = 1 - 1
      = 0

price = prices[0]
      = ₹200

For choice 2:

index = choice - 1
      = 2 - 1
      = 1

price = prices[1]
      = ₹250
Recursion Trace

For quantity 2:

countItems(2)
    ↓
countItems(1)
    ↓
countItems(0)
    ↓
returns 0
    ↑
returns 1
    ↑
returns 2

First order:

itemCount = 2

Second order:

itemCount = 2 + 2
          = 4
Billing Trace
subtotal = ₹900

discount = 900 × 0.05
         = ₹45

tax = (900 - 45) × 0.05
    = ₹42.75

total = 900 - 45 + 42.75
      = ₹897.75
Final Values
Variable Value
Customer Vaishnavi
Total Items 4
Subtotal ₹900.00
Discount ₹45.00
Tax ₹42.75
Total ₹897.75
Kitchen Status Preparing