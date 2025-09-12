# CodeAlpha_java_internship_task
This is my internship submission of java programming in CodeAlpha at 1st September 2025 to 30th September 2025

# Task 1 : Student grade tracker:
##### Aim :
Build a Java program to input and manage student grades.
● Calculate average, highest, and lowest scores.
● Use arrays or ArrayLists to store and manage data.
● Display a summary report of all students.
● Make the interface console-based or GUI-based as desired.



#### code:
```
package pro1;

import java.util.*;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    String getLetterGrade() {
        if (grade >= 90) return "A+";
        else if (grade >= 80) return "A";
        else if (grade >= 70) return "B+";
        else if (grade >= 60) return "B";
        else if (grade >= 50) return "C";
        else return "F";
    }
}

public class StudentGradeTracker {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Students");
            System.out.println("2. Remove Student by Name");
            System.out.println("3. Show Grade Summary");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudents();
                case 2 -> removeStudent();
                case 3 -> showSummary();
                case 4 -> System.out.println("Exiting... Goodbye 👋");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    static void addStudents() {
        System.out.print("How many students do you want to add? ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            int grade;
            do {
                System.out.print("Enter grade (0–100): ");
                grade = sc.nextInt();
                if (grade < 0 || grade > 100)
                    System.out.println("❌ Invalid grade! Must be 0–100.");
            } while (grade < 0 || grade > 100);

            students.add(new Student(name, grade));
            sc.nextLine(); // consume newline
        }

        System.out.println("\n✅ " + count + " students added successfully!");
        System.out.println("📊 Total students in system: " + students.size());
    }

    static void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students to remove!");
            return;
        }

        sc.nextLine();
        System.out.print("Enter the name of the student to remove: ");
        String name = sc.nextLine();

        boolean removed = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("✅ Student \"" + s.name + "\" removed successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("❌ Student not found: " + name);
        } else {
            System.out.println("📊 Remaining students: " + students.size());
        }
    }

    // Show summary of all students
    static void showSummary() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students added yet!");
            return;
        }

        int sum = 0, max = students.get(0).grade, min = students.get(0).grade;
        String topStudent = students.get(0).name, lowStudent = students.get(0).name;

        System.out.println("\n--- Student Grades ---");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.grade + " (" + s.getLetterGrade() + ")");
            sum += s.grade;
            if (s.grade > max) {
                max = s.grade;
                topStudent = s.name;
            }
            if (s.grade < min) {
                min = s.grade;
                lowStudent = s.name;
            }
        }
        double avg = (double) sum / students.size();

        System.out.println("\n--- Grade Summary ---");
        System.out.println("Average Score: " + avg);
        System.out.println("Highest: " + max + " (" + topStudent + ")");
        System.out.println("Lowest: " + min + " (" + lowStudent + ")");
    }
}
```
<img width="596" height="793" alt="image" src="https://github.com/user-attachments/assets/d3de5bbd-cc8f-4888-b008-f756123221d7" />

<img width="593" height="762" alt="image" src="https://github.com/user-attachments/assets/fd6d9dec-095b-4b1f-bb0c-546916769b6d" />



# TASK 2: Stock Trading Platform:
##### Aim:
● Simulate a basic stock trading environment.
● Add features for market data display and buy/sell operations.
● Allow users to track portfolio performance over time.
● Use Object-Oriented Programming (OOP) to manage stocks, users and transactions.
● Optionally, include file I/O or database to persist portfolio data


# TASK 3: Artificial Intelligence Chatbot:
##### Aim: 
● Create a Java-based chatbot for interactive communication.Use Natural Language Processing (NLP) techniques.
● Implement machine learning logic or rule-based answers Train the bot to respond to frequently asked questions.
● Integrate with a GUl or web interface for real-time interaction.

# TASK 4:Hotel Reservation System:
##### Aim:
● Design a system to search, book, and manage hotel rooms
● Add room categorization (e.g, Standard, Deluxe, Suite)
● Allow users to make and cancel reservations
● Implement payment simulation and booking details view.
● Use OOP + databaselFile I/O for storing bookings and availability
