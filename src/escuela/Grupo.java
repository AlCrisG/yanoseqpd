package escuela;

import java.util.ArrayList;

import usuario.Alumno;
import usuario.utils.GrupoEnum;

public class Grupo {
    private Carrera carrera;
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private GrupoEnum tipoGrupo;
    private int id;
    private ArrayList<Materia> materias = new ArrayList<>();
    private Semestre semestre;
}
