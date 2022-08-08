package ud22.patron_MVC;

import controllers.ControllerCliente;
import models.ModelCliente;
import views.ViewCliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ModelCliente modelCliente = new ModelCliente();
        ViewCliente viewCliente = new ViewCliente();
        
        ControllerCliente controller = new ControllerCliente(modelCliente, viewCliente);
        controller.startView();
    }
}
