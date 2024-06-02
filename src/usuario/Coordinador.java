package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import escuela.Escuela;
import usuario.utils.CarreraEnum;
import usuario.utils.DatosComun;
import usuario.utils.Rfc;
import usuario.utils.Rol;

public class Coordinador extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
   
    private double salario;
    private String rfc;
    private CarreraEnum carrera;

    public Coordinador(String nombre, String primerApellido, String segundoApellido, String fecha, String genero, String ciudad, String estado,String direccion,double salario, Rol rol, String nombreUsuario, String contra, CarreraEnum carrera){
        super(nombre, primerApellido, segundoApellido, fecha, genero, ciudad, estado, direccion, nombreUsuario, contra, rol);
        this.salario = salario;
        this.carrera = carrera;
    }

    

    public String getRfc (){
        return rfc;
    }

    public void setRfc(String rfc){
        this.rfc = rfc;
    }

    public double getSalario(){
        return salario;
    }

    public CarreraEnum getCarreraEnum(){
        return carrera;
    }

    

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static void agregarCoordinador(CarreraEnum carreraEnum){
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

        System.out.println("Ingrese el salario del coordinador: ");
        Double salario = leerNumeros.nextDouble();

        
        Coordinador coordinador = new Coordinador(nombre, apellidoPaterno, apellidoMaterno, fecha, genero, ciudad, estado, direccion, salario, Rol.Coordinador, nombreUsuario, contrasena, carreraEnum);
        Escuela.usuarios.get(Rol.Coordinador).add(coordinador);
        coordinador.setRfc(Rfc.crearRfc(coordinador.getCurp()));
    }

    public static void mostrarInformacionTodosCoordinadores(){
        int cont = 0;
        if(Escuela.usuarios.get(Rol.Coordinador).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Escuela.usuarios.get(Rol.Coordinador)){
                Coordinador coordinador = (Coordinador) persona;
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de registro: %s%n", coordinador.getFechaRegistro());
                    cont++;
            }
            if(cont == 0){
                System.out.println("No se han agregado usuarios de dicho rol.");
            } else{
                System.out.println("======================================================");
            }
        }

    }

}
