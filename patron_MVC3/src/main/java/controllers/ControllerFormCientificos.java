package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.DBConection;
import views.ViewFormCientifico;

public class ControllerFormCientificos implements ActionListener{
	
	private ViewFormCientifico viewFormCientifico;
	private Component CientificoWindow;
	private String DNI = "";
	
	public ControllerFormCientificos(String DNI, Component CientificoWindow) {
		this.DNI = DNI;
		this.CientificoWindow = CientificoWindow;
		
		initialize();
		
		viewFormCientifico.form(DBConection.getValueCientifico(DNI));
	}
	
	public ControllerFormCientificos(Component CientificoWindow) {
		this.CientificoWindow = CientificoWindow;
		
		initialize();
	}
	
	private void initialize() {
		viewFormCientifico = new ViewFormCientifico();
		viewFormCientifico.setLocationRelativeTo(CientificoWindow);
		viewFormCientifico.setVisible(true);
		
		viewFormCientifico.getBtnGuardar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(DNI == -1) {
//			DBConection.insertData(DBConection.lastDNI("Cientifico"), viewFormCientifico.getTxtFNomApels());
//		} else {
//			DBConection.updateData(DNI, viewFormCientifico.getTxtFNomApels());
//		}
//		
//		CientificoWindow.setVisible(true);
//		viewFormCientifico.dispose();
	}

}
