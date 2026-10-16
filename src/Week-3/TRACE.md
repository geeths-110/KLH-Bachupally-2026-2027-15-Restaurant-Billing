Trace Table
Sample Input
Customer Name: Geethika
Food Item: Biryani
Quantity: 3
Price per Item: 200
Kitchen Status: 2
Dry Run
Step Action Variable Values
1 Read customer name name = "Geethika"
2 Read food item item = "Biryani"
3 Read quantity quantity = 3
4 Read price price = 200.0
5 Check order details Valid
6 Calculate subtotal subtotal = 3 × 200 = 600.0
7 Check discount 600 >= 1000 → False
8 Check second condition 600 >= 500 → True
9 Calculate discount discount = 600 × 0.05 = 30.0
10 Calculate tax tax = (600 - 30) × 0.05 = 28.5
11 Calculate total total = 600 - 30 + 28.5 = 598.5
12 Read kitchen status status = 2
13 Execute switch case 2
14 Display status Preparing
Final Values
name     = "Geethika"
item     = "Biryani"
quantity = 3
price    = 200.0
subtotal = 600.0
discount = 30.0
tax      = 28.5
total    = 598.5
status   = 2