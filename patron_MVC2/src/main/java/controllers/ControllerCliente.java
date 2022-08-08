package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelCliente;
import views.ViewTable;
import views.ViewFormCliente;

public class ControllerCliente {
	
	ViewTable viewTable;
	
	public ControllerCliente (ViewTable viewTable) {
		this.viewTable = viewTable;
		
		viewTable.addListenerBtnEditar(new ListenerEditarCliente(viewTable));
		viewTable.addListenerBtnBorrar(new ListenerBorrarCliente(viewTable));
		viewTable.addListenerBtnCrear(new ListenerCrearCliente(viewTable));
		viewTable.addListenerBtnCambiar(new ListenerCambiarCliente());
		
		viewTable.addComponentListener(new ComponentAdapter() {
			   public void componentHidden(ComponentEvent e) {
			      /* code run when component hidden*/
			   }
			   public void componentShown(ComponentEvent e) {
				   fillTable(viewTable);
			   }
			});
	}
	
	public void startView() {
		viewTable.setTitle("Cliente");
		viewTable.setLocationRelativeTo(null);
		viewTable.setVisible(true);
		
		fillTable(viewTable);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewTable) {
		ArrayList<ModelCliente> clientes = DBConection.getValuesClientes();
		viewTable.getTable().setModel((new DefaultTableModel(
				new Object[clientes.size()][6] ,
				new String[] {
					"id", "nombre", "apellido", "direccion", "dni", "fecha"
				}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			}));
		
		for(int i = 0; i < clientes.size(); i++) {
			viewTable.getTable().getModel().setValueAt(Integer.toString(clientes.get(i).getId()) , i, 0);
			viewTable.getTable().getModel().setValueAt(clientes.get(i).getNombre(), i, 1);
			viewTable.getTable().getModel().setValueAt(clientes.get(i).getApellido(), i, 2);
			viewTable.getTable().getModel().setValueAt(clientes.get(i).getDireccion(), i, 3);
			viewTable.getTable().getModel().setValueAt(clientes.get(i).getDni(), i, 4);
			viewTable.getTable().getModel().setValueAt(clientes.get(i).getDate(), i, 5);
		}
	}

}

class ListenerEditarCliente implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerEditarCliente(ViewTable viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewCliente.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewCliente, "No row selected");
		} else {
			viewCliente.setVisible(false);
			ControllerFormCliente controllerFormCliente = new ControllerFormCliente(Integer.parseInt((String)( viewCliente.getTable().getModel().getValueAt(viewCliente.getTable().getSelectedRow(), 0) )), viewCliente);
		}
		
	}
	
}

class ListenerBorrarCliente implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerBorrarCliente(ViewTable viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewCliente.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewCliente, "No row selected");
		} else {
			if(viewCliente.getTable().getModel().getValueAt(viewCliente.getTable().getSelectedRow(), viewCliente.getTable().getSelectedColumn()) == "") {
				JOptionPane.showMessageDialog(viewCliente, "No row selected");
			} else {
				DBConection.deleteData( Integer.parseInt((String)( viewCliente.getTable().getModel().getValueAt(viewCliente.getTable().getSelectedRow(), 0) )), "Cliente")  ;
				//Update table
				ControllerCliente.fillTable(viewCliente);
				
			}
		}
	}
	
}

class ListenerCrearCliente implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerCrearCliente(ViewTable viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewCliente.setVisible(false);
		ControllerFormCliente controllerFormCliente = new ControllerFormCliente(viewCliente);
	}
	
}

class ListenerCambiarCliente implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

		ViewTable viewTable = new ViewTable();
		ControllerVideos controllerVideos = new ControllerVideos(viewTable);
		controllerVideos.startView();
		viewTable.setTitle("Videos");
	}
	
}
