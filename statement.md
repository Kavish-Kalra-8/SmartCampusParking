Project Problem Statement

1. Problem Statement

University campuses often face significant challenges in managing vehicle parking due to increasing student and faculty populations. Current manual methods of parking management lead to:

Traffic Congestion: Long queues at entry points due to slow manual recording of details.

Inefficient Space Utilization: Drivers often struggle to find empty spots, leading to time wastage and fuel consumption.

Revenue Leakage: Manual calculation of fees is prone to human error and manipulation.

Lack of Data: Administration lacks actionable data on peak hours and occupancy trends to plan future infrastructure.

The Smart Campus Parking System addresses these issues by automating the entry/exit workflow and providing real-time tracking of parking slot availability.

2. Scope of the Project

This project aims to develop a Core Java-based application that simulates a centralized parking management system.

In Scope:

Single-Lot Management: The system manages a defined number of slots (e.g., 100 slots) for a specific campus zone.

Vehicle Categorization: Support for distinct vehicle types (Cars, Bikes, and Transport Vehicles) with different billing rules.

Session Tracking: Maintaining the state of vehicles currently inside the lot.

Financial Calculation: accurate computation of fees based on parking duration.

Out of Scope:

Hardware integration (sensors/cameras).

Mobile app interface (this is a console/desktop application).

Multi-level parking navigation.

3. Target Users

The primary users of this system are:

Parking Administrator (Admin): Responsible for viewing daily reports, setting parking rates, and managing overall system configurations.

Gate Operator (User): The person at the entry/exit booth who inputs vehicle details and collects payments.

University Management: Uses the generated reports to analyze revenue and usage patterns for campus planning.

4. High-Level Features

The system implements the following key functionalities:

Automated Entry Logging:

Captures vehicle license plate and type.

Automatically assigns the nearest available Slot ID.

Records the precise entry timestamp.

Intelligent Billing Engine:

Calculates parking duration upon exit.

Applies dynamic tariff rates (e.g., First hour free, different rates for bikes vs. cars).

Generates a text-based receipt/invoice.

Real-Time Dashboard:

Displays current lot occupancy (e.g., "85/100 Slots Full").

Warns when the lot is at full capacity.

Data Persistence:

Saves daily transaction logs to local text files to ensure data is not lost when the application closes.