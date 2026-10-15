# Week 10 — Trace Table
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
| 1 | Read customer name | Vaishnavi |
| 2 | Add Biryani | Rs. 400 |
| 3 | Add Pizza | Rs. 250 |
| 4 | Calculate subtotal | Rs. 650 |
| 5 | Calculate discount | Rs. 32.50 |
| 6 | Calculate tax | Rs. 30.88 |
| 7 | Calculate final bill | Rs. 648.38 |
| 8 | Create report path | OrderReport.txt |
| 9 | Write report | Order and bill saved |
| 10 | Open report for reading | File opened |
| 11 | Read report line by line | Report displayed |
| 12 | Close file resources | Done automatically |
## File Created
OrderReport.txt
The file stores the customer name, ordered items, total quantity, subtotal, discount, tax, total bill, and kitchen status.
## Conclusion
The program demonstrates file writing, file reading, and exception handling to preserve and display restaurant billing records.