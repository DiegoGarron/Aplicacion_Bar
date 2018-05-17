
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VentanaModificar1 extends JDialog {
	
	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Producto p;
	public ConexionBBDD conexion;
	public VentanaAdmin ventanaadmin;
	static String Id_Producto;
	static String Nombre;
	static String Precio;
	static String Categoria;
	
	/**
	 * Crea la ventana.
	 */

	public VentanaModificar1(Producto p, ConexionBBDD conexion, VentanaAdmin ventanaadmin) {
		this.p = p;
		this.conexion = conexion;
		this.ventanaadmin = ventanaadmin;
	}

	
	/**
	 * Inicializa los componentes de la ventana.
	 */
	public void AbrirVentanaModificar1() {
		setBounds(100, 100, 450, 342);
		getContentPane().setLayout(null);
		setTitle("Modificar Producto");
		getContentPane().setBackground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		
		JLabel lblIdproducto = new JLabel("Id_Producto");
		lblIdproducto.setBounds(47, 76, 73, 14);
		getContentPane().add(lblIdproducto);
		
		textField = new JTextField();
		textField.setBounds(130, 73, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(p.getId_Producto());
		textField.setEditable(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(47, 122, 46, 14);
		getContentPane().add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 119, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(p.getNombre());
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(47, 161, 46, 14);
		getContentPane().add(lblPrecio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 158, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(p.getPrecio());
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(47, 202, 73, 14);
		getContentPane().add(lblCategoria);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 199, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(p.getCategoria());
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Id_Producto = textField.getText();
				Nombre = textField_1.getText();
				Precio = textField_2.getText();
				Categoria = textField_3.getText();
				
				Producto p = new Producto(Id_Producto,Nombre,Precio,Categoria); 
				conexion.ConsultaActualizaProducto(p);
				
			}
		});
		btnGuardar.setBounds(140, 253, 89, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.ConsultaBorrarProducto(p);
				
			}
		});
		btnBorrar.setBounds(239, 253, 89, 23);
		getContentPane().add(btnBorrar);

		textField_3.setEditable(false);
		textField.setEditable(false);
		
	}
}
