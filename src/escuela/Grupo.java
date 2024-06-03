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

    public Grupo(Carrera carrera, GrupoEnum tipoGrupo, int id,Semestre semestre) {
        this.carrera = carrera;
        this.tipoGrupo = tipoGrupo;
        this.id = id;
        this.semestre = semestre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public GrupoEnum getTipoGrupo() {
        return tipoGrupo;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void agregarAlumno(Alumno alumno){
        if (alumnos.size()<20) {
            alumnos.add(alumno);
        }else{
            System.out.println("El grupo esta lleno");
        }
    }
    
}
