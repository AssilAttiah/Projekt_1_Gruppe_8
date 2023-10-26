Group 8 project for Harry's Salon:

# Harry's Salon Booking System

## Project Description

Harry's Salon is in need of an electronic booking system to manage appointments, payments, and other salon-related activities. This project aims to develop a console-based single-user booking system that is user-friendly and efficient.

## Features

### Core Features

1. **Electronic Booking System**: A console-based single-user system to manage all bookings.
2. **User-Friendly Interface**: An intuitive interface that displays only necessary information.

### Nice-to-Have Features

1. **Business Economics**: Secure access to business financials through a password.
2. **Holiday Management**: Easily register holidays and non-working days.
3. **Appointment Management**: Create, view, and delete appointments.
4. **Payment Management**: Handle payments and keep track of credits.

## Code Design pattern

### MVC design pattern - Model-View-Controller: 
1. Model
    What it is:
       The Model represents the data and the business rules controlling it.
       It communicates to the database and updates the View whenever the data changes.
    Responsibilities:
      - Data access and storage.
      - Business logic and calculations.
      - Data update notifications (to the View).
2. View
    What it is:
       The View represents the UI of the application.
       It displays data from the Model to the user and sends commands to the Model.
    Responsibilities:
      - Display data (provided by the Model).
      - User interface elements (e.g., text boxes, buttons).
      - User experience (e.g., data presentation format).
3. Controller
    What it is:
       The Controller acts as an interface between Model and View.
       It takes the user input from the View, processes it (with possible updates to the Model), and returns the output display      to the View.
    Responsibilities:
      - Receive user input.
      - Validate user input.
      - Update the Model based on user input.

4. How They Interact
  1. User interacts with the View: The user performs an action like clicking a button.
  2. Controller handles the input: The View forwards the user input to the Controller.
  3. Controller updates the Model: Based on the user input, the Controller will make the appropriate calls to update the Model.
  4. Model updates the View: Once the Model is updated, it notifies the View.
  5. View updates the UI: Finally, the View will update the UI to reflect the changes in the Model.

## Technologies Used

- Java
- IntelliJ IDEA
- GitHub
- Visual Paradigm

## How to Run

1. Clone the repository: `git clone <repository_link>`
2. Open the project in IntelliJ IDEA.
3. Run the `Main.java` file.

## Development Team

- [Assil Attiah](https://github.com/AssilAttiah)
- [Ali Selimi](https://github.com/AliSelimi)
- [Aleksander H. Ellegård](https://github.com/AlekOmOm)

## Acknowledgments

- Harry, for giving us the opportunity to develop this system.
- Our instructors and mentors for their guidance.
