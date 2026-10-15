# Week 11 — Trace Table
## Sample Input
Customer: Vaishnavi
| Food Item | Price | Quantity | Subtotal |
|---|---:|---:|---:|
| Biryani | Rs. 200 | 2 | Rs. 400 |
| Pizza | Rs. 250 | 1 | Rs. 250 |
Kitchen status: 2 (Preparing)
## Step-by-Step Execution
| Step | Operation | Result |
|---|---|---|
| 1 | Store menu in ArrayList | 3 menu items |
| 2 | Store prices in HashMap | Food names mapped to prices |
| 3 | Store prices in TreeMap | Alphabetically sorted price list |
| 4 | Store names in TreeSet | Burger, Biryani, Pizza |
| 5 | Add Biryani to order | Quantity = 2 |
| 6 | Add Biryani to kitchen queue | Queue: [Biryani] |
| 7 | Add Pizza to order | Quantity = 1 |
| 8 | Add Pizza to kitchen queue | Queue: [Biryani, Pizza] |
| 9 | Calculate subtotal | Rs. 650.00 |
| 10 | Calculate discount | Rs. 32.50 |
| 11 | Calculate tax | Rs. 30.88 |
| 12 | Calculate total | Rs. 648.38 |
| 13 | Save and read report | OrderReport.txt |
## Collection Results
- Unique menu items: [Biryani, Burger, Pizza]
- Sorted price list: Burger, Biryani, Pizza
- Kitchen queue: [Biryani, Pizza]
- Most recently added item: Pizza
## Conclusion
The program uses Java Collections to organize menu items, maintain prices, track kitchen orders, and generate a restaurant billing report.