package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaIngresarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCantidad;
	private JTextField tfPrecioCompra;
	private JTextField tfPrecioVenta;
	private JTextField tfDetalle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresarProducto frame = new VentanaIngresarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaIngresarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 46, 680, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbcategoria = new JComboBox();
		cbcategoria.setModel(new DefaultComboBoxModel(new String[] {"", "Cartera", "Billetera", "Riñonera", "Mochila", "Morral", "Cinto", "Miscelaneo"}));
		cbcategoria.setBounds(214, 166, 169, 22);
		panel.add(cbcategoria);
		
		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(39, 170, 114, 14);
		panel.add(lblNewLabel);
		
		tfCantidad = new JTextField();
		tfCantidad.setBounds(214, 307, 86, 20);
		panel.add(tfCantidad);
		tfCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(39, 310, 93, 14);
		panel.add(lblCantidad);
		
		JComboBox cbColor = new JComboBox();
		cbColor.setModel(new DefaultComboBoxModel(new String[] {"", "Negro", "Blanco", "Gris", "Azul", "Rojo", "Verde", "Naranja", "Celeste", "Violeta", "Variado"}));
		cbColor.setBounds(214, 200, 169, 22);
		panel.add(cbColor);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(39, 204, 46, 14);
		panel.add(lblColor);
		
		tfPrecioCompra = new JTextField();
		tfPrecioCompra.setBounds(214, 245, 86, 20);
		panel.add(tfPrecioCompra);
		tfPrecioCompra.setColumns(10);
		
		JLabel lvlPrecioCompra = new JLabel("Precio compra");
		lvlPrecioCompra.setBounds(39, 248, 93, 14);
		panel.add(lvlPrecioCompra);
		
		tfPrecioVenta = new JTextField();
		tfPrecioVenta.setBounds(214, 276, 86, 20);
		panel.add(tfPrecioVenta);
		tfPrecioVenta.setColumns(10);
		
		JLabel lblPrecioVenta = new JLabel("Precio venta");
		lblPrecioVenta.setBounds(39, 279, 93, 14);
		panel.add(lblPrecioVenta);
		
		JButton btnAnadirCategoria = new JButton("+");
		btnAnadirCategoria.setBounds(408, 166, 46, 23);
		panel.add(btnAnadirCategoria);
		
		JComboBox cbMarcas = new JComboBox();
		cbMarcas.setModel(new DefaultComboBoxModel(new String[] {"", "XD", "Oreiro", "Cristian Dior"}));
		cbMarcas.setBounds(214, 133, 169, 22);
		panel.add(cbMarcas);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(39, 137, 46, 14);
		panel.add(lblMarca);
		
		JButton btnAnadirMarca = new JButton("+");
		btnAnadirMarca.setBounds(408, 133, 46, 23);
		panel.add(btnAnadirMarca);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(302, 353, 89, 23);
		panel.add(btnIngresar);
		
		JButton btnSubirFoto = new JButton("Subir foto");
		btnSubirFoto.setBounds(465, 258, 89, 23);
		panel.add(btnSubirFoto);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(581, 353, 89, 23);
		panel.add(btnLimpiar);
		
		tfDetalle = new JTextField();
		tfDetalle.setBounds(214, 102, 399, 20);
		panel.add(tfDetalle);
		tfDetalle.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(39, 105, 46, 14);
		panel.add(lblDetalle);
	}
}
