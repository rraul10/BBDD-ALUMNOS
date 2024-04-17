package estudiante.mappers

import database.Estudiante
import estudiante.models.Estudiantes
import java.time.LocalDateTime


fun Estudiante.toEstudiante(): Estudiantes {
    return Estudiantes(
        id = this.id,
        nombre = this.nombre,
        createAt = LocalDateTime.parse(this.created_at),
        isDeleted = this.is_deleted.toInt() == 1
    )
}

fun Estudiante.toEstudianteDto(): EstudiantesDto {
    return EstudiantesDto(
        id = this.id,
        nombre = this.nombre,
        createAt = this.createAt.toString(),
        isDeleted = this.isDeleted
    )
}