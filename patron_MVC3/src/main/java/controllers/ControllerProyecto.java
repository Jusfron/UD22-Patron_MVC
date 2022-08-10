package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelProyecto;
import views.ViewTable;

public class ControllerProyecto {
	ViewTable viewTable;
	
	public ControllerProyecto (ViewTable viewTable) {
		this.viewTable = viewTable;
		
		viewTable.addListenerBtnEditar(new ListenerEditarProyecto(viewTable));
		viewTable.addListenerBtnBorrar(new ListenerBorrarProyecto(viewTable));
		viewTable.addListenerBtnCrear(new ListenerCrearProyecto(viewTable));
		viewTable.addListenerBtnCambiar(new ListenerCambiarProyecto(viewTable));
		
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
		viewTable.setTitle("Videos");
		viewTable.setLocationRelativeTo(null);
		viewTable.setVisible(true);
		
		//fillTable(viewTable);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewTable) {
		ArrayList<ModelProyecto> videos = DBConection.getValuesProyecto();
		viewTable.getTable().setModel((new DefaultTableModel(
				new Object[videos.size()][4] ,
				new String[] {
					"id", "title", "director", "cli_id"
				}) {

			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			}));
		
		for(int i = 0; i < videos.size(); i++) {
			viewTable.getTable().getModel().setValueAt((videos.get(i).getId()) , i, 0);
			viewTable.getTable().getModel().setValueAt(videos.get(i).getNombre(), i, 1);
			viewTable.getTable().getModel().setValueAt(videos.get(i).getHoras(), i, 2);
		}
	}

}

class ListenerEditarProyecto implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerEditarProyecto(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewTable.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewTable, "No row selected");
		} else {
			viewTable.setVisible(false);
			ControllerFormProyecto controllerFormVideos = new ControllerFormProyecto((String)( viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), 0) ), viewTable);
		}
		
	}
	
}

class ListenerBorrarProyecto implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerBorrarProyecto(ViewTable viewTable) {
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
				DBConection.deleteData( Integer.parseInt((String)( viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), 0) )), "Videos")  ;
				//Update table
				ControllerProyecto.fillTable(viewTable);
				
			}
		}
	}
	
}

class ListenerCrearProyecto implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCrearProyecto(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewTable.setVisible(false);
		ControllerFormProyecto controllerFormVideos = new ControllerFormProyecto(viewTable);
	}
	
}

class ListenerCambiarProyecto implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCambiarProyecto(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		viewTable.setVisible(false);
		viewTable.dispose();
		ViewTable viewTablenew = new ViewTable();
		ControllerAsignado controllerAsignado = new ControllerAsignado(viewTablenew);
		controllerAsignado.startView();
		viewTablenew.setTitle("Cliente");
		viewTablenew.setLblTitle("Cliente");
	}
	
}