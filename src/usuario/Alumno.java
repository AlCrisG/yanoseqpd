package usuario;

import java.util.ArrayList;
import java.util.Scanner;

import escuela.Carrera;
import escuela.Escuela;
import escuela.Grupo;
import escuela.Semestre;
import usuario.utils.CarreraEnum;
import usuario.utils.DatosComun;
import usuario.utils.GrupoEnum;
import usuario.utils.Rol;

public class Alumno extends Persona{
    private CarreraEnum carrera;
    private Semestre semestre;
    private Grupo grupo;
    private double promedio;
    private String numControl;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno, String fecha, String genero, String estado, String ciudad, String direccion,
    String nombreUsuario, String contrasena, Rol rol, CarreraEnum carrera, Grupo grupo){
        super(nombre, apellidoPaterno, apellidoMaterno, fecha, genero, estado, ciudad, direccion, nombreUsuario, contrasena, Rol.Alumno);
        this.carrera = carrera;
        this.grupo = grupo;
    }

    public static void agregarAlumno(CarreraEnum carreraEnum){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun();
        String nombre = datosComun.get(0);
        String apellidoPaterno = datosComun.get(1);
        String apellidoMaterno = datosComun.get(2);
        String fecha = datosComun.get(3);
        String genero = datosComun.get(4);
        String estado = datosComun.get(5);
        String ciudad = datosComun.get(6);
        String direccion = datosComun.get(7);
        String nombreUsuario = datosComun.get(8);
        String contrasena = datosComun.get(9);

        CarreraEnum carrera = carreraEnum;

        Grupo grupo = null;
        
        Alumno alumno = new Alumno(nombre, apellidoPaterno, apellidoMaterno, fecha, genero, estado, ciudad, direccion, nombreUsuario, contrasena, 
        Rol.Alumno, carrera, grupo);
        Escuela.usuarios.get(Rol.Alumno).add(alumno);
        alumno.setNumControl(generarNumControl(alumno));
    }

    public static String generarNumControl(Alumno alumno){
        String letraNombre = Character.toString(alumno.getNombre().charAt(0));
        String digitosAnio = Integer.toString(alumno.getFechaRegistro().getYear());
        digitosAnio = digitosAnio.substring(2);
        String abreviacion = "";
        switch(alumno.getCarrera()){
            case Sistemas -> abreviacion = "ISC";
            case Materiales -> abreviacion = "IMAT";
            case Electronica -> abreviacion = "ELC";
        }
        String indice = Integer.toString(alumno.getId());

        return "l" + letraNombre + digitosAnio + abreviacion + indice;
    }

    public CarreraEnum getCarrera(){
        return carrera;
    }

    private void setNumControl(String numControl){
        this.numControl = numControl;
    }
}
