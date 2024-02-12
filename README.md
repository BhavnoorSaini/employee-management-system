# Employee Management System

This is a Java-based Employee Management System application that allows users to perform various tasks related to employee management, such as adding, viewing, updating, and removing employee records. The application provides a user-friendly graphical interface for easy interaction.

## Features
- Login System: Users can log in to access the system.
- Registration: New users can register for an account.
- View Employees: View a list of all employees in the database.
- Add Employee: Add new employee records to the database.
- Update Employee: Modify existing employee records.
- Remove Employee: Delete employee records from the database.

## Technologies Used
- Java: The core programming language used to develop the application.
- Swing: Java's GUI toolkit used for creating the graphical user interface.
- JDBC: Java Database Connectivity used to interact with the database.
- MySQL: The database management system used to store employee records.

## Dependencies
- Java Development Kit (JDK): Required to compile and run the Java code.
- MySQL Connector/J: Java library for connecting to MySQL databases.
- Java Swing Library: Included in the Java Development Kit, used for creating the graphical user interface.
- Eclipse IDE (Optional): Integrated Development Environment for Java development.
- Add the following JAR files to the classpath of the project:
  - jcalendar-tz-1.3.3-4.jar
  - mysql-connector-java-8.0.28.jar
  - rs2xml.jar

- To add these JAR files to your classpath:
  - Download the JAR files from the web.
  - In your Java IDE, right-click on your project and select "Properties" or "Build Path" > "Configure Build Path."
  - Navigate to the "Libraries" tab.
  - Click "Add JARs" or "Add External JARs" and select the downloaded JAR files.
  - Click "Apply" or "OK" to save the changes.
 
## Setup
1. Clone the repository to your local machine.
```bash
git clone <repo-url>
```
2. Ensure you have Java Development Kit (JDK) installed.
3. Follow all steps under dependencies
4. Install MySQL and create a database for the application.
5. Open the Conn.java file located in the src/main directory and replace "creds.password" with the string of your MySQL database password. Also, the default username of MYSQL is "root". If your MySQL root username is different, update it accordingly.
6. Run the following SQL commands in MySQL Workbench to set up the required database tables:
```bash
CREATE DATABASE IF NOT EXISTS employeemanagmentsystem;

Show databases;

use employeemanagmentsystem;

DROP TABLE IF EXISTS login;
create table login(username varchar(20), password varchar(20));

insert into login values('admin', '12345');

select * from login;

DROP TABLE IF EXISTS employee;
create table employee(name varchar(20), fname varchar(20), dob varchar(30), salary varchar(20), address varchar(100), phone varchar(20), email varchar(40), education varchar(40), designation varchar(30), ssn varchar(25), empId varchar(15));
select * from employee;
```
## Start Program
1. Open the project in your preferred Java IDE.
2. Run the Start.java file to start the application. You can do this by navigating to the src/main directory in your terminal or command prompt and running the command java Start.java.
3. The default login username and password is: "admin", "12345".

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:
- Fork the repository.
- Create a new branch (git checkout -b feature)
- Make your changes
- Commit your changes (git commit -am 'Add new feature')
- Push to the branch (git push origin feature)
- Create a new Pull Request.

## Authors
Bhavnoor Saini

### Credits
Code for Interview

## Support
For help and support, please contact bhavnoorsaini@icloud.com.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details.
