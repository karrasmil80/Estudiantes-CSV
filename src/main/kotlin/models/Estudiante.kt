package org.example.models

import java.time.LocalDate

// Clase con los parámetros del estudiante
data class Estudiante(
    val id: Long,
    val nombre: String,
    val tipo: Tipo,
    val edad: Int,
    val createdAt: LocalDate,
) {
}

// Tipos
enum class Tipo {
    ALUMNO
}