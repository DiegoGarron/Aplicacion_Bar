import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class VentanaAñadirProductosCategoria {

	JFrame frmNuevoProducto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Producto p;
	public ConexionBBDD conexion;
	static String Id_Producto;
	static String Nombre;
	static String Precio;
	static String Categoria;
	private JTextField textField_4;
	static String Id_Categoria;
	static String Tipo;

	

	/**
	 * Crea la ventana.
	 */
	public VentanaAñadirProductosCategoria(ConexionBBDD conexion) {
		this.conexion = conexion;
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	private void initialize() {
		frmNuevoProducto = new JFrame();
		frmNuevoProducto.getContentPane().setBackground(Color.ORANGE);
		frmNuevoProducto.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmNuevoProducto.setForeground(Color.ORANGE);
		frmNuevoProducto.setTitle("Nuevo Producto");
		frmNuevoProducto.getContentPane().setForeground(Color.BLACK);
		frmNuevoProducto.setBounds(100, 100, 450, 300); 
		frmNuevoProducto.getContentPane().setLayout(null);
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(125, 54, 46, 14);
		frmNuevoProducto.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(209, 51, 97, 20);
		frmNuevoProducto.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(125, 82, 46, 14);
		frmNuevoProducto.getContentPane().add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(209, 79, 97, 20);
		frmNuevoProducto.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(125, 107, 76, 14);
		frmNuevoProducto.getContentPane().add(lblCategoria);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(209, 106, 97, 20);
		frmNuevoProducto.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(new Color(34, 139, 34));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					Id_Producto = textField_4.getText();
					Nombre = textField.getText();
					Precio = textField_1.getText();
					Categoria = textField_2.getText();
				
					Producto p = new Producto(Id_Producto,Nombre,Precio,Categoria); 
					conexion.ConsultaAñadirProducto(p);
				
				frmNuevoProducto.setVisible(false);
				VentanaAdmin.setVisible(true);
			}
		});
		btnAadir.setBounds(88, 161, 114, 60);
		frmNuevoProducto.getContentPane().add(btnAadir);
		
		JButton btnBorrar = new JButton("Borrar Campos");
		btnBorrar.setBackground(new Color(204, 0, 0));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_4.setText(null);
				
			}
		});
		btnBorrar.setBounds(248, 161, 124, 60);
		frmNuevoProducto.getContentPane().add(btnBorrar);
		
		JButton button = new JButton("<- Atras");
		button.setBackground(new Color(176, 224, 230));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNuevoProducto.setVisible(false);
				VentanaAdmin.setVisible(true);
			}
		});
		button.setBounds(335, 227, 89, 23);
		frmNuevoProducto.getContentPane().add(button);
		
		JLabel lblIdproducto = new JLabel("Id_Producto");
		lblIdproducto.setBounds(125, 27, 91, 14);
		frmNuevoProducto.getContentPane().add(lblIdproducto);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(209, 24, 97, 20);
		frmNuevoProducto.getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}
}
