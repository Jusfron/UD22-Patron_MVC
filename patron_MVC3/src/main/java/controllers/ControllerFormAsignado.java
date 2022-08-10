package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormAsignado;

public class ControllerFormAsignado implements ActionListener{

	private ViewFormAsignado viewFormAsignado;
	private Component tableFrame;
	private int id = -1;
	
	public ControllerFormAsignado(int id, Component tableFrame) {
		this.id = id;
		this.tableFrame = tableFrame;
		
		initialize();
		
		viewFormAsignado.form(DBConection.getValueAsignadoA(id));
	}
	
	public ControllerFormAsignado(Component clienteWindow) {
		this.tableFrame = clienteWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormAsignado = new ViewFormAsignado();
		viewFormAsignado.setLocationRelativeTo(tableFrame);
		viewFormAsignado.setVisible(true);
		
		viewFormAsignado.getBtnGuardar().addActionListener(this);
		
		for(Integer id : DBConection.getCientifico()) {
			viewFormAsignado.getCmbCientifico().addItem(id);
		}
		for(Integer id : DBConection.getProyecto()) {
			viewFormAsignado.getCmbProyecto().addItem(id);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(id == -1) {
			DBConection.insertData(DBConection.lastId("Asignado"), (Integer) viewFormAsignado.getCmbProyecto().getSelectedItem() );
		} else {
			DBConection.updateData(id, (Integer) viewFormAsignado.getCmbCientifico().getSelectedItem(), (Integer) viewFormAsignado.getCmbProyecto().getSelectedItem() );
		}
		
		tableFrame.setVisible(true);
		viewFormAsignado.dispose();
	}

}
