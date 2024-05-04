package co.edu.poli.ces.proyecto.dao;

import java.util.Date;

public class Horario {

    // ******************************
    // **   ATRIBUTOS DE LA CLASE  **
    // ******************************

    private int id_estudiante;
    private int id_curso;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    // **********************************
    // ** SOBRECARGA DE CONSTRUCTORES  **
    // **********************************

    public Horario() {;
    }

    public Horario(int id_estudiante, int id_curso, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Horario(int id_estudiante, int id_curso) {
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
    }


    // *************************
    // ** GETTER AND SETTERS  **
    // *************************


    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
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
        return "Horario{" +
                "id_estudiante=" + id_estudiante +
                ", id_curso=" + id_curso +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
