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
	private int id = -1;
	
	public ControllerFormProyecto(int id, Component clienteVideo) {
		this.id = id;
		this.clienteVideo = clienteVideo;
		
		initialize();
		
		viewFormVideos.form(DBConection.getValueVideo(id));
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
		
		for(Integer id : DBConection.getClientsId()) {
			viewFormVideos.getCmbCliId().addItem(id);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id == -1) {
			DBConection.insertData(DBConection.lastId("Videos"), viewFormVideos.getTxtFTitle(), viewFormVideos.getTxtFDirector(), (Integer) viewFormVideos.getCmbCliId().getSelectedItem());
		} else {
			DBConection.updateData(id, viewFormVideos.getTxtFTitle(), viewFormVideos.getTxtFDirector(),(Integer) viewFormVideos.getCmbCliId().getSelectedItem() );
		}
		
		clienteVideo.setVisible(true);
		viewFormVideos.dispose();
	}

}
