package com.aluracursos.literalura.informations;

import java.util.List;

public record AutorInformation(
        Long id,
        String nombre,
        String fechaNacimiento,
        String fechaFallecimiento
) {
}
