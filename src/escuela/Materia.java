package escuela;

import usuario.Profesor;

public class Materia {
    private int id;
    private Carrera carrera;
    private Grupo grupo;
    private Profesor profesor;
    private String nombre;

    public Materia(int id, Carrera carrera, Grupo grupo, Profesor profesor, String nombre){
        this.id =id;
        this.carrera = carrera;
        this.grupo = grupo;
        this.nombre = nombre;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
