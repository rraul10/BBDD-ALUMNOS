package database.DemoData

import estudiante.models.Estudiantes


fun initDemoEstudiantes() = listOf(
    Estudiantes(nombre = "Raúl", calificación = 5, id = 100),
    Estudiantes(nombre = "Yahya", calificación = 8, id = 432),
    Estudiantes(nombre = "Samuel", calificación = 7, id = 121)
)
