# JAVA-Coding-Challenge

This provides a sample code repository for financial transactions recorded in CSV File

Prerequisites
-------------
1. Eclipse IDE - JAVA 8
2. Maven Repositories - CSV 
3. Input csv file

Implementation
--------------
To meet the requirements, I have created a maven project named "RECORDS" with added external library Maven dependencies(for CSV Reader).
I used "Buffered Reader" to enter the input by user onto the console.
Also created POJO Class to relate the fields of the records in the Input  CSV file.
The conditions logic is written inside the loop while reading the CSV records where the "Realative Balance for the given Period" and "Number of TRansactions" has to be displayed for the given "Account" and "CreatedAt" range.

Test Cases
----------
The Input 1:
accountId: ACC998877
from: 20/10/2018 05:33:43
to: 21/10/2018 23:33:43
The output 1 :
Relative balance for the period is: $5.50
Number of transactions included is: 3


The Input 2:
accountId: ACC334455
from: 20/10/2018 11:00:00
to: 21/10/2018 23:33:00
The output 2 :
Relative balance for the period is: -$42.75
Number of transactions included is: 4

