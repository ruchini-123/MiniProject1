import java.sql.*;

import java.util.Scanner;



public class StudentDatabaseApp {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root"; // your DB username
    private static final String PASSWORD = "1234"; // your DB password

    private Connection conn;

    public StudentDatabaseApp() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addStudent(String name, int age, String grade) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt =  conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        String sql = "SELECT * FROM students";
        try (Statement stmt =  conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID | Name | Age | Grade");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name, int age, String grade) {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student ID not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
