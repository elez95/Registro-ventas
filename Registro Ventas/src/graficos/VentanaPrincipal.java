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
        
        JPanel ingresarProducto = new JPanel();
        ingresarProducto.setBounds(455, 53, 200, 191);
        frame.getContentPane().add(ingresarProducto);
        
        JButton btnNewButton = new JButton("Nuevo producto");
        btnNewButton.setBounds(42, 91, 109, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        ingresarProducto.setLayout(null);
        ingresarProducto.add(btnNewButton);
        
        JPanel panelVerProductos = new JPanel();
        panelVerProductos.setLayout(null);
        panelVerProductos.setBounds(101, 53, 200, 191);
        frame.getContentPane().add(panelVerProductos);
        
        JButton btnVerProductos = new JButton("Ver productos");
        btnVerProductos.setBounds(60, 97, 109, 23);
        panelVerProductos.add(btnVerProductos);
        
        JPanel panelVerProductos_1 = new JPanel();
        panelVerProductos_1.setLayout(null);
        panelVerProductos_1.setBounds(101, 258, 200, 191);
        frame.getContentPane().add(panelVerProductos_1);
        
        JButton btnVerProductos_1 = new JButton("Ver productos");
        btnVerProductos_1.setBounds(60, 97, 109, 23);
        panelVerProductos_1.add(btnVerProductos_1);
    }
}
