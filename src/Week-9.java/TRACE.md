# Week 9 — Trace Table
## Sample Input
Customer name: Vaishnavi
| Food Item | Price | Quantity | Subtotal |
|---|---:|---:|---:|
| Biryani | Rs. 200 | 2 | Rs. 400 |
| Pizza | Rs. 250 | 1 | Rs. 250 |
Kitchen status: 2
## Step-by-Step Execution
| Step | Operation | Result |
|---|---|---|
| 1 | Read customer name | Vaishnavi |
| 2 | Sort menu alphabetically | Burger, Biryani, Pizza |
| 3 | Select Biryani | Quantity = 2 |
| 4 | Calculate Biryani subtotal | Rs. 400 |
| 5 | Select Pizza | Quantity = 1 |
| 6 | Calculate Pizza subtotal | Rs. 250 |
| 7 | Calculate total subtotal | Rs. 650 |
| 8 | Calculate discount | Rs. 32.50 |
| 9 | Calculate tax | Rs. 30.88 |
| 10 | Calculate final bill | Rs. 648.38 |
| 11 | Format receipt | Customer name in uppercase |
| 12 | Display kitchen status | Preparing |
## Search Test
Input: pizza
Output: Item Found: Pizza - Rs. 250.0
The search works regardless of letter case because compareToIgnoreCase() is used.
## Conclusion
The program uses Java String methods and library algorithms to sort, search, and display restaurant order information.