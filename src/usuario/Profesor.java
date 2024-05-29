package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import escuela.Escuela;
import usuario.utils.CarreraEnum;
import usuario.utils.DatosComun;
import usuario.utils.Rfc;
import usuario.utils.Rol;

public class Profesor extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
    private static Scanner leerCadenas = new Scanner(System.in);
    private static double salario;
    private String numControl;
    private String rfc;
    private CarreraEnum carrera;

    @SuppressWarnings("static-access")
	public Profesor(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado,
     String direccion,double salario, Rol rol, String nombreUsuario, String contra){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, rol);
        
        this.salario = salario;
   }

    public double getSalario(){
        return salario;
    }

    public CarreraEnum getCarreraEnum(){
        return carrera;
    }

    

    @SuppressWarnings("static-access")
	public void setSalario(double salario) {
        this.salario = salario;
    }


    public static String generarNumControl(Profesor profesor){
        String letraNombre = Character.toString(profesor.getNombre().charAt(0));
        String digitosAnio = Integer.toString(profesor.getFechaRegistro().getYear());
        digitosAnio = digitosAnio.substring(2);
        String abreviacion = "";
        switch(profesor.getCarrera()){
            case Sistemas -> abreviacion = "ISC";
            case Materiales -> abreviacion = "IMAT";
            case Electronica -> abreviacion = "ELC";
        }
        String indice = Integer.toString(profesor.getId());

        return "M" + letraNombre + digitosAnio + abreviacion + indice;
    }

    public CarreraEnum getCarrera(){
        return carrera;
    }

    private void setNumControl(String numControl){
        this.numControl = numControl;
    }

    public static void agregarProfesor(CarreraEnum carreraEnum){
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

        System.out.println("Ingrese el salario del profesor: ");
        Double salario = leerNumeros.nextDouble();

        
        Profesor profesor = new Profesor(nombre, apellidoPaterno, apellidoMaterno, fecha, genero, ciudad, estado, direccion, salario, Rol.Profesor, nombreUsuario, contrasena);
        Escuela.usuarios.get(Rol.Profesor).add(profesor);
        profesor.setNumControl(generarNumControl(profesor));
        profesor.setRfc(Rfc.crearRfc(profesor.getCurp()));
    }

    public void setRfc(String rfc){
        this.rfc = rfc;
    }
}
