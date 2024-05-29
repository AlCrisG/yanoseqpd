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

    public CarreraEnum getNombreCarrera(){
        return nombreCarrera;
    }

    public Semestre getPrimerSemestre(){
        return semestres.get(0);
    }
}