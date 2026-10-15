Trace – Restaurant Order, Kitchen & Billing System
Sample Input
Customer Name = Geethika
Choice = 1
Quantity = 2
Choice = 2
Quantity = 2
Choice = 4
Kitchen Status = 2
Main Loop Trace
Iteration Choice Quantity Price Subtotal Item Count
1 1 2 ₹200 ₹400 2
2 2 2 ₹250 ₹900 4
3 4 - - ₹900 4

When choice = 4, the break statement ends the loop.

Method Trace
calculateSubtotal()

For Biryani:

price = 200
quantity = 2

calculateSubtotal(200, 2)
= 200 × 2
= 400

For Pizza:

price = 250
quantity = 2

calculateSubtotal(250, 2)
= 250 × 2
= 500

Total subtotal:

400 + 500 = 900
countItems(2) Recursion
countItems(2)
= 1 + countItems(1)
= 1 + 1 + countItems(0)
= 1 + 1 + 0
= 2

The same recursion occurs for the second quantity:

countItems(2) = 2

Therefore:

itemCount = 2 + 2
          = 4
calculateDiscount()
subtotal = 900

900 >= 1000 → false
900 >= 500  → true

discount = 900 × 0.05
          = ₹45
calculateTax()
Amount = 900 - 45
      = ₹855

Tax = 855 × 0.05
    = ₹42.75
Final Calculation
Total = Subtotal - Discount + Tax

      = 900 - 45 + 42.75

      = ₹897.75
Final Values
Variable Value
Customer Geethika
Subtotal ₹900.00
Item Count 4
Discount ₹45.00
Tax ₹42.75
Total ₹897.75
Kitchen Status Preparing
Recursion Call Stack

For countItems(2):

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

The base case is quantity == 0.

The recursive case reduces the quantity by 1.