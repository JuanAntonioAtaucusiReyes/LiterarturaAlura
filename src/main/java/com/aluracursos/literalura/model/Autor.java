package com.aluracursos.literalura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaNacimiento;
    private String fechaFallecimiento;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Book> librosDelAutor = new ArrayList<>();

    public Autor() {};

    public Autor(InfoAutor infoAutor) {
        this.nombre = infoAutor.nombre();
        this.fechaNacimiento = infoAutor.fechaNacimiento();
        this.fechaFallecimiento = infoAutor.fechaFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Book> getLibrosDelAutor() {
        return librosDelAutor;
    }

    public void setLibrosDelAutor(List<Book> librosDelAutor) {
        this.librosDelAutor = librosDelAutor;
    }

    @Override
    public String toString() {
        return """
               **************************************************
               *                      AUTOR                     *
               **************************************************
               Autor: %s
               Fecha de Nacimiento: %s
               Fecha de Fallecimiento: %s
               Libros: %s
               """.formatted(nombre, fechaNacimiento, fechaFallecimiento, librosDelAutor) + "\n";
    }
}
