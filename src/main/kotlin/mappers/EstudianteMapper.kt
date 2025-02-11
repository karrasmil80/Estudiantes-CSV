package kkarrasmil80.mappers

import org.example.models.Estudiante
import org.example.models.EstudianteDTO
import org.example.models.Tipo
import java.time.LocalDate

fun Estudiante.toDto() = EstudianteDTO(
    id = id,
    nombre = nombre,
    tipo = tipo.toString(),
    edad = edad,
    createdAt = createdAt.toString()
)

fun EstudianteDTO.toModel() = Estudiante(
    id = id,
    nombre = nombre,
    tipo = Tipo.valueOf(tipo.uppercase()),
    edad = edad,
    createdAt = LocalDate.parse(createdAt)
)