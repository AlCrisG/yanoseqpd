package escuela;

import java.time.LocalDate;
import java.util.ArrayList;

import usuario.Coordinador;
import usuario.utils.CarreraEnum;

public class Carrera{
    private int id;
    private CarreraEnum nombreCarrera;
    private int cantidadGrupos;
    private int cantidadAlumnos;
    private int cantidadMaterias;
    private LocalDate fechaCreacion;
    private Coordinador coordinador;
    public ArrayList<Semestre> semestres = new ArrayList<>();

    

    public Carrera(int id, CarreraEnum nombreCarrera, int cantidadGrupos, int cantidadAlumnos, int cantidadMaterias,LocalDate fechaCreacion, Coordinador coordinador) {
        this.id = id;
        this.nombreCarrera = nombreCarrera;
        this.cantidadGrupos = cantidadGrupos;
        this.cantidadAlumnos = cantidadAlumnos;
        this.cantidadMaterias = cantidadMaterias;
        this.fechaCreacion = fechaCreacion;
        this.coordinador = coordinador;
    }

    public CarreraEnum getNombreCarrera(){
        return nombreCarrera;
    }

    public Semestre getPrimerSemestre(){
        return semestres.get(0);
    }

    public int getId() {
        return id;
    }

    public int getCantidadGrupos() {
        return cantidadGrupos;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }

    
}