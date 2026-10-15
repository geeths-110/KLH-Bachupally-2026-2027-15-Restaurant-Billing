# Week 10 — Files and Persistence
## Aim
To implement file handling and store restaurant order and billing details in a text file using Java.
## Procedure
1. Create the FoodItem and Order classes.
2. Display the menu and accept customer orders.
3. Calculate the subtotal, discount, tax, and total bill.
4. Create a Path for OrderReport.txt.
5. Use Files.newBufferedWriter() to save the order details and bill.
6. Use BufferedWriter to write customer details, food items, and billing information.
7. Use try-with-resources to close the writer automatically.
8. Use Files.newBufferedReader() to open the saved report.
9. Read the report line by line using readLine().
10. Handle file errors using IOException.
11. Display the saved report on the console.
## Concepts Used
- Path and Path.of()
- Files.newBufferedWriter()
- Files.newBufferedReader()
- BufferedWriter
- BufferedReader
- write() and newLine()
- readLine()
- Try-with-resources
- IOException
- File persistence
## Result
The program calculates the restaurant bill, saves the report in OrderReport.txt, and reads the saved report back to the console.