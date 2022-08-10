package ud22.patron_MVC3;

import controllers.ControllerCientificos;
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
        
        ControllerCientificos controller = new ControllerCientificos(viewTable);
        controller.startView();
    }
}
