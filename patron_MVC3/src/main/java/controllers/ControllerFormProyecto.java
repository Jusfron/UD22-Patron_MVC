package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCientifico;
import views.ViewFormProyecto;

public class ControllerFormProyecto implements ActionListener{

	private ViewFormProyecto viewFormProyecto;
	private Component clienteVideo;
	private String id = "-1";
	
	public ControllerFormProyecto(String id, Component clienteVideo) {
		this.id = id;
		this.clienteVideo = clienteVideo;
		
		initialize();
		
		viewFormProyecto.form(DBConection.getValueProyecto(id));
	}
	
	public ControllerFormProyecto(Component clienteWindow) {
		this.clienteVideo = clienteWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormProyecto = new ViewFormProyecto();
		viewFormProyecto.setLocationRelativeTo(clienteVideo);
		viewFormProyecto.setVisible(true);
		
		viewFormProyecto.getBtnGuardar().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id.equals("-1")) {
			DBConection.insertData(viewFormProyecto.getTxtFId().getText(), viewFormProyecto.getTxtFNombre().getText(),Integer.parseInt(viewFormProyecto.getTxtFHoras().getText()));
		} else {
			DBConection.updateData(id, viewFormProyecto.getTxtFNombre().getText(),Integer.parseInt(viewFormProyecto.getTxtFHoras().getText()));
		}
		
		clienteVideo.setVisible(true);
		viewFormProyecto.dispose();
	}

}
