# Week 7 — Trace Table
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
| 1 | Create Order object | Customer: Vaishnavi |
| 2 | Create Biryani object | Rs. 200 × 2 = Rs. 400 |
| 3 | Add Biryani to order | 1 food entry |
| 4 | Create Pizza object | Rs. 250 × 1 = Rs. 250 |
| 5 | Add Pizza to order | 2 food entries |
| 6 | Calculate subtotal | Rs. 650 |
| 7 | Calculate discount | Rs. 650 × 5% = Rs. 32.50 |
| 8 | Calculate taxable amount | Rs. 650 − Rs. 32.50 = Rs. 617.50 |
| 9 | Calculate tax | Rs. 617.50 × 5% = Rs. 30.875 |
| 10 | Calculate total | Rs. 617.50 + Rs. 30.875 = Rs. 648.375 |
| 11 | Count quantities | 2 + 1 = 3 items |
| 12 | Display kitchen status | Preparing |
## Final Values
- Subtotal: Rs. 650.00
- Discount: Rs. 32.50
- Tax: Rs. 30.88
- Total bill: Rs. 648.38
- Total items: 3
- Total orders created: 1
## Conclusion
The program uses objects to manage food items and customer orders while calculating the bill and displaying kitchen status.