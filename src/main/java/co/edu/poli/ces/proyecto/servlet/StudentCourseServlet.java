package co.edu.poli.ces.proyecto.servlet;

import co.edu.poli.ces.proyecto.dao.AuxStudentCourses;
import co.edu.poli.ces.proyecto.dao.Student;
import co.edu.poli.ces.proyecto.dao.Course;
import co.edu.poli.ces.proyecto.dao.Schedule;
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

@WebServlet(name = "studentCourseServlet", value = "/students")
public class StudentCourseServlet extends HttpServlet {
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
        List<Course> listCourse = cnn.getCursos();
        List<Schedule> listSchedule = cnn.getHorarios();
        List<AuxStudentCourses> studentsWithCourses = new ArrayList<>();

        for (Student student : listStudents){
            AuxStudentCourses auxStudentCourses = new AuxStudentCourses();
            auxStudentCourses.setStudent(student);
            for (Schedule schedule : listSchedule){
                if (student.getId() == schedule.getId_student()){
                    for (Course course : listCourse){
                        if (course.getId() == schedule.getId_course()){
                            auxStudentCourses.addCourse(course);
                        }
                    }
                }
            }
            studentsWithCourses.add(auxStudentCourses);
        }


        out.print(gson.toJson(studentsWithCourses));
        out.flush();
    }

}
