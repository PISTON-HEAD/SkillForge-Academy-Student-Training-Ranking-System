---

# 🏫 SkillForge Academy Management System

### 📘 Problem Description

You are tasked with designing and implementing a **Java-based console application** called **SkillForge Academy Management System**.
This system is intended to manage **students, courses, enrollments, and course performances** within a training academy.
The application should allow administrators to add new students, create courses, record performances, and view ranked student results.

The system should be **menu-driven** (interactive in console) and support **object-oriented design principles** using classes, encapsulation, and composition.

---

## 🎯 Core Objectives

1. **Model real-world entities** such as students, courses, and performance data using Java classes.
2. Implement features that let users manage and track student progress in various courses.
3. Apply **object-oriented programming concepts** including:

   * Class design and encapsulation
   * Composition (one class containing others)
   * Collections (ArrayList, HashMap)
   * Sorting and comparison using `Comparator`
4. Provide a **text-based user interface** for managing the academy system.

---

## 🧩 Functional Requirements

The system should provide the following features:

### 1️⃣ Add Course

* Admin can create a new course by entering:

  * `Course ID`
  * `Course Name`
  * `Instructor Name`
  * `Course Type` (e.g., Coding, Design, Management)
  * `Difficulty Level` (1–5)

### 2️⃣ Add Student

* Admin can add a new student by entering:

  * `Student ID`
  * `Student Name`
  * `Email Address`

### 3️⃣ Enroll Student to Course

* A student can be enrolled into an existing course.
* Prevent duplicate enrollments.
* Validate that both the course and student exist before enrolling.

### 4️⃣ Record Performance

* Record a student’s performance in a specific course using:

  * `Assignment Score`
  * `Quiz Score`
  * `Project Score`
* Final score is calculated as:

  
  Final Score = (Assignment * 0.3) + (Quiz * 0.2) + (Project * 0.5)
  

### 5️⃣ Show All Students

* Display details of all students sorted alphabetically by name.
* For each student, list:

  * Personal details (ID, Name, Email)
  * Enrolled courses with performance breakdown
  * Calculated overall score across all courses

### 6️⃣ Show Rankings

* Display all students ranked by their **overall performance score** (average of all course scores).
* Each entry should show:

  * Rank number
  * Student name
  * Overall average score (formatted to one decimal)

### 7️⃣ Show Top 3 Performers

* Display only the **top three students** from the ranking list.

### 8️⃣ Exit Program

* Gracefully terminate the program with a goodbye message.

---

## 🧱 Class Structure Overview

| Class Name                   | Responsibility                                                                                                                    |
| ---------------------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| **Student**                  | Stores student details, enrolled courses, and performance records. Provides methods to calculate and display overall performance. |
| **Course**                   | Represents an academy course with its details (ID, name, instructor, type, difficulty). Tracks enrolled students.                 |
| **CoursePerformance**        | Links a student’s performance to a specific course. Calculates the weighted final score.                                          |
| **AcademyManagementSystem**  | Central controller class. Manages lists of students and courses, enrollment, performance recording, and ranking logic.            |
| **SkillForgeAcademy (main)** | Entry point containing the menu-driven console interface for interacting with the system.                                         |

---

## ⚙️ Technical Details & Notes

* Use **ArrayList** for storing collections of students, courses, and performances.
* Use **HashMap** for ranking calculations.
* Use **Comparator** and **Map.Entry.comparingByValue()** for sorting student rankings.
* Include proper **validation checks** (e.g., invalid course IDs, duplicate enrollments).
* Follow **OOP best practices** — use private attributes with getters/setters and meaningful method names.

---

## 🧮 Sample Calculations

If a student scored:

* Assignment = 85
* Quiz = 90
* Project = 95

Then:


Final Score = (85 * 0.3) + (90 * 0.2) + (95 * 0.5)
             = 25.5 + 18 + 47.5
             = 91.0


---

## 🧠 Concepts You’ll Practice

* Object-Oriented Programming (OOP)
* Class relationships and data encapsulation
* ArrayList and HashMap manipulation
* Comparator sorting
* Menu-driven user input using Scanner
* Console-based reporting and data display

---

## 💡 Suggested Enhancements (Optional Challenges)

If you want to extend this project in the future:

* Add file-based data persistence (save and load data using text or JSON files).
* Add input validation for numeric ranges (e.g., difficulty 1–5).
* Include GPA-like grading (A, B, C, etc.) based on score thresholds.
* Provide instructor-level summaries (average performance per course).
* Add support for removing or updating student/course records.

---

## 🧾 Expected Output Example (Console Snapshot)


===== SkillForge Academy =====
1. Add Course
2. Add Student
3. Enroll Student to Course
4. Record Performance
5. Show All Students
6. Show Rankings
7. Show Top 3 Performers
8. Exit
==============================
Enter choice: 5

========================================
           STUDENT DETAILS              
========================================
Student ID      : S101
Name            : Alice Johnson
Email           : alice@skillforge.com
----------------------------------------
Course Performances:
  1. Course ID      : C001
     Course Name    : Java Programming
     Instructor     : Dr. Smith
     Course Type    : Coding
     Difficulty     : 4
     Assignment     : 85.0
     Quiz           : 90.0
     Project        : 95.0
     Final Score    : 91.00
----------------------------------------
Overall Score   : 91.00
========================================


---

## 🧰 How to Run

1. Save the entire code as **`SkillForgeAcademy.java`**
2. Compile and run it using:

   javac SkillForgeAcademy.java
   java SkillForgeAcademy

3. Follow the on-screen instructions.



## 🏁 Goal

By completing this project, you’ll gain hands-on experience in:

* **Structuring a multi-class Java application**
* **Implementing relationships and logic between objects**
* **Designing real-world systems using OOP principles**

## 💻 Sample Interaction

===== SkillForge Academy =====
1. Add Course
2. Add Student
3. Enroll Student to Course
4. Record Performance
5. Show All Students
6. Show Rankings
7. Show Top 3 Performers
8. Exit
==============================

Enter choice: 1
Enter Course Name: Java Programming
Enter Instructor: Mr. Mehta
Enter Course Type: Coding
Enter Difficulty (1-5): 4
✅ Course added successfully!

Enter choice: 2
Enter Student Name: Riya Patel
Enter Email: riya@skillforge.com
✅ Student registered successfully!

Enter choice: 4
Enter Student ID: S001
Enter Course ID: C001
Enter Assignment Score: 80
Enter Quiz Score: 70
Enter Project Score: 90
✅ Performance recorded for Riya Patel in Java Programming.

Enter choice: 6
--- Student Rankings ---
1️⃣ Riya Patel — 83.5
2️⃣ Karan Shah — 77.3
3️⃣ Aman Singh — 65.2
------------------------

Enter choice: 7
🏆 Top 3 Performers:
1. Riya Patel (83.5)
2. Karan Shah (77.3)
3. Aman Singh (65.2)

