# Welcome to the School Management System project
 
### Languagues: Java (via IntelliJ IDEA) and SQL (via Microsoft SQL Server)
 
 
 
This is my old project on the topic of school management, relying on a combination of ***Java*** and ***MS SQL Server*** to create a school management system application.

As for **SQL Server**, it is pure structured query language: consists of many tables, each of which consists of a primary key and foreign keys, bound together. Retrieve data using SQL statements.

For the **Java** part, to build the user interface and connect to the SQL data through an API called **Java Dabase Connectivity (JDBC)**, which provides SQL access statements.

It can be understood as follows (after having knowledge of SQL and Java as well as JDBC):
1. First, design a suitable database management system for the project: create tables, existing data, primary keys, foreign keys, constraints ... Now use SQL Server to make it easy to implement. Access via SQL statements.

2. Design the user interface and the necessary functions corresponding to that interface. Connect to the database created in step 1 using JDBC. Voilà!`

Seemingly simple, they require a great deal of effort to correctly manipulate the SQL data form. That's why in the [sms](https://github.com/katyperrycbt/sms) project, I used NoSQL data (JSON) for storage, it is much more flexible, but requires more complex algorithms to ensure data integrity.
