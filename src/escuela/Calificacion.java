package escuela;

import usuario.Alumno;

public class Calificacion {
    private Alumno alumno;
    private Materia materia;
    private int calificacion;

    public Calificacion(Alumno alumno, Materia materia, int calificacion){
        this.alumno = alumno;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    
    
}
