package estudiante.service

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import database.Estudiante
import estudiante.errors.EstudiantesError
import estudiante.repositories.EstudiantesRepository

class EstudiantesServiceImpl (
    private val EstudiantesRepository: EstudiantesRepository
) : PersonasService {
    override fun getAll(): Result<List<Estudiante>, EstudiantesError> {
        //logger.debug {"Obteniendo todos los estudiantes"}
        return Ok(EstudiantesRepository.findAll())
    }


    override fun getById(id: Long): Result<Estudiante, EstudiantesError> {
        //logger.debug {"Obteniendo estudiante por id: $id"}
        return EstudiantesRepository.findById(id)
            ?.let { Ok(it) }
            ?: Err(EstudiantesError.EstudianteNoEncontrado("Estudiante no encontrado con id: $id"))
    }

    override fun create(estudiantes: Estudiante): Result<Estudiante, EstudiantesError> {
        //logger.debug {"Guardando estudiante: $estudiante"}
        return Ok(EstudiantesRepository.save(estudiantes))
    }

    override fun update(id: Long, estudiantes: Estudiante): Result<Estudiante, EstudiantesError> {
        // logger.debug {"Actualizando estudiante por id: $id"}
        return EstudiantesRepository.update(id, estudiantes)
            ?.let { Ok(it) }
            ?: Err(EstudiantesError.EstudianteNoActualizado("Estudiante no actualizado con id: $id"))
    }

    override fun delete(id: Long): Result<Estudiante, EstudiantesError> {
        //logger.debug {"Borrando estudiante por id: $id"}
        return EstudiantesRepository.delete(id)
            ?.let { Ok(it) }
            ?: Err(EstudiantesError.EstudianteNoEliminado("Estudiante no eliminado con id: $id"))
    }

}