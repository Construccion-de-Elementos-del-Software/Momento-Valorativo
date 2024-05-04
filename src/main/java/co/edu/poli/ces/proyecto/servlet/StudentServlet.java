package co.edu.poli.ces.proyecto.servlet;

import co.edu.poli.ces.proyecto.dao.Alumno;
import co.edu.poli.ces.proyecto.dao.Curso;
import co.edu.poli.ces.proyecto.dao.Horario;
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
import java.util.List;

@WebServlet(name = "studentServlet", value = "/students")
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
        List<Alumno> listAlumnos = cnn.getAlumnos();
        List<Curso> listCurso = cnn.getCursos();
        List<Horario> listHorario = cnn.getHorarios();
        out.print(gson.toJson(listAlumnos));
        out.flush();
    }

}
