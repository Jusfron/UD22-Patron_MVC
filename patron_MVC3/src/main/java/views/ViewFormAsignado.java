package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import models.ModelCientifico;
import models.ModelProyecto;
import javax.swing.JComboBox;

public class ViewFormAsignado extends JFrame{
	private JPanel contentPane;
	private JButton btnGuardar;
	private JComboBox cmbCientifico;
	private JComboBox cmbProyecto;

	public ViewFormAsignado() {
		inicializar();
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 727, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWindowTitle = new JLabel("Asignaciones");
		lblWindowTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblProyecto = new JLabel("Proyecto:");
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		cmbProyecto = new JComboBox();
		
		JLabel lblCientifico = new JLabel("Cientifico:");
		lblCientifico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cmbCientifico = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblWindowTitle)
							.addContainerGap(640, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblError)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(88))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblProyecto, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbProyecto, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCientifico, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(cmbCientifico, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
							.addGap(380))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWindowTitle)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCientifico, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbCientifico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cmbProyecto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProyecto, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(201)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblError)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JComboBox getCmbCientifico() {
		return cmbCientifico;
	}

	public JComboBox getCmbProyecto() {
		return cmbProyecto;
	}
}
