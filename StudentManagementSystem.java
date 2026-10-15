import java.util.ArrayList;
import java.util.Scanner;

// Student data class
class Student {
    int id, age;
    String name, course;
    float marks;

    // Constructor
    Student(int id, String name, int age, String course, float marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    // Display student details
    void display() {
        System.out.println("ID: " + id + " | Name: " + name + 
                           " | Age: " + age + " | Course: " + course + 
                           " | Marks: " + marks);
    }
}

// Main program
public class StudentManagementSystem {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int ch;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> viewAll();
                case 3 -> search();
                case 4 -> updateMarks();
                case 5 -> delete();
                case 6 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (ch != 6);
    }

    // Add new student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();

        list.add(new Student(id, name, age, course, marks));
        System.out.println(" Student added successfully!");
    }

    // View all students
    static void viewAll() {
        if (list.isEmpty()) {
            System.out.println(" No students found.");
            return;
        }

        for (Student s : list) {
            s.display();
        }
    }

    // Search by ID
    static void search() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.id == id) {
                s.display();
                return;
            }
        }

        System.out.println(" Student not found.");
    }

    // Update marks
    static void updateMarks() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.id == id) {
                System.out.print("Enter new marks: ");
                s.marks = sc.nextFloat();
                System.out.println(" Marks updated!");
                return;
            }
        }

        System.out.println(" Student not found.");
    }

    // Delete student
    static void delete() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = list.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println(" Student deleted!");
        } else {
            System.out.println(" Student not found.");
        }
    }
}
