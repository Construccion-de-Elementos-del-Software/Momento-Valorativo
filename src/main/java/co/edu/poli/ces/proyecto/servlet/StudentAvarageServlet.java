package co.edu.poli.ces.proyecto.servlet;

import co.edu.poli.ces.proyecto.dao.Student;
import co.edu.poli.ces.proyecto.database.ConexionMysql;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentAvarageServlet", value = "/students-average-age")
public class StudentAvarageServlet extends HttpServlet  {

    private ConexionMysql cnn;
    private GsonBuilder gsonBuilder;
    private Gson gson;

    public void init()  {
        cnn = new ConexionMysql();
        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        List<Student> listStudents = cnn.getAlumnos();
        List<Student> studentsOlderAverageAge = new ArrayList<>();
        int sumAges = 0;
        int nStudentes = listStudents.size();

        for (Student student : listStudents){
            sumAges = sumAges + student.getAge();
        }

        double avarageAge = (double) sumAges / (double) nStudentes;
        System.out.println("Estudiantes: "+nStudentes);
        System.out.println("Suma de las edades: "+sumAges);
        System.out.println("Promedio: "+avarageAge);

        for (Student al: listStudents){
            if (al.getAge() > avarageAge) {
                studentsOlderAverageAge.add(al);
            }
        }


        out.print(gson.toJson(studentsOlderAverageAge));
        out.flush();
    }
}
