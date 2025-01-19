package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = "autores")
    Optional<Book> findByTitulo(String titulo);

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // Tengo dos formas de evitar la excepción: LazyInitializationException
    // Forma 1
    @Query("SELECT l FROM Libro l LEFT JOIN FETCH l.autores")
    List<Book> findAllWithAutores();

    // Forma 2
//    @EntityGraph(attributePaths = "autores")
//    List<Libro> findAll();
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @EntityGraph(attributePaths = "autores")
    List<Book> findByIdiomasContaining(String idiomas);

    List<Book> findTop10ByOrderByNumeroDeDescargasDesc();
}
