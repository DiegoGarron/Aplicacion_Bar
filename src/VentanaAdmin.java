import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class VentanaAdmin {

	static JFrame frmAdministracin;
	private JTable table;
	public ArrayList<Producto> ListaProductos;
	ConexionBBDD Prueba;
	protected Object frmIncio;

	/**
	 * Crea la ventana.
	 */
	public VentanaAdmin() {
		 Prueba = new ConexionBBDD();
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	private void initialize() {
		frmAdministracin = new JFrame();
		frmAdministracin.getContentPane().setBackground(Color.ORANGE);
		frmAdministracin.setTitle("Administraci\u00F3n");
		frmAdministracin.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmAdministracin.setBounds(100, 100, 749, 407);
		frmAdministracin.getContentPane().setLayout(null);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(new Color(34, 139, 34));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAñadirProductosCategoria window = new VentanaAñadirProductosCategoria(Prueba);
				window.frmNuevoProducto.setVisible(true);
				frmAdministracin.setVisible(false);
			}
		});
		btnAadir.setBounds(229, 251, 102, 58);
		frmAdministracin.getContentPane().add(btnAadir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(144, 238, 144));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(Prueba.ConsultaTablaProductos());
			
			}
		});
		btnListar.setBounds(375, 251, 102, 58);
		frmAdministracin.getContentPane().add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 36, 560, 172);
		frmAdministracin.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table.rowAtPoint(e.getPoint());
				Producto p = new Producto(null, null, null, null);
				p.setId_Producto((String)table.getValueAt(seleccion, 0));
				p.setNombre((String) table.getValueAt(seleccion, 1));
				p.setPrecio((String) table.getValueAt(seleccion, 2));
				p.setCategoria((String) table.getValueAt(seleccion, 3));
				
				VentanaModificar1 prueba1 = new VentanaModificar1(p, Prueba, null);
				prueba1.setVisible(true);
				prueba1.AbrirVentanaModificar1();
				frmAdministracin.setVisible(false);
				
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id_Producto", "Nombre", "Precio", "Categoria"
			}
		));
		table.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane.setViewportView(table);
		
		JLabel lblAdministracinDeProductos = new JLabel("Administraci\u00F3n de Productos");
		lblAdministracinDeProductos.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAdministracinDeProductos.setBounds(280, 11, 201, 14);
		frmAdministracin.getContentPane().add(lblAdministracinDeProductos);
		
		JButton button = new JButton("<- Atras");
		button.setBackground(new Color(176, 224, 230));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdministracin.setVisible(false);
				Ventana.setVisible(true);
				
			}
		});
		button.setBounds(634, 334, 89, 23);
		frmAdministracin.getContentPane().add(button);
	}

	public static void setVisible(boolean visible) {
		// TODO Apéndice de método generado automáticamente
		frmAdministracin.setVisible(visible);
	}
	
	
	
}
