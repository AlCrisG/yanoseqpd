package escuela;

import java.util.ArrayList;
import java.util.HashMap;

import usuario.Coordinador;
import usuario.Persona;
import usuario.utils.CarreraEnum;
import usuario.utils.Rol;

public class Escuela {
    
    public static HashMap<Rol, ArrayList<Persona>> usuarios = new HashMap<>();
    public static ArrayList<Carrera> carreras = new ArrayList<>();

    public Escuela(){
        usuarios.put(Rol.Alumno, new ArrayList<>());
        usuarios.put(Rol.Profesor, new ArrayList<>());
        usuarios.put(Rol.Coordinador, new ArrayList<>());
        usuarios.get(Rol.Coordinador).add(new Coordinador("coor", "apcoor", "ap2coor","01/06/9090","M", "1", "Morelia", "direccion",12000,Rol.Coordinador,"c1","c1",CarreraEnum.Sistemas));
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

    public Carrera getCarrera(CarreraEnum carreraEnum){
        for(Carrera carrera : carreras){
            if(carrera.getNombreCarrera().equals(carreraEnum)){
                return carrera;
            }
        }
        return null;
    }
}
