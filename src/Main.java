
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDatabaseApp app = new StudentDatabaseApp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter grade: ");
                    sc.nextLine();
                    String grade = sc.nextLine();
                    app.addStudent(name, age, grade);
                    break;
                case 2:
                    app.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idU = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = sc.nextLine();
                    app.updateStudent(idU, newName, newAge, newGrade);
                    break;
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idD = sc.nextInt();
                    app.deleteStudent(idD);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}