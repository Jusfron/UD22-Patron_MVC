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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
}
