# Veterinary Management System
A fully functional veterinary management system written in Java.
* MySQL was used to process the data.
* The interface was created using JavaFX.
* Maven was used for easier usage.

It is based on a statement of work, first developing its own database and then the application. The database contains sufficient and realistic mock data.

## Overview

Upon initiating the program, the user is greeted by a selection screen that offers two options. The first option allows the user to access the database as a Veterinarian, while the second option enables them to view the database as a Customer.

![](Images/img.png)

If the user selects the "Customer" button, a screen corresponding to their selection will be displayed.

By entering your customer ID and clicking the "Inquire" button, you will be able to view your past reservations as well as upcoming ones.

In the "My Invoices" section, the same logic and interface have been implemented. When the user enters their customer ID, the system performs a database query, specifically targeting the invoice table, to retrieve invoices associated with that particular customer.

![](Images/img_1.png)

If the interface user selects "View the Database" as a veterinarian user, they will be directed to a login screen. To access this section, the user must be a veterinarian. The user is required to enter their email and password (Vet Work Phone), which will be validated against the information stored in the database. If the entered information is valid, the user will be granted access to this section of the interface. Additionally, below the login button, there is a label that indicates the status of the database connection.

![](Images/img_2.png)

Once logged into the veterinary interface, veterinarians have the ability to view the database, which contains various tables. These tables are presented as tabs within the interface, with each tab named after the corresponding table in the database. The information stored in the database is displayed in the interface using the Table View and Table Column attributes, allowing veterinarians to easily navigate and interact with the data.

In addition to viewing the database, veterinarians in our system have the capability to manipulate data using the insert, update, and delete functionalities. This allows them to add new records to the database using the insert operation, modify existing records using the update operation, and remove unwanted records using the delete operation. These functionalities provide veterinarians with the flexibility to manage and maintain the data in the database according to their specific needs and requirements.

![](Images/img_3.png)

## How to run?

Before running the program, please make the following modifications:

1. Open the `Connect.java` class located at `src/main/java/JDBC/Connect.java`. In this class, you will find the database connection properties. Modify these properties to match your database configuration. Make sure to update the localhost, password, and port number accordingly. This step is crucial for establishing a successful connection.

2. Implement the database by using the `VMSDBSQL.SQL` file. You can find this file in the `src/main/vmsDB/` directory. You can either execute this SQL file directly in your preferred database management tool (e.g., XAMPP, MySQL Workbench) or import the updated `veterinary_management_system(final).sql` file from Phase 2. This will create the necessary tables and populate them with sample data for the Veterinary Management System.

3. You don't need to add any VM options or external libraries manually. JavaFX and MySQL Connector/J are implemented via Maven, and during the indexing phase, these libraries will be automatically downloaded and managed.

Once you have completed these steps, you should be ready to run the program.

 3 different ways to run the project

1. By opening the V_M_S_F file in an IDE (IntelliJ or Eclipse) basically press the run button.
   
   ![](Images/way-1.png)
   
2. In IntelliJ at the right there is a tab called Maven by opening it you will reveal 3 packages.
   n the Plugins then the javafx package after that double click the `javafx:run`
   
   ![](Images/way-2.png)
   
3. By using CMD (Terminal) go into the path of V_M_S_F package and run the following command
   ``mvn clean install package javafx:run``
   
   ![](Images/way-3.png)

## Database Design

![](Images/db.png)

## IMPORTANT NOTE on INSERT/UPDATE/DELETE OPERATIONS:

If you want an efficient database app, you should make an "insert" operation considering the following order.

customer -> customerphonenumber -> PetCharacteristic -> Pet ->  Service -> Invoice -> Needs -> Vet -> Provides

- Also, you cannot update IDs in all tables because these IDs are unique.(Only insert and delete)
