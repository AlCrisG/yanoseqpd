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

    public Grupo(Carrera carrera, ArrayList<Alumno> alumnos, GrupoEnum tipoGrupo, int id, ArrayList<Materia> materias,Semestre semestre) {
        this.carrera = carrera;
        this.alumnos = alumnos;
        this.tipoGrupo = tipoGrupo;
        this.id = id;
        this.materias = materias;
        this.semestre = semestre;
    }

    
}
