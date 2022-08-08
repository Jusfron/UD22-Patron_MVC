package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ModelCliente;
import views.ViewCliente;

public class Controller {
	
	ModelCliente modelCliente;
	ViewCliente viewCliente;
	
	public Controller (ModelCliente modelCliente, ViewCliente viewCliente) {
		this.modelCliente = modelCliente;
		this.viewCliente = viewCliente;
		
		viewCliente.addListenerBtnEditar(new ListenerEditar());
		viewCliente.addListenerBtnBorrar(new ListenerBorrar());
		viewCliente.addListenerBtnCrear(new ListenerCrear());
	}
	
	public void startView() {
		viewCliente.setTitle("Cliente");
		viewCliente.setLocationRelativeTo(null);
		viewCliente.setVisible(true);
	}

}

class ListenerEditar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class ListenerBorrar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class ListenerCrear implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
