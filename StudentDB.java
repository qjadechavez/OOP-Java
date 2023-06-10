import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDB {
    private Map<String, Student> studentDetails;

    public StudentDB() {
        studentDetails = new HashMap<>();
    }

    public void addStudent(String rollNumber, String name, int age, String department) {
        if (studentDetails.containsKey(rollNumber)) {
            System.out.println("Error: Student with the given roll number already exists.");
        } else {
            Student student = new Student(name, age, department);
            studentDetails.put(rollNumber, student);
            System.out.println("Student added successfully.");
        }
    }

    public void getStudentDetails(String rollNumber) {
        if (studentDetails.containsKey(rollNumber)) {
            Student student = studentDetails.get(rollNumber);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Department: " + student.getDepartment());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudentDetails(String rollNumber, String name, int age, String department) {
        if (studentDetails.containsKey(rollNumber)) {
            Student student = studentDetails.get(rollNumber);
            student.setName(name);
            student.setAge(age);
            student.setDepartment(department);
            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(String rollNumber) {
        if (studentDetails.containsKey(rollNumber)) {
            studentDetails.remove(rollNumber);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (studentDetails.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student Details:");
            System.out.println("-------------------------------------");
            System.out.printf("%-12s %-20s %-6s %-15s%n", "Roll Number", "Name", "Age", "Department");
            System.out.println("-------------------------------------");
            for (Map.Entry<String, Student> entry : studentDetails.entrySet()) {
                String rollNumber = entry.getKey();
                Student student = entry.getValue();
                System.out.printf("%-12s %-20s %-6d %-15s%n", rollNumber, student.getName(), student.getAge(),
                        student.getDepartment());
            }
            System.out.println("-------------------------------------");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentDB sms = new StudentDB();

            while (true) {
                System.out.println("\n-- Student Management System --");
                System.out.println("1. Add Student");
                System.out.println("2. Retrieve Student Details");
                System.out.println("3. Update Student Details");
                System.out.println("4. Delete Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll Number: ");
                        String rollNumber = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        sms.addStudent(rollNumber, name, age, department);
                        break;
                    case 2:
                        System.out.print("Enter Roll Number: ");
                        rollNumber = scanner.nextLine();
                        sms.getStudentDetails(rollNumber);
                        break;
                    case 3:
                        System.out.print("Enter Roll Number: ");
                        rollNumber = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Department: ");
                        department = scanner.nextLine();
                        sms.updateStudentDetails(rollNumber, name, age, department);
                        break;
                    case 4:
                        System.out.print("Enter Roll Number: ");
                        rollNumber = scanner.nextLine();
                        sms.deleteStudent(rollNumber);
                        break;
                    case 5:
                        sms.displayAllStudents();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class Student {
        private String name;
        private int age;
        private String department;

        public Student(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }
}
