package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelCliente;
import views.ViewCliente;
import views.ViewFormCliente;

public class ControllerCliente {
	
	ModelCliente modelCliente;
	static ViewCliente viewCliente;
	
	public ControllerCliente (ModelCliente modelCliente, ViewCliente viewCliente) {
		this.modelCliente = modelCliente;
		this.viewCliente = viewCliente;
		
		viewCliente.addListenerBtnEditar(new ListenerEditar(viewCliente));
		viewCliente.addListenerBtnBorrar(new ListenerBorrar(viewCliente));
		viewCliente.addListenerBtnCrear(new ListenerCrear(viewCliente));
	}
	
	public void startView() {
		viewCliente.setTitle("Cliente");
		viewCliente.setLocationRelativeTo(null);
		viewCliente.setVisible(true);
		
		fillTable();
	}
	
	@SuppressWarnings("serial")
	public static void fillTable() {
		ArrayList<ModelCliente> clientes = DBConection.getValues();
		viewCliente.getTable().setModel((new DefaultTableModel(
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
			viewCliente.getTable().getModel().setValueAt(Integer.toString(clientes.get(i).getId()) , i, 0);
			viewCliente.getTable().getModel().setValueAt(clientes.get(i).getNombre(), i, 1);
			viewCliente.getTable().getModel().setValueAt(clientes.get(i).getApellido(), i, 2);
			viewCliente.getTable().getModel().setValueAt(clientes.get(i).getDireccion(), i, 3);
			viewCliente.getTable().getModel().setValueAt(clientes.get(i).getDni(), i, 4);
			viewCliente.getTable().getModel().setValueAt(clientes.get(i).getDate(), i, 5);
		}
	}

}

class ListenerEditar implements ActionListener {
	
	ViewCliente viewCliente;
	
	public ListenerEditar(ViewCliente viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewCliente.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewCliente, "No row selected");
		} else {
			viewCliente.setVisible(false);
			ControllerFormCliente controllerFormCliente = new ControllerFormCliente(0, viewCliente);
		}
		
	}
	
}

class ListenerBorrar implements ActionListener {
	
	ViewCliente viewCliente;
	
	public ListenerBorrar(ViewCliente viewCliente) {
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
				DBConection.deleteData( Integer.parseInt((String)( viewCliente.getTable().getModel().getValueAt(viewCliente.getTable().getSelectedRow(), 0) )))  ;
				//Update table
				ControllerCliente.fillTable();
				
			}
		}
	}
	
}

class ListenerCrear implements ActionListener {
	
	ViewCliente viewCliente;
	
	public ListenerCrear(ViewCliente viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewCliente.setVisible(false);
		ControllerFormCliente controllerFormCliente = new ControllerFormCliente(0, viewCliente);
	}
	
}
