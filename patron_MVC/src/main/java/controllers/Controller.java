package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.ModelCliente;
import views.ViewCliente;
import views.ViewFormCliente;

public class Controller {
	
	ModelCliente modelCliente;
	ViewCliente viewCliente;
	
	public Controller (ModelCliente modelCliente, ViewCliente viewCliente) {
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
			ViewFormCliente viewFormCliente = new ViewFormCliente();
			viewCliente.setLocationRelativeTo(viewCliente);
			viewFormCliente.setVisible(true);
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
		ViewFormCliente viewFormCliente = new ViewFormCliente();
		viewCliente.setLocationRelativeTo(viewCliente);
		viewFormCliente.setVisible(true);
	}
	
}
