package ud22.patron_MVC2;

import controllers.ControllerCliente;
import models.ModelCliente;
import views.ViewTable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ViewTable viewTable = new ViewTable();
        
        ControllerCliente controller = new ControllerCliente(viewTable);
        controller.startView();
    }
}
