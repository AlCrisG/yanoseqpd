package escuela;

import java.util.ArrayList;
import java.util.HashMap;

import usuario.Persona;
import usuario.utils.Rol;

public class Escuela {
    
    public static HashMap<Rol, ArrayList<Persona>> usuarios = new HashMap<>();

    public Escuela(){
        usuarios.put(Rol.Alumno, new ArrayList<>());
        usuarios.put(Rol.Profesor, new ArrayList<>());
        usuarios.put(Rol.Coordinador, new ArrayList<>());
    }

    public Persona verificarInicioSesion(String usuario,String contra){
        for(int i = 0; i < 3; i++){
            Rol rol = null;
            switch(i){
                case 0 -> rol = Rol.Alumno;
                case 1 -> rol = Rol.Profesor;
                case 2 -> rol = Rol.Coordinador;                
            }

            for(Persona usuarioActual : usuarios.get(rol)){
                if(usuarioActual.getNombreUsuario().equals(usuario)){
                    if(usuarioActual.getContra().equals(contra)){
                            return usuarioActual;
                    }
                }
            }
        }
        return null;
    }
}
