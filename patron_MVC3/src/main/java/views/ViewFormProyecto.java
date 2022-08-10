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

public class ViewFormProyecto extends JFrame{
	private JPanel contentPane;
	private JTextField txtFId;
	private JTextField txtFNombre;
	private JButton btnGuardar;
	private JTextField txtFHoras;

	public ViewFormProyecto() {
		inicializar();
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 727, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWindowTitle = new JLabel("Videos");
		lblWindowTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFId = new JTextField();
		txtFId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFId.setColumns(10);
		
		txtFNombre = new JTextField();
		txtFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFNombre.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFHoras = new JTextField();
		txtFHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFHoras.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblWindowTitle)
							.addContainerGap(639, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblError)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(88))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblHoras, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
									.addComponent(txtFHoras, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
									.addGap(69)
									.addComponent(txtFNombre, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblId, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
									.addGap(67)
									.addComponent(txtFId, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
							.addGap(380))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWindowTitle)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFId, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFNombre, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoras, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFHoras, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(141)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblError)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void form(ModelProyecto proyecto) {
		txtFId.setText(proyecto.getId());
		txtFId.setEditable(false);
		txtFNombre.setText(proyecto.getNombre());
		txtFHoras.setText(String.valueOf(proyecto.getHoras()));
		//txtFClientId.setText(Integer.toString(video.getCli_id()) );
	}
	
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JTextField getTxtFId() {
		return txtFId;
	}

	public JTextField getTxtFNombre() {
		return txtFNombre;
	}

	public JTextField getTxtFHoras() {
		return txtFHoras;
	}

}
