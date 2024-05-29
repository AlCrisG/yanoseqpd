package usuario;

import usuario.utils.Carrera;
import usuario.utils.Grupo;
import usuario.utils.Rol;

public class Alumno extends Persona{
    private Carrera carrera;
    private int semestre = 1;
    private Grupo grupo;
    private double promedio;
    private String numControl;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String fecha, String genero, String estado, String ciudad, String direccion, String nombreUsuario, String contrasena, Rol rol, Carrera carrera){
        super(nombre, apellidoPaterno, apellidoMaterno, fecha, genero, estado, ciudad, direccion, nombreUsuario, contrasena, Rol.Alumno);
        this.carrera = carrera;
    }
}
