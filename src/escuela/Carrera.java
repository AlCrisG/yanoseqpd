package escuela;

import java.time.LocalDate;

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

    public CarreraEnum getNombreCarrera(){
        return nombreCarrera;
    }
}