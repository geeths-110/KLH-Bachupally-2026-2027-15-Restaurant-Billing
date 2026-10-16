# Week 12 — Trace Table
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
| 1 | Add Biryani to order | Quantity = 2 |
| 2 | Add Pizza to order | Quantity = 1 |
| 3 | Calculate subtotal using Streams | Rs. 650.00 |
| 4 | Calculate discount | Rs. 32.50 |
| 5 | Calculate tax | Rs. 30.88 |
| 6 | Calculate total bill | Rs. 648.38 |
| 7 | Apply distinct() and sorted() | Biryani, Pizza |
| 8 | Apply groupingBy() | Biryani = 2, Pizza = 1 |
| 9 | Apply partitioningBy() | 2 ordered entries priced at Rs. 200 or more |
| 10 | Apply mapToInt() and sum() | 3 items |
| 11 | Apply average() | Rs. 225.00 |
| 12 | Apply max() | Pizza, Rs. 250.00 |
| 13 | Apply joining() | Biryani, Pizza |
| 14 | Save and read the report | OrderReport.txt |
## Stream Report Results
- Unique ordered items: [Biryani, Pizza]
- Quantity by food: {Biryani=2, Pizza=1}
- Items priced Rs. 200 or more: 2
- Total quantity: 3
- Average unit price: Rs. 225.00
- Highest-priced item: Pizza - Rs. 250.0
- Item summary: Biryani, Pizza
## Conclusion
Java Streams and Collectors help process order data, calculate summaries, and generate useful restaurant reports.