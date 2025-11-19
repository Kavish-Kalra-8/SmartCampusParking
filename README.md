# Smart Campus Parking System

![Project Status](https://img.shields.io/badge/status-complete-green) ![Java Version](https://img.shields.io/badge/java-17%2B-blue)

## 📖 Project Overview
The **Smart Campus Parking System** is a Core Java application designed to digitize and automate the management of university parking slots. [cite_start]It addresses the problem of manual vehicle tracking by providing a streamlined interface for vehicle entry, exit, fee calculation, and administrative monitoring[cite: 10, 89, 90].

[cite_start]This project was built to demonstrate **Object-Oriented Programming (OOP)** concepts such as Inheritance, Polymorphism, and Encapsulation in a real-world context[cite: 8, 51].

---

## ✨ Key Features
[cite_start]This project implements the following functional requirements[cite: 16, 92]:

### 1. Vehicle Entry Management
* **Slot Allocation:** Automatically assigns the nearest available parking slot.
* **Vehicle Identification:** capturing License Plate Number and Vehicle Type (Car/Bike/Truck).
* **Validation:** Prevents duplicate entries for the same vehicle.

### 2. Exit & Billing System
* **Automated Billing:** Calculates parking fees based on duration (Entry Time vs. Exit Time).
* **Dynamic Pricing:** Applies different tariff rates (e.g., Bikes: $2/hr, Cars: $5/hr).
* **Receipt Generation:** Displays a summary of the transaction upon exit.

### 3. Admin Dashboard
* **Occupancy Tracking:** Real-time view of total occupied vs. available slots.
* **Revenue Reports:** Tracks total earnings for the session.
* **Reset Capability:** Allows admins to clear data for a new day.

---

## 🛠️ Technologies & Tools Used
* [cite_start]**Language:** Java (JDK 17) [cite: 93]
* **IDE:** IntelliJ IDEA / Eclipse / VS Code
* [cite_start]**Version Control:** Git & GitHub [cite: 55]
* **Data Storage:** File Handling (Text Files) / Java Collections (ArrayList, HashMap)

---

## ⚙️ OOP Concepts Implemented
* **Inheritance:** A base `Vehicle` class is extended by `Car` and `Bike` classes.
* **Polymorphism:** The `calculateFee()` method is overridden to provide specific billing logic for different vehicle types.
* **Encapsulation:** All data fields (e.g., `licensePlate`, `revenue`) are private and accessed via Getter/Setter methods.
* **Abstraction:** Implementation of abstract classes for the basic Parking logic.
* [cite_start]**Exception Handling:** Custom exceptions like `ParkingLotFullException` and `InvalidTicketException`[cite: 41].

---

## 🚀 Steps to Install & Run
[cite_start]Follow these steps to set up the project on your local machine[cite: 94]:

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/SmartCampusParking.git](https://github.com/YOUR_USERNAME/SmartCampusParking.git)
    ```

2.  **Navigate to the Directory**
    ```bash
    cd SmartCampusParking
    ```

3.  **Compile the Code**
    ```bash
    javac -d bin src/com/campus/parking/main/Main.java
    ```

4.  **Run the Application**
    ```bash
    java -cp bin com.campus.parking.main.Main
    ```

---

## 🧪 Instructions for Testing
[cite_start]Use the following test cases to verify the application features[cite: 95]:

| Test Case | Action | Expected Output |
| :--- | :--- | :--- |
| **Park Vehicle** | Select Option 1 -> Enter "CAR123" -> Select "Car" | System assigns a Slot ID (e.g., C-01) and confirms entry. |
| **Duplicate Entry** | Try to park "CAR123" again | Error Message: "Vehicle already exists in the lot." |
| **Exit Vehicle** | Select Option 2 -> Enter "CAR123" | System shows parking duration and calculated fee. |
| **Admin View** | Select Option 3 -> Enter Password | Shows Total Vehicles: 0, Total Revenue: [Fee Amount]. |

---

## 📸 Screenshots
[cite_start]*(Add your screenshots inside the /assets folder and uncomment the lines below)* 

---

## 👤 Author
* **Name:** Kavish Kalra
* **Registration no. :** 24BSA10034
* **Course:** [Your Course Name]