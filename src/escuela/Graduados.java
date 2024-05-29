package escuela;

import java.time.LocalDate;
import java.util.ArrayList;

import usuario.Alumno;

public class Graduados{
    private LocalDate fechaGraduacion;
    private Carrera carrera;
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private String generacion;
}