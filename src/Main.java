import escuela.menu.MenuAlumno;
import escuela.utils.SemestreEnum;
import usuario.utils.CarreraEnum;

public class Main{

    public static void main(String[] args) {        
        MenuAlumno.mostrarMaterias(CarreraEnum.Sistemas, SemestreEnum.II);

    }
}