package CodSoftIntern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {
    private String name;
    private int rollNumber;
    private double grade;

    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
public class ConsoleUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        boolean running = true;

        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline

                    Student student = new Student(name, rollNumber, grade);
                    system.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    if (system.removeStudent(removeRollNumber)) {
                        System.out.println("Student removed successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = system.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    for (Student s : system.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}
