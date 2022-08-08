package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.DBConection;
import models.ModelCliente;
import models.ModelVideo;
import views.ViewTable;

public class ControllerVideos {
	ModelVideo modelVideo;
	ViewTable viewTable;
	
	public ControllerVideos (ModelVideo modelVideo, ViewTable viewTable) {
		this.modelVideo = modelVideo;
		this.viewTable = viewTable;
		
		viewTable.addListenerBtnEditar(new ListenerEditarVideos(viewTable));
		viewTable.addListenerBtnBorrar(new ListenerBorrarVideos(viewTable));
		viewTable.addListenerBtnCrear(new ListenerCrearVideos(viewTable));
		
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
		viewTable.setTitle("Cliente");
		viewTable.setLocationRelativeTo(null);
		viewTable.setVisible(true);
		
		fillTable(viewTable);
	}
	
	@SuppressWarnings("serial")
	public static void fillTable(ViewTable viewTable) {
		ArrayList<ModelVideo> videos = DBConection.getValuesVideos();
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
			viewTable.getTable().getModel().setValueAt(Integer.toString(videos.get(i).getId()) , i, 0);
			viewTable.getTable().getModel().setValueAt(videos.get(i).getTitle(), i, 1);
			viewTable.getTable().getModel().setValueAt(videos.get(i).getDirector(), i, 2);
			viewTable.getTable().getModel().setValueAt(videos.get(i).getCli_id(), i, 3);
		}
	}

}

class ListenerEditarVideos implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerEditarVideos(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(viewTable.getTable().getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(viewTable, "No row selected");
		} else {
			viewTable.setVisible(false);
			ControllerFormVideos controllerFormVideos = new ControllerFormVideos(Integer.parseInt((String)( viewTable.getTable().getModel().getValueAt(viewTable.getTable().getSelectedRow(), 0) )), viewTable);
		}
		
	}
	
}

class ListenerBorrarVideos implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerBorrarVideos(ViewTable viewTable) {
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
				ControllerVideos.fillTable(viewTable);
				
			}
		}
	}
	
}

class ListenerCrearVideos implements ActionListener {
	
	ViewTable viewTable;
	
	public ListenerCrearVideos(ViewTable viewTable) {
		super();
		this.viewTable = viewTable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewTable.setVisible(false);
		ControllerFormVideos controllerFormVideos = new ControllerFormVideos(viewTable);
	}
	
}

class ListenerCambiarVideos implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}