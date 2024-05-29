package escuela.menu;

import java.util.Scanner;

import usuario.Alumno;
import usuario.Coordinador;
import usuario.Profesor;
import usuario.utils.UsuarioEnSesion;

public class MenuCoordinador {
    

    private static Scanner leerNum = new Scanner(System.in);

    public static void mostrarMenuCoordinador(){
        Coordinador coordinador = (Coordinador) UsuarioEnSesion.getInstancia().getUsuarioActual();
        int opcion = 0;

        do{
            System.out.println("+---------------------------------+");
            System.out.println("|   MENÚ COORDINADOR ISC MINDBOX  |");
            System.out.println("+---------------------------------+");
            System.out.println("|   OPCIÓN   |    DESCRIPCION     |");
            System.out.println("+---------------------------------+");
            System.out.println("|     1      | Registrar          |");
            System.out.println("|     2      | Modificar          |");
            System.out.println("|     3      | Consultar          |");
            System.out.println("|     4      | Eliminar           |");
            System.out.println("|     5      | Cerrar sesión      |");
            System.out.println("+---------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = leerNum.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU REGISTRAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    System.out.println("|   1    | Alumnos        |");
                    System.out.println("|   2    | Maestro        |");
                    System.out.println("|   3    | Calificaciones |");
                    System.out.println("|   4    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionRegistrar = leerNum.nextInt();

                    switch(opcionRegistrar){
                        case 1:
                            Alumno.agregarAlumno(coordinador.getCarreraEnum());
                            break;
                        
                        case 2:
                            Profesor.agregarProfesor(coordinador.getCarreraEnum());
                            break;

                        case 3:
                            System.out.println("met agregar una calificacion");
                            break;

                        case 4:
                            break;
                        
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
///////////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU MODIFICAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    System.out.println("|   1    | Alumnos        |");
                    System.out.println("|   2    | Maestros       |");
                    System.out.println("|   3    | Calificaciones |");
                    System.out.println("|   4    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionModificar = leerNum.nextInt();

                    switch(opcionModificar){
                        case 1:
                            System.out.println("met modificar cliente");
                            break;

                        case 2:
                            System.out.println("met modificar maestro");
                            break;

                        case 3:
                            System.out.println("met modificar calificaciones");
                            break;

                        case 4:
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;  
//////////////////////////////////////////////////////////////////////////////////////////////////////                    
                case 3:
                System.out.println("+-------------------------+");
                System.out.println("|     MENU CONSULTAR      |");
                System.out.println("+-------------------------+");
                System.out.println("| OPCION | DESCRIPCION    |");
                System.out.println("+-------------------------+");
                System.out.println("|   1    | Alumnos        |");
                System.out.println("|   2    | Maestros       |");
                System.out.println("|   3    | Calificaciones |");
                System.out.println("|   4    | Grupos         |");
                System.out.println("|   5    | Regresar       |");
                System.out.println("+------------------------+");
                System.out.print("Elige una opción: ");
                int opcionConsultar = leerNum.nextInt();
                int consultar = 0;

                if(opcionConsultar < 5 && opcionConsultar > 0){
                    System.out.println("+-------------------------+");
                    System.out.println("|     MENU CONSULTAR      |");
                    System.out.println("+-------------------------+");
                    System.out.println("| OPCION | DESCRIPCION    |");
                    System.out.println("+-------------------------+");
                    if (opcionConsultar != 3) {
                        System.out.println("|   1    | Todos          |");
                    }
                    if(opcionConsultar == 2 || opcionConsultar == 1){
                        System.out.println("|   2    | Por NC    |");
                    }
                    else if(opcionConsultar == 3){
                        System.out.println("|   1    | Por NC   |");
                    }
                    else{
                        System.out.println("|   2    | Buscar por NC  |");
                    }
                    System.out.println("|   3    | Regresar       |");
                    System.out.println("+------------------------+");
                    System.out.print("Elige una opción: ");
                    consultar = leerNum.nextInt();
                }

                switch(opcionConsultar){
                    //Consultar Alumnos
                    case 1:
                        switch (consultar) {
                            case 1:
                                System.out.println("met mostrar todos los alumnos");
                                break;

                            case 2:
                                System.out.println("met consultar alumno por nc");
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        break;
                    //Consultar Maestros
                    case 2:
                    switch (consultar) {
                        case 1:
                            System.out.println("met consultar todos los maestros");
                            break;

                        case 2:
                            System.out.println("met consultar maestros por nc");
                            break;

                        case 3:
                            break;
                        
                        default:
                            System.out.println("Opción no válida.");
                            break;
                        }
                    break;
                    //Consultar calificaciones
                    case 3:
                        switch (consultar) {
                            case 1:
                                System.out.println("met consultar calificaciones por nc");
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        break;
                    //Consultar grupos
                    case 4:
                        switch (consultar) {
                            case 1:
                                System.out.println("met consultar todos los grupos");
                                break;

                            default:
                                System.out.println("Opción no válida.");
                                break;
                        }
                        break;

                    case 5:
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                    break;  
////////////////////////////////////////////////////////////////////////////////////////////////////
                case 4:
                    System.out.println("+----------------------------+");
                    System.out.println("|        MENU ELIMINAR       |");
                    System.out.println("+----------------------------+");
                    System.out.println("|   OPCION | DESCRIPCION     |");
                    System.out.println("+----------------------------+");
                    System.out.println("|     1    | Alumnos         |");
                    System.out.println("|     2    | Maestros        |");
                    System.out.println("|     3    | Calificaciones  |");
                    System.out.println("|     4    | Regresar        |");
                    System.out.println("+----------------------------+");
                    System.out.print("Elige una opción: ");
                    int opcionEliminar = leerNum.nextInt();

                    switch(opcionEliminar){
                        case 1:
                            System.out.println("met eliminar alumnos");
                            break;

                        case 2:
                            System.out.println("met eliminar maestros");
                            break;

                        case 3:
                            System.out.println("met para borrar calificaciones");
                            break;

                        case 4:
                            break;
                            
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;

                default:
                    break;
            }

        }while(true);
    } 
}