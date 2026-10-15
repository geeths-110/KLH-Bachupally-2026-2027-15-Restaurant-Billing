Trace Table
Sample Input
Customer Name: Geethika
Choice: 1
Quantity: 2
Choice: 2
Quantity: 2
Choice: 4
Kitchen Status: 2
Dry Run
Step Action Variable Values
1 Read customer name name = "Geethika"
2 Initialize values subtotal = 0, itemCount = 0
3 Select Biryani choice = 1
4 Enter quantity quantity = 2
5 Get price price = 200
6 Add item cost subtotal = 0 + (200 × 2) = 400
7 Update item count itemCount = 2
8 Select Pizza choice = 2
9 Enter quantity quantity = 2
10 Get price price = 250
11 Add item cost subtotal = 400 + (250 × 2) = 900
12 Update item count itemCount = 4
13 Select Finish Order choice = 4
14 Exit loop break
15 Check discount 900 >= 500 → True
16 Calculate discount discount = 900 × 0.05 = 45
17 Calculate tax tax = (900 - 45) × 0.05 = 42.75
18 Calculate total total = 900 - 45 + 42.75 = 897.75
19 Read kitchen status status = 2
20 Execute switch Preparing
Final Values
name      = "Geethika"
subtotal  = 900.0
itemCount = 4
discount  = 45.0
tax       = 42.75
total     = 897.75
status    = 2