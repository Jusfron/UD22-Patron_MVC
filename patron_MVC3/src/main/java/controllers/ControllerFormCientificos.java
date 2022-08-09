package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCientifico;

public class ControllerFormCientificos implements ActionListener{
	
	private ViewFormCientifico viewFormCliente;
	private Component clienteWindow;
	private int id = -1;
	
	public ControllerFormCientificos(int id, Component clienteWindow) {
		this.id = id;
		this.clienteWindow = clienteWindow;
		
		initialize();
		
		viewFormCliente.form(DBConection.getValueCliente(id));
	}
	
	public ControllerFormCientificos(Component clienteWindow) {
		this.clienteWindow = clienteWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormCliente = new ViewFormCientifico();
		viewFormCliente.setLocationRelativeTo(clienteWindow);
		viewFormCliente.setVisible(true);
		
		viewFormCliente.getBtnGuardar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id == -1) {
			DBConection.insertData(DBConection.lastId("Cliente"), viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
					viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
		} else {
			DBConection.updateData(id, viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
					viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
		}
		
		clienteWindow.setVisible(true);
		viewFormCliente.dispose();
	}

}
