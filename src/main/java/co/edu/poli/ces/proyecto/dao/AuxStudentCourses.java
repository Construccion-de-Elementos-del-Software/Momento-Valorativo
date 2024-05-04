package co.edu.poli.ces.proyecto.dao;

import java.util.ArrayList;
import java.util.List;

public class AuxStudentCourses {
    // ************************************************************************
    // ** CLASE AUXILIAR PARA TENER ESTUDIANTES CON EL CURSO QUE ESTAN VIENDO *
    // ************************************************************************

    private Student student;
    private List<Course> courses = new ArrayList<>();

    public AuxStudentCourses( ) {

    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "AuxStudentCourses{" +
                "student=" + student +
                ", courses=" + courses +
                '}';
    }
}
