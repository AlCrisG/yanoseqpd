package escuela;

import java.util.ArrayList;

public class Semestre {
    private int id;
    private int numeroSemestre;
    private Carrera carrera;
    private ArrayList<Grupo> grupos = new ArrayList<>();


    public Semestre(int id, int numeroSemestre, Carrera carrera){
        this.id = id;
        this.numeroSemestre = numeroSemestre;
        this.carrera = carrera;
    }


    public int getId() {
        return id;
    }


    public int getNumeroSemestre() {
        return numeroSemestre;
    }


    public Carrera getCarrera() {
        return carrera;
    }


    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    
}
