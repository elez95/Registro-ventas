package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaIngresarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombreCliente;
	private Controlador controlador = new Controlador();

	

	/**
	 * Create the frame.
	 */
	public VentanaIngresarCliente() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 11, 343, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfNombreCliente = new JTextField();
		tfNombreCliente.setBounds(126, 83, 207, 20);
		panel.add(tfNombreCliente);
		tfNombreCliente.setColumns(10);
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(10, 86, 83, 14);
		panel.add(lblNombreCliente);
		
		JButton btnCrearCliente = new JButton("Crear");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createCliente();
			}

			
		});
		btnCrearCliente.setBounds(126, 175, 89, 23);
		panel.add(btnCrearCliente);
	}
	
	/*
	 * Recibe el nombre y verifica que el campo no este vacio
	 * */
	private void createCliente() {
		String nombre = tfNombreCliente.getText();
		if(nombre.equals(null) || nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "No puedes ingresar un nombre vacío");
		}else {
			controlador.ingresarCliente(nombre);
			JOptionPane.showMessageDialog(null, "El cliente " + nombre + " ha sido creado");
		}
	}
}
