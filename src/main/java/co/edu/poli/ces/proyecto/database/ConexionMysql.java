package co.edu.poli.ces.proyecto.database;

import co.edu.poli.ces.proyecto.dao.Student;
import co.edu.poli.ces.proyecto.dao.Course;
import co.edu.poli.ces.proyecto.dao.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionMysql {
    private String user;
    private String password;
    private int port;
    private String host;
    private String nameDatabase;
    private Connection cnn;

    public ConexionMysql(){
        user = "root";
        password = "";
        port = 3306;
        host = "localhost";
        nameDatabase = "database_evaluative_moment";
    }

    private void createConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+nameDatabase, user, password);
            System.out.println("Successful connection.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("An error occurred during the connection.");
            throw new RuntimeException(e);
        }
    }

    public List<Student> getAlumnos()  {
        String sql = "SELECT * FROM students";

        List<Student> students = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()){
                students.add(new Student(result.getInt("id"),result.getString("name"),result.getString("lastName"),result.getInt("age"),result.getDate("createdAt"),result.getDate("updatedAt"),result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public List<Course> getCursos() {
        String sql = "SELECT * FROM courses";

        List<Course> courses = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                courses.add(new Course(result.getInt("id"), result.getString("name_course"), result.getString("teacher"), result.getString("description"), result.getDate("createdAt"), result.getDate("updatedAt"), result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Schedule> getHorarios() {
        String sql = "SELECT * FROM schedules";

        List<Schedule> schedules = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                schedules.add(new Schedule(result.getInt("id_student"), result.getInt("id_course"), result.getDate("createdAt"), result.getDate("updatedAt"), result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return schedules;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
