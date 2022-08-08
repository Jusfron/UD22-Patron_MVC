package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mysql.cj.util.StringUtils;

import models.DBConection;
import views.ViewFormCliente;

public class ControllerFormCliente implements ActionListener{
	
	private ViewFormCliente viewFormCliente;
	private Component clienteWindow;
	private int id = -1;
	private String validDni = "0123456789";
	
	public ControllerFormCliente(int id, Component clienteWindow) {
		this.id = id;
		this.clienteWindow = clienteWindow;
		
		initialize();
		
		viewFormCliente.form(DBConection.getValue(id));
	}
	
	public ControllerFormCliente(Component clienteWindow) {
		this.clienteWindow = clienteWindow;
		
		initialize();
	}
	
	
	private void initialize() {
		viewFormCliente = new ViewFormCliente();
		viewFormCliente.setLocationRelativeTo(clienteWindow);
		viewFormCliente.setVisible(true);
		
		viewFormCliente.getBtnGuardar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(viewFormCliente.getTxtFNombre().equals("")||viewFormCliente.getTxtFApellido().equals("")||viewFormCliente.getTxtFDireccion().equals("")||viewFormCliente.getTxtFDNI().equals("")||viewFormCliente.getTxtFFecha().equals("")) {
			viewFormCliente.setLblError("Error: Algunos campos estan vacios");
		}else {
			if(comprobar(viewFormCliente)) {
				if(id == -1) {
					DBConection.insertData(DBConection.lastId(), viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
						viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
				} else {
					DBConection.updateData(id, viewFormCliente.getTxtFNombre(), viewFormCliente.getTxtFApellido(), viewFormCliente.getTxtFDireccion(), 
						viewFormCliente.getTxtFDNI(), viewFormCliente.getTxtFFecha());
				}
				clienteWindow.setVisible(true);
				viewFormCliente.dispose();
			}
			
		}
		
	}
	
	public static boolean comprobar(ViewFormCliente viewFormCliente) {
		String fecha = viewFormCliente.getTxtFFecha();
		String dni= viewFormCliente.getTxtFDNI();
		boolean controler=false;
		int year, month, day;
		String[] str;
		
		if(StringUtils.isStrictlyNumeric(dni) && dni.length()<=8) {
			str=fecha.split("-");
			try {
				year= Integer.parseInt(str[0]);
				month= Integer.parseInt(str[1]);
				day= Integer.parseInt(str[2]);
				LocalDate date=LocalDate.of(year, month, day);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				controler=true;
			} catch (Exception e) {
				viewFormCliente.setLblError("Error: el apartado Fecha tiene que seguir els siguiente patron (YYYY-MM-DD)");
				controler=false;
			}
		}else{
			viewFormCliente.setLblError("Error: el campo DNI tiene que ser numerico");
		}

		return controler;
		
	}

}
