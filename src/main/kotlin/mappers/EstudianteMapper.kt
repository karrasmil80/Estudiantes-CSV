package kkarrasmil80.mappers

import org.example.models.Estudiante
import org.example.models.EstudianteDTO
import org.example.models.Tipo
import java.time.LocalDateTime

class EstudianteMapper {

    fun Estudiante.toModel() = Estudiante(
        id = id,
        nombre = nombre,
        tipo = Tipo.valueOf(tipo.name),
        edad = edad,
        createdAt = LocalDateTime.parse(createdAt.toString())
    )

    fun Estudiante.toDto() = EstudianteDTO (
        id = id,
        nombre = nombre,
        tipo = Tipo.valueOf(tipo.name).toString(),
        edad = edad,
        createdAt = LocalDateTime.parse(createdAt.toString()).toString()
    )
}