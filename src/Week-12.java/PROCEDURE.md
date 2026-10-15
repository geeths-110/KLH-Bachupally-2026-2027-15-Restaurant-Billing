# Week 12 — Java Streams and Capstone Reports
## Aim
To use Java Streams and Collectors to process restaurant order data and generate useful billing reports.
## Procedure
1. Create FoodItem and Order classes.
2. Store the menu and order items using ArrayList.
3. Accept customer orders and validate quantities.
4. Use mapToDouble() and sum() to calculate the subtotal.
5. Use filter() or partitioningBy() to categorize food items.
6. Use distinct() and sorted() to display unique food names in sorted order.
7. Use groupingBy() and summingInt() to calculate quantities for each food item.
8. Use average() to calculate the average unit price.
9. Use max() and Optional to identify the highest-priced ordered item.
10. Use Collectors.joining() to create a summary of ordered items.
11. Calculate the discount, tax, and final bill.
12. Save the order and report details to OrderReport.txt.
13. Read and display the saved report.
## Concepts Used
- Stream source, intermediate operations, and terminal operations
- map(), distinct(), and sorted()
- mapToDouble(), mapToInt(), sum(), and average()
- max() and Optional
- Collectors.groupingBy()
- Collectors.summingInt()
- Collectors.partitioningBy()
- Collectors.joining()
- Lambda expressions and method references
- File handling
## Result
The program processes restaurant orders using Streams, generates item-wise summaries, calculates the bill, and saves the report in a text file.