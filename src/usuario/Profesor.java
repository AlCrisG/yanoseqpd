package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import escuela.Escuela;
import usuario.utils.CarreraEnum;
import usuario.utils.DatosComun;
import usuario.utils.Rfc;
import usuario.utils.Rol;

public class Profesor extends Persona{
    private static Scanner leerNumeros = new Scanner(System.in);
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

    public String getNumControl (){
        return numControl;
    }

    public String getRfc (){
        return rfc;
    }

    
    public static void mostrarInformacionTodosMaestros(CarreraEnum carreraEnum){
        int cont = 0;
        if(Escuela.usuarios.get(Rol.Profesor).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Escuela.usuarios.get(Rol.Profesor)){
                Profesor profesor = (Profesor) persona;
                if(profesor.getCarreraEnum() == carreraEnum){
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de registro: %s%n", profesor.getFechaRegistro());
                    cont++;
                }
            }
            if(cont == 0){
                System.out.println("No se han agregado usuarios de dicho rol.");
            } else{
                System.out.println("======================================================");
            }
        }

    }


    public static void consultarMaestroPorNC( CarreraEnum carreraEnum) {
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del maestro a consultar: ");
        String numControl = leerCadenas.nextLine();

        for (Persona usuario : Escuela.usuarios.get(Rol.Profesor)) {
            if (usuario instanceof Profesor && ((Profesor)usuario).getNumControl() == numControl && ((Profesor)usuario).getCarreraEnum().equals(carreraEnum)) {
                Profesor profesor = (Profesor) usuario;
                System.out.println("ID: " + profesor.getId());
                System.out.println("NC: "+ profesor.getNumControl());
                System.out.println("Nombre: " + profesor.getNombre());
                System.out.println("Apellido: " + profesor.getPrimerApellido());
                System.out.println("Ciudad: " + profesor.getCiudad());
                System.out.println("Fecha de registro: "+ profesor.getFechaRegistro());
                return; 
            }
        }
        System.out.println("No se encontró ningún profesor con ese numero de control en la carrera.");
    }


    public static void modificarMaestro(CarreraEnum carreraEnum) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del Alumno a modificar: ");
        String ncProfesorModif = leerCadenas.nextLine();
        boolean profesorEncontrado = false;
        Profesor profesorModificado = null;
    
        
        for (Persona usuario : Escuela.usuarios.get(Rol.Profesor)) {
            
            if (usuario instanceof Profesor && ((Profesor)usuario).getNumControl() == ncProfesorModif && ((Profesor)usuario).getCarreraEnum().equals(carreraEnum)) {
                Profesor profesor = (Profesor) usuario;
                if (profesor.getNumControl() == ncProfesorModif) {
                    profesorEncontrado = true;
                    profesorModificado = profesor;
                    break; 
                }
            }
        }
    
        if (profesorEncontrado) {
            System.out.println("Elija la opción que desea modificar: ");
            System.out.println("1.- Nombre ");
            System.out.println("2.- Apellido ");
            System.out.println("3.- Segundo apellido ");
            System.out.println("4.- Nombre de usuario");
            System.out.println("5.- Contraseña ");
            int opcion = leerNumeros.nextInt();
    
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    String nuevoNombre = leerCadenas.nextLine();
                    profesorModificado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el apellido: ");
                    String nuevoApellido = leerCadenas.nextLine();
                    profesorModificado.setPrimerApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese el segundo apellido: ");
                    String nuevoApellido2 = leerCadenas.nextLine();
                    profesorModificado.setSegundoApellido(nuevoApellido2);
                    break;
                case 4:
                    profesorModificado.setNombreUsuario(DatosComun.obtenerNombreUsuario());
                    break;
                case 5:
                    System.out.println("Ingrese la contraseña: ");
                    String nuevaContra = leerCadenas.nextLine();
                    profesorModificado.setContra(nuevaContra);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
    
        } else {
            System.out.println("No se ha encontrado profesor con ese NC...");
        }
    }

    public static void eliminarMaestro(CarreraEnum carreraEnum){
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del maestro para eliminar: ");
        String ncProfesorEliminar = leerCadenas.nextLine();
        Boolean respuestaCorrecta = false;
        Profesor profesorEncontrado=null;

        for (Persona usuario : Escuela.usuarios.get(Rol.Profesor)) {
            Profesor profesor = (Profesor) usuario;
            if (usuario instanceof Profesor && ((Profesor)usuario).getNumControl() == ncProfesorEliminar && ((Profesor)usuario).getCarreraEnum().equals(carreraEnum)) {
                respuestaCorrecta = true;
                profesorEncontrado=profesor;                
            }
        }

        if (respuestaCorrecta) {
            System.out.println("\nProfesor eliminado.\n");
                Escuela.usuarios.get(Rol.Profesor).remove(profesorEncontrado);
        }else{
            System.out.println("No pudo eliminarse al profesor.");
        }
                
    }
}
