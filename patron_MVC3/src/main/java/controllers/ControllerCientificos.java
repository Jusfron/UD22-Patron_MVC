package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelCientifico;
import views.ViewTable;
import views.ViewFormCientifico;

public class ControllerCientificos {
	
	ViewTable viewTable;
	
	public ControllerCientificos (ViewTable viewTable) {
		this.viewTable = viewTable;
		
		viewTable.addListenerBtnEditar(new ListenerEditarCientifico(viewTable));
		viewTable.addListenerBtnBorrar(new ListenerBorrarCientifico(viewTable));
		viewTable.addListenerBtnCrear(new ListenerCrearCientifico(viewTable));
		viewTable.addListenerBtnCambiar(new ListenerCambiarCientifico(viewTable));
		
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
		viewTable.setTitle("Cientificos");
		viewTable.setLocationRelativeTo(null);
		viewTable.setVisible(true);
		
		//fillTable(viewTable);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewTable) {
		ArrayList<ModelCientifico> Cientifico = DBConection.getValuesCientificos();
		viewTable.getTable().setModel((new DefaultTableModel(
				new Object[Cientifico.size()][6] ,
				new String[] {
					"dni", "nomApels"
				}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			}));
		
		for(int i = 0; i < Cientifico.size(); i++) {
			viewTable.getTable().getModel().setValueAt(Cientifico.get(i).getDNI() , i, 0);
			viewTable.getTable().getModel().setValueAt(Cientifico.get(i).getNomApels(), i, 1);

		}
	}

}

class ListenerEditarCientifico implements ActionListener {
	
	ViewTable viewCientifico;
	
	public ListenerEditarCientifico(ViewTable viewCientifico) {
		super();
		this.viewCientifico = viewCientifico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewCientifico.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewCientifico, "No row selected");
		} else {
			viewCientifico.setVisible(false);
			ControllerFormCientificos controllerFormCientifico = new ControllerFormCientificos(Integer.parseInt((String)( viewCientifico.getTable().getModel().getValueAt(viewCientifico.getTable().getSelectedRow(), 0) )), viewCientifico);
		}
		
	}
	
}

class ListenerBorrarCientifico implements ActionListener {
	
	ViewTable viewCientifico;
	
	public ListenerBorrarCientifico(ViewTable viewCientifico) {
		super();
		this.viewCientifico = viewCientifico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewCientifico.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewCientifico, "No row selected");
		} else {
			if(viewCientifico.getTable().getModel().getValueAt(viewCientifico.getTable().getSelectedRow(), viewCientifico.getTable().getSelectedColumn()) == "") {
				JOptionPane.showMessageDialog(viewCientifico, "No row selected");
			} else {
				DBConection.deleteData( Integer.parseInt((String)( viewCientifico.getTable().getModel().getValueAt(viewCientifico.getTable().getSelectedRow(), 0) )), "Cientifico")  ;
				//Update table
				ControllerCientificos.fillTable(viewCientifico);
				
			}
		}
	}
	
}

class ListenerCrearCientifico implements ActionListener {
	
	ViewTable viewCientifico;
	
	public ListenerCrearCientifico(ViewTable viewCientifico) {
		super();
		this.viewCientifico = viewCientifico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewCientifico.setVisible(false);
		ControllerFormCientificos controllerFormCientifico = new ControllerFormCientificos(viewCientifico);
	}
	
}

class ListenerCambiarCientifico implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCambiarCientifico(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	//??
	@Override
	public void actionPerformed(ActionEvent e) {

		viewTable.setVisible(false);
		viewTable.dispose();
		ViewTable viewTablenew = new ViewTable();
		ControllerProyecto controllerVideos = new ControllerProyecto(viewTablenew);
		controllerVideos.startView();
		viewTablenew.setTitle("Videos");
		viewTablenew.setLblTitle("Videos");
	}
	
}
