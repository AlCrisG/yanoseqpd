package escuela;

import java.util.Scanner;
import usuario.Persona;
import escuela.menu.MenuAlumno;
import escuela.menu.MenuMaestro;
import escuela.menu.MenuCoordinador;
import usuario.utils.UsuarioEnSesion;
public class EscuelaSistema {
    public static Scanner leerNum = new Scanner(System.in);
    public static Scanner leerCad = new Scanner(System.in);
    Escuela escuela = new Escuela();

    public void iniciarSesionSistema(){
        System.out.println("Inicia sesión para continuar");

        System.out.println("Ingresa tu usuario: ");
        String usuario = leerCad.nextLine();

        System.out.println("Ingresa tu contraseña: ");
        String contra = leerCad.nextLine();

        Persona usuarioActual = escuela.verificarInicioSesion(usuario, contra);

        if (usuarioActual != null) {
            UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
            seleccionarMenu();
        } else {
            System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo.");
            seleccionarMenu();
        }
    }


    private void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case Alumno:
                MenuDelAlumno();
                break;
            case Profesor:
                MenuDelMaestro();
                break;
            case Coordinador:
                MenuDelCoordinador();
                break;
            
        }
    }

    public void MenuDelMaestro(){
        MenuMaestro.mostrarMenuMaestro();
    }

    public void MenuDelAlumno(){
        MenuAlumno.mostrarMenuAlumno();
    }
    
    public void MenuDelCoordinador(){
        MenuCoordinador.mostrarMenuCoordinador();
    }

}