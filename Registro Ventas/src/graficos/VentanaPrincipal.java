package graficos;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class VentanaPrincipal {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal window = new VentanaPrincipal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VentanaPrincipal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 902, 537);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panelNuevoProducto = new JPanel();
        panelNuevoProducto.setBounds(376, 259, 200, 191);
        frame.getContentPane().add(panelNuevoProducto);
        
        JButton btnNuevoProducto = new JButton("Nuevo producto");
        btnNuevoProducto.setBounds(42, 91, 109, 23);
        btnNuevoProducto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panelNuevoProducto.setLayout(null);
        panelNuevoProducto.add(btnNuevoProducto);
        
        JPanel panelVerProductos = new JPanel();
        panelVerProductos.setLayout(null);
        panelVerProductos.setBounds(101, 53, 200, 191);
        frame.getContentPane().add(panelVerProductos);
        
        JButton btnVerProductos = new JButton("Ver productos");
        btnVerProductos.setBounds(42, 81, 109, 23);
        panelVerProductos.add(btnVerProductos);
        
        JPanel panelVerVentas = new JPanel();
        panelVerVentas.setLayout(null);
        panelVerVentas.setBounds(376, 53, 200, 191);
        frame.getContentPane().add(panelVerVentas);
        
        JButton btnVerVentas = new JButton("Ver ventas");
        btnVerVentas.setBounds(52, 81, 109, 23);
        panelVerVentas.add(btnVerVentas);
        
        JPanel panelNuevoCliente = new JPanel();
        panelNuevoCliente.setLayout(null);
        panelNuevoCliente.setBounds(101, 259, 200, 191);
        frame.getContentPane().add(panelNuevoCliente);
        
        JButton btnNuevoCliente = new JButton("Nuevo cliente");
        btnNuevoCliente.setBounds(42, 91, 109, 23);
        panelNuevoCliente.add(btnNuevoCliente);
        
        JPanel panelVerClientes = new JPanel();
        panelVerClientes.setLayout(null);
        panelVerClientes.setBounds(637, 53, 200, 191);
        frame.getContentPane().add(panelVerClientes);
        
        JButton VerClientes = new JButton("Ver clientes");
        VerClientes.setBounds(52, 81, 109, 23);
        panelVerClientes.add(VerClientes);
    }
}
