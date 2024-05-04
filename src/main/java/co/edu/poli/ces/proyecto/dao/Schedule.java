package co.edu.poli.ces.proyecto.dao;

import java.util.Date;

public class Schedule {

    // *************************
    // **   CLASS ATTRIBUTES  **
    // *************************

    private int id_student;
    private int id_course;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // **********************************
    // ** SOBRECARGA DE CONSTRUCTORES  **
    // **********************************

    public Schedule() {;
    }

    public Schedule(int id_student, int id_course, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id_student = id_student;
        this.id_course = id_course;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Schedule(int id_student, int id_course) {
        this.id_student = id_student;
        this.id_course = id_course;
    }


    // *************************
    // ** GETTER AND SETTERS  **
    // *************************


    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id_student=" + id_student +
                ", id_course=" + id_course +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
