
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentanaTicket extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Cuenta c;
	public ConexionBBDD conexion;
	public VentanaPedido ventanapedido;

	/**
	 * Crea la ventana.
	 */

	public VentanaTicket(Cuenta c, ConexionBBDD conexion, VentanaPedido ventanapedido) {
		super();
		this.c = c;
		this.conexion = conexion;
		this.ventanapedido = ventanapedido;
	}

	public void AbrirVentanaTicket() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setTitle("Ticket");
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		
		JLabel label = new JLabel("Total");
		label.setBounds(48, 171, 108, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Numero de productos");
		label_1.setBounds(48, 69, 108, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Mesa");
		label_2.setBounds(48, 121, 46, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Id_Cuenta");
		label_3.setBounds(48, 19, 46, 14);
		getContentPane().add(label_3);
		
		JButton button = new JButton("Finalizar");
		button.setBackground(new Color(34, 139, 34));
		button.setBounds(167, 215, 113, 35);
		getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(207, 168, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(c.getPrecio_Total());
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 66, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(c.getTotal_Productos());
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 118, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(c.getMesa());
		
		textField_3 = new JTextField();
		textField_3.setBounds(207, 16, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(c.getId_Cuenta());
		
	}


	
}
