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

public class StudentServlet1 {
    @WebServlet(name = "studentAvarageServlet", value = "/students-average-age")
    public class StudentServlet extends HttpServlet {
        private ConexionMysql cnn;
        //JSON
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
            List<Student> alumnosMayoresPromedio = new ArrayList<>();
            int sumEdades = 0;
            int nEstudiantes = listStudents.size();

            for (Student student : listStudents){
                sumEdades = sumEdades + student.getEdad();
            }

            double promedioEdades = sumEdades / nEstudiantes;


            for (Student al: listStudents){
                if (al.getEdad() > promedioEdades) {
                    alumnosMayoresPromedio.add(al);
                }
            }


            out.print(gson.toJson(alumnosMayoresPromedio));
            out.flush();
        }

    }

}
