package ud22.patron_MVC;

import controllers.Controller;
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
        
        Controller controller = new Controller(modelCliente, viewCliente);
        controller.startView();
    }
}
