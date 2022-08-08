package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.ModelCliente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class ViewFormCliente extends JFrame{
	
	private JPanel contentPane;
	private JTextField txtFNombre;
	private JTextField txtFApellido;
	private JTextField txtFDireccion;
	private JTextField txtFDNI;
	private JTextField txtFFecha;
	private JButton btnGuardar;

	public ViewFormCliente() {
		inicializar();
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 727, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Direccion:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("DNI:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Fecha:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFNombre = new JTextField();
		txtFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFNombre.setColumns(10);
		
		txtFApellido = new JTextField();
		txtFApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFApellido.setColumns(10);
		
		txtFDireccion = new JTextField();
		txtFDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFDireccion.setColumns(10);
		
		txtFDNI = new JTextField();
		txtFDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFDNI.setColumns(10);
		
		txtFFecha = new JTextField();
		txtFFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFFecha.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addContainerGap(638, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
										.addGap(69)
										.addComponent(txtFApellido, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
										.addGap(67)
										.addComponent(txtFNombre, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
								.addGap(380))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1_3, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
											.addGap(92)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_4)
										.addGap(92)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(txtFFecha, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
									.addComponent(txtFDNI, 178, 178, Short.MAX_VALUE)
									.addComponent(txtFDireccion, Alignment.TRAILING, 178, 178, Short.MAX_VALUE))
								.addGap(380)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblError)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(88))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFNombre, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFApellido, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFDireccion, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFDNI, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFFecha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblError)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void form(ModelCliente cliente) {
		txtFNombre.setText(cliente.getNombre());
		txtFApellido.setText(cliente.getApellido());
		txtFDireccion.setText(cliente.getDireccion());
		txtFDNI.setText(String.valueOf(cliente.getDni()));
		txtFFecha.setText(cliente.getDate());
	}
	
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public String getTxtFNombre() {
		return txtFNombre.getText();
	}

	public String getTxtFApellido() {
		return txtFApellido.getText();
	}

	public String getTxtFDireccion() {
		return txtFDireccion.getText();
	}

	public String getTxtFDNI() {
		return txtFDNI.getText();
	}

	public String getTxtFFecha() {
		return txtFFecha.getText();
	}
	
	
}
