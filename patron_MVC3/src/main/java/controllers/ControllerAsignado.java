package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelAsignado;
import views.ViewTable;

public class ControllerAsignado {
	ViewTable viewTable;
	
	public ControllerAsignado (ViewTable viewTable) {
		this.viewTable = viewTable;
		
		viewTable.addListenerBtnEditar(new ListenerEditarAsignado(viewTable));
		viewTable.addListenerBtnBorrar(new ListenerBorrarAsignado(viewTable));
		viewTable.addListenerBtnCrear(new ListenerCrearAsignado(viewTable));
		viewTable.addListenerBtnCambiar(new ListenerCambiarAsignado(viewTable));
		
		viewTable.addComponentListener(new ComponentAdapter() {
			   public void componentHidden(ComponentEvent e) {
			      /* code run when component hidden*/
			   }
			   public void componentShown(ComponentEvent e) {
				   fillTable(viewTable);
			   }
			});
	}
	
	public void startView() {
		viewTable.setTitle("Asignaciones");
		viewTable.setLocationRelativeTo(null);
		viewTable.setVisible(true);
		
		//fillTable(viewTable);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewTable) {
		ArrayList<ModelAsignado> asignados = DBConection.getValuesAsignadoA();
		viewTable.getTable().setModel((new DefaultTableModel(
				new Object[asignados.size()][2] ,
				new String[] {
					"id","Cientifico", "Proyecto"
				}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			}));
		
		for(int i = 0; i < asignados.size(); i++) {
			viewTable.getTable().getModel().setValueAt(Integer.toString(asignados.get(i).getId()) , i, 0);
			viewTable.getTable().getModel().setValueAt(asignados.get(i).getCientifico(), i, 1);
			viewTable.getTable().getModel().setValueAt(asignados.get(i).getProyecto(), i, 2);
		}
	}

}

class ListenerEditarAsignado implements ActionListener {
	
	ViewTable viewTable;
	
	
	public ListenerEditarAsignado(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewTable.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewTable, "No row selected");
		} else {
			viewTable.setVisible(false);
			ControllerFormAsignado controllerFormAsignado = new ControllerFormAsignado(Integer.parseInt((String)( viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), 0) )), viewTable);
		}
		
	}
	
}

class ListenerBorrarAsignado implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerBorrarAsignado(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewTable.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewTable, "No row selected");
		} else {
			if(viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), viewTable.getTable().getSelectedColumn()) == "") {
				JOptionPane.showMessageDialog(viewTable, "No row selected");
			} else {
				DBConection.deleteData( Integer.parseInt((String)( viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), 0) )), "AsignadoA")  ;
				//Update table
				ControllerAsignado.fillTable(viewTable);
				
			}
		}
	}
	
}

class ListenerCrearAsignado implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCrearAsignado(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewTable.setVisible(false);
		ControllerFormAsignado controllerFormAsignado = new ControllerFormAsignado(viewTable);
	}
	
}

class ListenerCambiarAsignado implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCambiarAsignado(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		viewTable.setVisible(false);
		viewTable.dispose();
		ViewTable viewTablenew = new ViewTable();
		ControllerCientificos controllerCientificos = new ControllerCientificos(viewTablenew);
		controllerCientificos.startView();
		viewTablenew.setTitle("Cientificos");
		viewTablenew.setLblTitle("Cientificos");
	}
	
}