package usuario;
import java.util.ArrayList;
import java.util.Scanner;

import escuela.Escuela;
import escuela.Grupo;
import escuela.Semestre;
import usuario.utils.CarreraEnum;
import usuario.utils.DatosComun;

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

    

    public void setCarreraEnum(CarreraEnum carrera) {
        this.carrera = carrera;
    }



    public Semestre getSemestre() {
        return semestre;
    }



    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }



    public Grupo getGrupo() {
        return grupo;
    }



    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }



    public double getPromedio() {
        return promedio;
    }



    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }



    public String getNumControl() {
        return numControl;
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
        switch(alumno.getCarreraEnum()){
            case Sistemas -> abreviacion = "ISC";
            case Materiales -> abreviacion = "IMAT";
            case Electronica -> abreviacion = "ELC";
        }
        String indice = Integer.toString(alumno.getId());

        return "l" + letraNombre + digitosAnio + abreviacion + indice;
    }

    public CarreraEnum getCarreraEnum(){
        return carrera;
    }

    private void setNumControl(String numControl){
        this.numControl = numControl;
    }

    


    public static void mostrarInformacionTodosAlumnos(CarreraEnum carreraEnum){
        int cont = 0;
        if(Escuela.usuarios.get(Rol.Alumno).isEmpty()){
            System.out.println("No se han agregado usuarios de dicho rol.");
        }
        else{
            for(Persona persona : Escuela.usuarios.get(Rol.Alumno)){
                Alumno alumno = (Alumno) persona;
                if(alumno.getCarreraEnum() == carreraEnum){
                    Persona.mostrarInformacion(persona);
                    System.out.printf("Fecha de registro: %s%n", alumno.getFechaRegistro());
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

    public static void consultarAlumnoPorNC( CarreraEnum carreraEnum) {
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del alumno a consultar: ");
        String numControl = leerCadenas.nextLine();

        for (Persona usuario : Escuela.usuarios.get(Rol.Alumno)) {
            if (usuario instanceof Alumno && ((Alumno)usuario).getNumControl() == numControl && ((Alumno)usuario).getCarreraEnum().equals(carreraEnum)) {
                Alumno alumno = (Alumno) usuario;
                System.out.println("ID: " + alumno.getId());
                System.out.println("NC: "+ alumno.getNumControl());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getPrimerApellido());
                System.out.println("Ciudad: " + alumno.getCiudad());
                System.out.println("Fecha de registro: "+ alumno.getFechaRegistro());
                return; 
            }
        }
        System.out.println("No se encontró ningún alumno con ese Numero de control en la carrera.");
    }



    public CarreraEnum getCarrera() {
        return carrera;
    }


    public static void modificarAlumno(CarreraEnum carreraEnum) {
        @SuppressWarnings("resource")
        Scanner leerNumeros = new Scanner(System.in);
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del Alumno a modificar: ");
        String ncAlumnoModif = leerCadenas.nextLine();
        boolean alumnoEncontrado = false;
        Alumno alumnoModificado = null;
    
        
        for (Persona usuario : Escuela.usuarios.get(Rol.Alumno)) {
            
            if (usuario instanceof Alumno && ((Alumno)usuario).getNumControl() == ncAlumnoModif && ((Alumno)usuario).getCarreraEnum().equals(carreraEnum)) {
                Alumno alumno = (Alumno) usuario;
                if (alumno.getNumControl() == ncAlumnoModif) {
                    alumnoEncontrado = true;
                    alumnoModificado = alumno;
                    break; 
                }
            }
        }
    
        if (alumnoEncontrado) {
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
                    alumnoModificado.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el apellido: ");
                    String nuevoApellido = leerCadenas.nextLine();
                    alumnoModificado.setPrimerApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese el segundo apellido: ");
                    String nuevoApellido2 = leerCadenas.nextLine();
                    alumnoModificado.setSegundoApellido(nuevoApellido2);
                    break;
                case 4:
                    alumnoModificado.setNombreUsuario(DatosComun.obtenerNombreUsuario());
                    break;
                case 5:
                    System.out.println("Ingrese la contraseña: ");
                    String nuevaContra = leerCadenas.nextLine();
                    alumnoModificado.setContra(nuevaContra);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
    
        } else {
            System.out.println("No se ha encontrado alumno con ese NC...");
        }
    }

    public static void eliminarAlumno(CarreraEnum carreraEnum){
        @SuppressWarnings("resource")
        Scanner leerCadenas = new Scanner(System.in);

        System.out.println("Ingrese el NC del alumno para eliminar: ");
        String ncAlumnoEliminar = leerCadenas.nextLine();
        Boolean respuestaCorrecta = false;
        Alumno alumnoEncontrado=null;

        for (Persona usuario : Escuela.usuarios.get(Rol.Alumno)) {
            Alumno alumno = (Alumno) usuario;
            if (usuario instanceof Alumno && ((Alumno)usuario).getNumControl() == ncAlumnoEliminar && ((Alumno)usuario).getCarreraEnum().equals(carreraEnum)) {
                respuestaCorrecta = true;
                alumnoEncontrado=alumno;                
            }
        }

        if (respuestaCorrecta) {
            System.out.println("\nAlumno eliminado.\n");
                Escuela.usuarios.get(Rol.Alumno).remove(alumnoEncontrado);
        }else{
            System.out.println("No pudo eliminarse al alumno.");
        }
                
    }  
}
