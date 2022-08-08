package controllers;

import models.ModelCliente;
import views.ViewCliente;

public class Controller {
	
	ModelCliente modelCliente;
	ViewCliente viewCliente;
	
	public Controller (ModelCliente modelCliente, ViewCliente viewCliente) {
		this.modelCliente = modelCliente;
		this.viewCliente = viewCliente;
	}
	
	public void startView() {
		viewCliente.setTitle("Cliente");
		viewCliente.setLocationRelativeTo(null);
		viewCliente.setVisible(true);
	}

}
