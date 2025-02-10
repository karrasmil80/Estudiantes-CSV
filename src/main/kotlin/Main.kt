package org.example

import kkarrasmil80.mappers.toModel
import org.example.models.EstudianteDTO
import java.io.File

fun main() {

    val file = File("data", "alumnos.csv")
    if (file.exists() && file.isFile && file.canRead()) {
        println("File exist")
    } else {
        throw IllegalArgumentException("File does not exist")
    }

    val estudiante = file.readLines().drop(1) // Eliminamos la cabecera
        .map { it.split(',') } // Añadimos un delimitador
        .map { item -> EstudianteDTO (
            id = item[0].toLong(),
            nombre = item[1],
            createdAt = item[2],
            tipo = item[3],
            edad = item[4].toInt()
        ).toModel()
    }
    estudiante.forEach {
        println(it)
    }

    // estudiante mas mayor
    val estudianteMasMayor = estudiante.maxBy {
        it.edad }
    println("estudiante mas mayor: $estudianteMasMayor")

    // estudiante más joven
    val estudianteMasJoven = estudiante.minBy {
        it.edad }
    println("estudiante mas joven: $estudianteMasJoven")

    // Media de edad estudiante
    val mediaEdadEstudiantes = estudiante.map {
        it.edad }.average().toInt()
    println("media edades de estudiantes: $mediaEdadEstudiantes")

    // Media de longitud de nombre
    val mediaLongitudNombre = estudiante.map {
        it.nombre.length }.average().toString()
    println("media longitud de nombre: $mediaLongitudNombre")

    // Lista de estudiantes agrupados por edad
    val listaAgrupadaPorEdad = estudiante.groupBy {
        it.edad }
    println("Estudiantes agrupados por edad: $listaAgrupadaPorEdad")

    // Lista de alumnos agrupados por y edad y número de alumnos
    val listaAgrupadaEdadYNombre = estudiante.groupingBy {
        it.edad }.eachCount()
    println("Estudiantes agrupados y numero de alumnos $listaAgrupadaEdadYNombre")

}
