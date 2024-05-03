package co.edu.poli.ces.proyecto.dao;

import java.util.Date;

public class Curso {
    // ******************************
    // **   ATRIBUTOS DE LA CLASE  **
    // ******************************
    private int id;
    private String nombre_curso;
    private String profesor;
    private String descripcion;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // **********************************
    // ** SOBRECARGA DE CONSTRUCTORES  **
    // **********************************

    public Curso() {
    }

    public Curso(int id, String nombre_curso, String profesor, String descripcion) {
        this.id = id;
        this.nombre_curso = nombre_curso;
        this.profesor = profesor;
        this.descripcion = descripcion;
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

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "Curso{" +
                "id=" + id +
                ", nombre_curso='" + nombre_curso + '\'' +
                ", profesor='" + profesor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
