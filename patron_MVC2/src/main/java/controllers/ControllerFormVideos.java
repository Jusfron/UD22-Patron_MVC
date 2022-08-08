package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCliente;
import views.ViewFormVideos;

public class ControllerFormVideos implements ActionListener{

	private ViewFormVideos viewFormVideos;
	private Component clienteVideo;
	private int id = -1;
	
	public ControllerFormVideos(int id, Component clienteVideo) {
		this.id = id;
		this.clienteVideo = clienteVideo;
		
		initialize();
		
		viewFormVideos.form(DBConection.getValueVideo(id));
	}
	
	public ControllerFormVideos(Component clienteWindow) {
		this.clienteVideo = clienteWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormVideos = new ViewFormVideos();
		viewFormVideos.setLocationRelativeTo(clienteVideo);
		viewFormVideos.setVisible(true);
		
		viewFormVideos.getBtnGuardar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id == -1) {
			DBConection.insertData(DBConection.lastId("videos"), viewFormVideos.getTxtFTitle(), viewFormVideos.getTxtFDirector(), Integer.parseInt(viewFormVideos.getTxtFClientId()));
		} else {
			DBConection.updateData(id, viewFormVideos.getTxtFTitle(), viewFormVideos.getTxtFDirector(),Integer.parseInt(viewFormVideos.getTxtFClientId()) );
		}
		
		clienteVideo.setVisible(true);
		viewFormVideos.dispose();
	}

}
