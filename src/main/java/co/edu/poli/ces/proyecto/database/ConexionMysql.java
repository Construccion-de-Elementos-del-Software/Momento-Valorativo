package co.edu.poli.ces.proyecto.database;

import co.edu.poli.ces.proyecto.dao.Alumno;
import co.edu.poli.ces.proyecto.dao.Curso;
import co.edu.poli.ces.proyecto.dao.Horario;

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

    public List<Alumno> getAlumnos()  {
        String sql = "SELECT * FROM students";

        List<Alumno> alumnos = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()){
                alumnos.add(new Alumno(result.getInt("id"),result.getString("name"),result.getString("lastName"),result.getInt("age"),result.getDate("createdAt"),result.getDate("updatedAt"),result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return alumnos;
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
    public List<Curso> getCursos() {
        String sql = "SELECT * FROM cursos";

        List<Curso> cursos = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                cursos.add(new Curso(result.getInt("id"), result.getString("nombre_curso"), result.getString("profesor"), result.getString("descripcion"), result.getDate("createdAt"), result.getDate("updatedAt"), result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return cursos;
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

    public List<Horario> getHorarios() {
        String sql = "SELECT * FROM horarios";

        List<Horario> horarios = new ArrayList<>();
        try {
            createConexion();
            Statement stmt = cnn.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                horarios.add(new Horario(result.getInt("id_estudiante"), result.getInt("id_curso"), result.getDate("createdAt"), result.getDate("updatedAt"), result.getDate("deletedAt")));
            }
            stmt.close();
            result.close();
            return horarios;
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
