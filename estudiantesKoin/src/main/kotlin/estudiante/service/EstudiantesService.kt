package estudiante.service

import database.Estudiante
import estudiante.errors.EstudiantesError
import com.github.michaelbull.result.Result


interface PersonasService {
    fun getAll(): Result<List<Estudiante>, EstudiantesError>
    fun getById(id: Long): Result<Estudiante, EstudiantesError>
    fun create(producto: Estudiante): Result<Estudiante, EstudiantesError>
    fun update(id: Long, producto: Estudiante): Result<Estudiante, EstudiantesError>
    fun delete(id: Long): Result<Estudiante, EstudiantesError>
}