package estudiante.repositories

import database.Estudiante
import java.time.LocalDateTime
import database.service.SqlDeLightManager
import estudiante.mappers.toEstudiante


class EstudianteRepositoryImpl (
    private val dbManager: SqlDeLightManager
) : EstudiantesRepository {
    private val db = dbManager.databaseQueries

    override fun findAll(): List<Estudiante> {
        //logger.debug { "Buscando todos los estudiante" }
        return db.selectAllEstudiante().executeAsList().map { it.toEstudiante() }
    }

    override fun findById(id: Long): Estudiante? {
        //logger.debug { "Buscando estudiante por id: $id" }
        return db.selectEstudianteById(id).executeAsOneOrNull()?.toEstudiante()
    }

    override fun save(cliente: Estudiante): Estudiante {
        //logger.debug { "Guardando estudiante: $cliente" }

        val timeStamp = LocalDateTime.now().toString()

        db.transaction {
            db.insertEstudiante(
                nombre = cliente.nombre,
                created_at = timeStamp,
            )
        }

        return db.selectEstudianteLastInserted().executeAsOne().toEstudiante()
    }

    override fun update(id: Long, estudiante: Estudiante): Persona? {
        //logger.debug { "Actualizando cliente por id: $id" }
        var result = this.findById(id) ?: return null
        val timeStamp = LocalDateTime.now()
        result.nombre=estudiante.nombre
        result.isDeleted=estudiante.isDeleted


        db.updateEstudiante(
            nombre = result.nombre,
            is_deleted = if (result.isDeleted) 1 else 0,
            id = id,
        )
        return result
    }

    override fun delete(id: Long): Estudiante? {
        //logger.debug { "Borrando estudiante por id: $id" }
        val result = this.findById(id) ?: return null
        val timeStamp = LocalDateTime.now()
        db.updateEstudiante(
            nombre = result.nombre,
            is_deleted = 1,
            id = result.id,
        )
        result.isDeleted=true

        return result
    }

}