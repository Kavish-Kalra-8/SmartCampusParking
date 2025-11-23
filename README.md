# Smart Campus Parking System

![Project Status](https://img.shields.io/badge/status-complete-green) ![Java Version](https://img.shields.io/badge/java-17%2B-blue)

## 📖 Project Overview
The **Smart Campus Parking System** is a Java based application which is  designed to digitalize and automate the management of parking slots in the university. [cite_start]It solves the problem of tracking the vehicles in the parking slot manually by providing an interface for vehicle entry, exit, fee calculation, and monitoring[cite: 10, 89, 90].

[cite_start]This project shows the practical usage of concepts of **Object-Oriented Programming (OOP)** such as Inheritance , Polymorphism , Abstraction and Encapsulation in solving real world problems.[cite: 8, 51].

---

## ✨ Key Features
Here are the main features I implemented based on the project requirements:

1. Vehicle Entry

Auto-Assign Slots: You don't need to check for space manually; the system finds the nearest empty slot automatically.

Vehicle Details: It records the License Plate and Vehicle Type (Car or Bike) upon entry.

No Duplicates: I added validation to ensure the same car can't be parked twice at the same time.

2. Exit & Billing

Auto-Billing: When a vehicle leaves, the system checks the duration and calculates the fee instantly.

Different Rates: It applies different logic for different vehicles (e.g., Bikes pay less than Cars).

Receipts: It prints a simple transaction summary on the console after checkout.

3. Admin Dashboard

Live Tracking: The admin can see exactly how many slots are free vs. occupied in real-time.

Revenue Log: It keeps a running total of how much money was collected during the session.

Reset: Option to clear all data to start fresh for a new day.

### 3. Admin Dashboard
* **Occupancy Tracking:** Porvides Real time tracking of occupied and available slots.
* **Revenue Reports:** Tracks the total earnings for the session.
* **Reset Capability:** Allows admins to reset so to clear data for a new day.

---

## 🛠️ Technologies & Tools Used
Language: Java (JDK 17) - Chosen for its strong OOP support.

IDE: Eclipse - Used for writing and debugging the code.

Version Control: Git & GitHub - Used to track changes and manage file history.

Data Storage: Made use of Text Files to maintain the data and Java Collections (ArrayList/HashMap) for fast data processing.

---

## ⚙️ OOP Concepts Implemented
* **Inheritance:** A base `Vehicle` class is extended by `Car` and `Bike` classes.
* **Polymorphism:** The `calculateFee()` method is overridden to provide the specific billing logic implementation required for different vehicle types.
* **Encapsulation:** All data fields (e.g., `licensePlate`, `revenue`) are private and accessible only with the use of Getter and Setter methods.
* **Abstraction:** Implementation of abstract classes for the basic Parking logic.
* [cite_start]**Exception Handling:** Custom exceptions like `ParkingLotFullException` and `InvalidTicketException`[cite: 41].

---

## 🚀 Steps to Install & Run
[cite_start]Follow the given steps to set up the project on your local machine[cite: 94]:

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
[cite_start]Use the following test cases to verify the working of the features [cite: 95]:

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
