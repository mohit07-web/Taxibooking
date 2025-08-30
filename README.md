Taxi Booking Project Documentation
Overview
This project is a Taxi Booking System built using Spring Boot 3.2.5 with Java 17 and Jakarta API. The application includes various features like user authentication, file uploading, car booking, and management. It employs MySQL for the database, Thymeleaf for the front-end, and runs on a Tomcat Server. Lombok is used to reduce boilerplate code.
Technologies Used

Spring Boot 3.3.0
Java 17
Hibernate
Jakarta API
MySQL
Spring Tool Suite (STS) IDE
Tomcat Server
Lombok
Thymeleaf
Maven
Prerequisites
JDK 17 installed
MySQL Workbench installed
STS IDE installed
Lombok configured in your IDE

Features

1. Admin Panel
The admin panel allows the admin to manage users, bookings, and cars.
Admin Controller: Handles requests related to admin operations.
Admin Views: Thymeleaf templates for admin operations located in src/main/resources/templates/admin.

3. Admin Authentication (Login/Logout)
Admin can register, log in, and log out of the system.
Login/Logout Views: Thymeleaf templates for login and logout located in src/main/resources/templates/admin

5. File Uploading
Admin can upload files related to their profiles or booking details.
File Upload Controller: Handles file upload requests.
File Upload View: Thymeleaf template for file upload located in src/main/resources/templates.

7. Contact
A contact form for users to reach out to the admin.
Contact Controller: Handles contact form submissions.
Contact View: Thymeleaf template for contact form located in src/main/resources/templates.

9. Car Booking
Users can book a car by selecting the car and providing booking details.
Booking Controller: Handles booking requests.
Booking View: Thymeleaf template for car booking located in src/main/resources/templates.

11. About
An about page that provides information about the taxi booking service.
About Controller: Handles requests for the about page.
About View: Thymeleaf template for the about page located in src/main/resources/templates.

13. Services
A page that lists the services provided by the taxi booking system.
Services Controller: Handles requests for the services page.
Services View: Thymeleaf template for the services page located in src/main/resources/templates.

Running the Application
Start the MySQL server.
Run the Spring Boot application from the TaxiBookingSystemApplication.java file.
Access the application through http://localhost:8080
Conclusion
This documentation provides a comprehensive guide to setting up and running the Taxi Booking System. The project includes essential features like an admin panel, user authentication, file uploading, contact form, car booking, about page, and services page. The use of Spring Boot, Thymeleaf, and other technologies ensures a robust and maintainable application.
