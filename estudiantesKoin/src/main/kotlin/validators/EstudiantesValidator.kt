package validators

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import estudiante.errors.EstudiantesError
import estudiante.models.Estudiantes


class EstudiantesValidator {
    fun validate(estudiantes: Estudiantes): Result<Estudiantes, EstudiantesError> {
        return when {
            estudiantes.nombre.isBlank() -> Err(EstudiantesError.EstudianteNoValido("EL nombre no es correcto"))
            estudiantes.calificación <= 3 -> Err(EstudiantesError.EstudianteNoValido("La calificación no esta aprobada"))
            else -> Ok(estudiantes)
        }
    }
}