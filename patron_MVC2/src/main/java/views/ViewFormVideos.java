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

import models.ModelCliente;
import models.ModelVideo;

public class ViewFormVideos extends JFrame{
	private JPanel contentPane;
	private JTextField txtFTitle;
	private JTextField txtFDirector;
	private JTextField txtFClientId;
	private JButton btnGuardar;

	public ViewFormVideos() {
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
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblClientId = new JLabel("Client id:");
		lblClientId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFTitle = new JTextField();
		txtFTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFTitle.setColumns(10);
		
		txtFDirector = new JTextField();
		txtFDirector.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFDirector.setColumns(10);
		
		txtFClientId = new JTextField();
		txtFClientId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFClientId.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWindowTitle)
							.addContainerGap(638, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDirector, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
									.addGap(69)
									.addComponent(txtFDirector, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
									.addGap(67)
									.addComponent(txtFTitle, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
							.addGap(380))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientId, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFClientId, 178, 179, Short.MAX_VALUE)
							.addGap(380))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblError)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addGap(88))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWindowTitle)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFTitle, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDirector, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFDirector, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClientId, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFClientId, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(141)
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblError)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void form(ModelVideo video) {
//		txtFTitle.setText(video.getTitle());
//		txtFDirector.setText(video.getDirector());
//		txtFClientId.setText(video.getClientId());
	}
	
	
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public String getTxtFNombre() {
		return txtFTitle.getText();
	}

	public String getTxtFApellido() {
		return txtFDirector.getText();
	}

	public String getTxtFDireccion() {
		return txtFClientId.getText();
	}
}
