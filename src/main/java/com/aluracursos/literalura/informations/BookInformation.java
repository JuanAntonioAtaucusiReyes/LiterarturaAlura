package com.aluracursos.literalura.informations;


import java.util.List;

public record BookInformation(
        Long id,
        String titulo,
        List<AutorInformation> autores,
        String idiomas,
        Double numeroDeDescargas
) {

}
