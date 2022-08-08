package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCliente;

public class ControllerFormCliente implements ActionListener{
	
	private ViewFormCliente viewFormCliente;
	private int id = -1;
	
	public ControllerFormCliente(int id, Component clienteWindow) {
		this.id = id;
		
		ViewFormCliente viewFormCliente = new ViewFormCliente();
		viewFormCliente.setLocationRelativeTo(clienteWindow);
		viewFormCliente.setVisible(true);
		
		viewFormCliente.form(DBConection.getValue(id));
		
		viewFormCliente.getBtnGuardar().addActionListener(this);
	}
	
	public ControllerFormCliente(Component clienteWindow) {
		
		ViewFormCliente viewFormCliente = new ViewFormCliente();
		viewFormCliente.setLocationRelativeTo(clienteWindow);
		viewFormCliente.setVisible(true);
		
		viewFormCliente.getBtnGuardar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id == -1) {
			DBConection.insertData(id, viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
					viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
		} else {
			DBConection.updateData(id, viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
					viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
		}
		
	}

}
