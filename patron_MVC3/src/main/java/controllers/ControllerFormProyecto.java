package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCientifico;
import views.ViewFormProyecto;

public class ControllerFormProyecto implements ActionListener{

	private ViewFormProyecto viewFormVideos;
	private Component clienteVideo;
	private String id = "-1";
	
	public ControllerFormProyecto(String id, Component clienteVideo) {
		this.id = id;
		this.clienteVideo = clienteVideo;
		
		initialize();
		
		viewFormVideos.form(DBConection.getValueProyecto(id));
	}
	
	public ControllerFormProyecto(Component clienteWindow) {
		this.clienteVideo = clienteWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormVideos = new ViewFormProyecto();
		viewFormVideos.setLocationRelativeTo(clienteVideo);
		viewFormVideos.setVisible(true);
		
		viewFormVideos.getBtnGuardar().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id.equals("-1")) {
			DBConection.insertData(viewFormVideos.getTxtFId().getText(), viewFormVideos.getTxtFNombre().getText(),Integer.parseInt(viewFormVideos.getTxtFHoras().getText()));
		} else {
			DBConection.updateData(id, viewFormVideos.getTxtFNombre().getText(),Integer.parseInt(viewFormVideos.getTxtFHoras().getText()));
		}
		
		clienteVideo.setVisible(true);
		viewFormVideos.dispose();
	}

}
