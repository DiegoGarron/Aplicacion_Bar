import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


@SuppressWarnings("unused")
public class VentanaAñadirPedido {

	JFrame frmAadirPedido;
	private JTable table;
	private JTextField textField;
	VentanaPedido ventanapedido;

	/**
	 * Crea la ventana.
	 */
	public VentanaAñadirPedido() {
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmAadirPedido = new JFrame();
		frmAadirPedido.setTitle("A\u00F1adir Pedido");
		frmAadirPedido.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmAadirPedido.getContentPane().setBackground(Color.ORANGE);
		frmAadirPedido.setBounds(100, 100, 575, 535);
		frmAadirPedido.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.MAGENTA);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Categoria", "Bebida", "Comida", "Postre"}));
		comboBox.setBounds(10, 50, 146, 31);
		frmAadirPedido.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 416, 256);
		frmAadirPedido.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Cantidad", "Precio por unidad", "Precio"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAadirACuenta = new JButton("A\u00F1adir a cuenta");
		btnAadirACuenta.setBackground(new Color(34, 139, 34));
		btnAadirACuenta.setBounds(168, 177, 132, 45);
		frmAadirPedido.getContentPane().add(btnAadirACuenta);
		
		JButton button = new JButton("<- Atras");
		button.setBackground(new Color(176, 224, 230));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				frmAadirPedido.setVisible(false);
				VentanaPedido ventanapedido = new VentanaPedido();
				ventanapedido.frmVentanaDePedidos.setVisible(true);;
				
			}
		});
		button.setBounds(436, 466, 109, 23);
		frmAadirPedido.getContentPane().add(button);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(204, 0, 0));
		btnBorrar.setBounds(436, 232, 109, 81);
		frmAadirPedido.getContentPane().add(btnBorrar);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 199, 89, 23);
		frmAadirPedido.getContentPane().add(spinner);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 177, 46, 14);
		frmAadirPedido.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(317, 199, 109, 23);
		frmAadirPedido.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total pedido");
		lblTotal.setBounds(317, 177, 109, 14);
		frmAadirPedido.getContentPane().add(lblTotal);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(50, 205, 50));
		btnListar.setBounds(436, 324, 109, 81);
		frmAadirPedido.getContentPane().add(btnListar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 50, 132, 31);
		frmAadirPedido.getContentPane().add(comboBox_1);
		
	
	}
}
