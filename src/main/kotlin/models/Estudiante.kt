package org.example.models

import java.time.LocalDateTime

// Clase con los parámetros del estudiante
data class Estudiante (
    val id: Long,
    val nombre: String,
    val tipo: Tipo,
    val edad: Int,
    val createdAt: LocalDateTime,
) {
}

// Tipos
enum class Tipo {
    ALUMNO
}