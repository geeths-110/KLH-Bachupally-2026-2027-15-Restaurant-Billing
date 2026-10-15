# Week 8 — Trace Table
## Sample Input
Customer: Vaishnavi
| Food Item | Price | Quantity | Subtotal |
|---|---:|---:|---:|
| Biryani | Rs. 200 | 2 | Rs. 400 |
| Pizza | Rs. 250 | 1 | Rs. 250 |
Kitchen status: 2
## Step-by-Step Execution
| Step | Operation | Result |
|---|---|---|
| 1 | Create Order object | Customer: Vaishnavi |
| 2 | Create Biryani object | Rs. 400 |
| 3 | Validate quantity | Valid |
| 4 | Create Pizza object | Rs. 250 |
| 5 | Calculate subtotal | Rs. 650 |
| 6 | Apply discount lambda | Rs. 32.50 |
| 7 | Calculate taxable amount | Rs. 617.50 |
| 8 | Calculate 5% tax | Rs. 30.88 |
| 9 | Calculate total bill | Rs. 648.38 |
| 10 | Display kitchen status | Preparing |
## Exception Test
If the entered quantity is 0 or a negative number:
1. InvalidQuantityException is thrown.
2. The catch block displays an error message.
3. The finally block displays "Quantity check completed."
4. The invalid food item is not added to the order.
## Conclusion
The program uses inheritance, abstraction, interfaces, lambda expressions, and exception handling to manage restaurant orders and billing.