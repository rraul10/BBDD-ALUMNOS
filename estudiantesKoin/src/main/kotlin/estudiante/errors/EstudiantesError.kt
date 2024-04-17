package estudiante.errors

sealed class EstudiantesError(val message:String) {
    class EstudianteNoEncontrado(message: String) : EstudiantesError(message)
    class EstudianteNoValido(message: String) : EstudiantesError(message)
    class EstudianteNoActualizado(message: String) : EstudiantesError(message)
    class EstudianteNoEliminado(message: String) : EstudiantesError(message)
}