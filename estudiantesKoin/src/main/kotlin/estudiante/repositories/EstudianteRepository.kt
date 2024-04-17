package estudiante.repositories

import database.Estudiante

interface EstudiantesRepository {
    fun findAll(): List<Estudiante>
    fun findById(id: Long): Estudiante?
    fun save(cliente: Estudiante): Estudiante
    fun update(id: Long, cliente: Estudiante): Estudiante?
    fun delete(id: Long): Estudiante?
}