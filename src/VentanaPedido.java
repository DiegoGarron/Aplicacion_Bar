import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public class VentanaPedido {

	static JFrame frmVentanaDePedidos;
	VentanaAñadirCuenta añadircuenta;
	private JTable table_3;
	public ConexionBBDD conexion;

	

	/**
	 * Crea la ventana.
	 */
	public VentanaPedido() {
		conexion = new ConexionBBDD();
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmVentanaDePedidos = new JFrame();
		frmVentanaDePedidos.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmVentanaDePedidos.setTitle("Ventana de Pedidos");
		frmVentanaDePedidos.getContentPane().setBackground(Color.ORANGE);
		frmVentanaDePedidos.setBounds(100, 100, 443, 399);
		frmVentanaDePedidos.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
			
		});
		comboBox.setBounds(10, 67, 152, 47);
		comboBox.setBackground(Color.MAGENTA);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5", "Mesa 6"}));
		frmVentanaDePedidos.getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("Nueva Cuenta");
		btnNewButton.setBounds(10, 11, 402, 45);
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				VentanaAñadirCuenta añadircuenta = new VentanaAñadirCuenta();
				añadircuenta.frmNuevaCuenta.setVisible(true);
				frmVentanaDePedidos.setVisible(false);
			}
		});
		frmVentanaDePedidos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir Pedido");
		btnNewButton_1.setBounds(172, 67, 240, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAñadirPedido window = new VentanaAñadirPedido();
				window.frmAadirPedido.setVisible(true);
				frmVentanaDePedidos.setVisible(false);
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		frmVentanaDePedidos.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("<- Atras");
		button.setBounds(323, 296, 89, 53);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVentanaDePedidos.setVisible(false);
				Ventana.setVisible(true);
			}
		});
		button.setBackground(new Color(176, 224, 230));
		frmVentanaDePedidos.getContentPane().add(button);
		
		JButton btnListar = new JButton("Mostrar");
		btnListar.setBounds(323, 125, 89, 160);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_3.setModel(conexion.ConsultaMostrarDatosCuentaMesa());
			}
		});
		btnListar.setBackground(SystemColor.activeCaption);
		frmVentanaDePedidos.getContentPane().add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 303, 224);
		frmVentanaDePedidos.getContentPane().add(scrollPane);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table_3.rowAtPoint(e.getPoint());
				Cuenta c = new Cuenta(null, null, null, null);
				c.setId_Cuenta((String)table_3.getValueAt(seleccion, 0));
				c.setPrecio_Total((String)table_3.getValueAt(seleccion, 1));
				c.setTotal_Productos((String)table_3.getValueAt(seleccion, 2));
				c.setMesa((String)table_3.getValueAt(seleccion, 3));
				
				VentanaTicket ticket = new VentanaTicket(c, conexion, null);
				ticket.setVisible(true);
				ticket.AbrirVentanaTicket();
				frmVentanaDePedidos.setVisible(false);
			}
		});
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Id_Cuenta", "Precio_Total", "Total_Productos", "Mesa"
			}
		));
		table_3.getColumnModel().getColumn(2).setPreferredWidth(92);
		scrollPane.setViewportView(table_3);
		
		
	}
}
