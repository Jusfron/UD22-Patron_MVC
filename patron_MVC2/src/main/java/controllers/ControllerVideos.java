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

public class ControllerVideos {
	ModelCliente modelCliente;
	ViewTable viewCliente;
	
	public ControllerVideos (ModelCliente modelCliente, ViewTable viewCliente) {
		this.modelCliente = modelCliente;
		this.viewCliente = viewCliente;
		
		viewCliente.addListenerBtnEditar(new ListenerEditarVideos(viewCliente));
		viewCliente.addListenerBtnBorrar(new ListenerBorrarVideos(viewCliente));
		viewCliente.addListenerBtnCrear(new ListenerCrearVideos(viewCliente));
		
		viewCliente.addComponentListener(new ComponentAdapter() {
			   public void componentHidden(ComponentEvent e) {
			      /* code run when component hidden*/
			   }
			   public void componentShown(ComponentEvent e) {
				   fillTable(viewCliente);
			   }
			});
	}
	
	public void startView() {
		viewCliente.setTitle("Cliente");
		viewCliente.setLocationRelativeTo(null);
		viewCliente.setVisible(true);
		
		fillTable(viewCliente);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewCliente) {
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

class ListenerEditarVideos implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerEditarVideos(ViewTable viewCliente) {
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

class ListenerBorrarVideos implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerBorrarVideos(ViewTable viewCliente) {
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
				ControllerCliente.fillTable(viewCliente);
				
			}
		}
	}
	
}

class ListenerCrearVideos implements ActionListener {
	
	ViewTable viewCliente;
	
	public ListenerCrearVideos(ViewTable viewCliente) {
		super();
		this.viewCliente = viewCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewCliente.setVisible(false);
		ControllerFormCliente controllerFormCliente = new ControllerFormCliente(viewCliente);
	}
	
}