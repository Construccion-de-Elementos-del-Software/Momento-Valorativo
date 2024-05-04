package co.edu.poli.ces.proyecto.dao;

import java.util.Date;

public class Course {
    // *************************
    // **   CLASS ATTRIBUTES  **
    // *************************
    private int id;
    private String name_course;
    private String teacher;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // **********************************
    // ** SOBRECARGA DE CONSTRUCTORES  **
    // **********************************

    public Course() {
    }

    public Course(int id, String name_course, String teacher, String description, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.name_course = name_course;
        this.teacher = teacher;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Course(int id, String name_course, String teacher, String description) {
        this.id = id;
        this.name_course = name_course;
        this.teacher = teacher;
        this.description = description;
    }

    // *************************
    // ** GETTER AND SETTERS  **
    // *************************


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Course{" +
                "id=" + id +
                ", name_course='" + name_course + '\'' +
                ", teacher='" + teacher + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
