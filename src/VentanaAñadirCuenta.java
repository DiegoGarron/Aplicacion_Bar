import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class VentanaAñadirCuenta {

	static JFrame frmNuevaCuenta;
	VentanaPedido ventanapedido;

	/**
	 * Crea la ventana.
	 */
	public VentanaAñadirCuenta() {
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmNuevaCuenta = new JFrame();
		frmNuevaCuenta.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmNuevaCuenta.setTitle("Nueva Cuenta");
		frmNuevaCuenta.getContentPane().setBackground(Color.ORANGE);
		frmNuevaCuenta.setBounds(100, 100, 299, 290);
		frmNuevaCuenta.getContentPane().setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.MAGENTA);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5", "Mesa 6"}));
		comboBox.setBounds(10, 36, 118, 20);
		frmNuevaCuenta.getContentPane().add(comboBox);
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa");
		lblNumeroDeMesa.setBounds(10, 11, 118, 14);
		frmNuevaCuenta.getContentPane().add(lblNumeroDeMesa);
		
		JCheckBox chckbxDentro = new JCheckBox("Dentro");
		chckbxDentro.setBackground(new Color(176, 224, 230));
		chckbxDentro.setBounds(10, 88, 97, 23);
		frmNuevaCuenta.getContentPane().add(chckbxDentro);
		
		JCheckBox chckbxFuera = new JCheckBox("Fuera");
		chckbxFuera.setBackground(new Color(176, 224, 230));
		chckbxFuera.setBounds(10, 114, 97, 23);
		frmNuevaCuenta.getContentPane().add(chckbxFuera);
		
		JLabel lblLocalizacin = new JLabel("Localizaci\u00F3n");
		lblLocalizacin.setBounds(10, 67, 83, 14);
		frmNuevaCuenta.getContentPane().add(lblLocalizacin);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBackground(new Color(34, 139, 34));
		btnCrearCuenta.setBounds(10, 144, 118, 98);
		frmNuevaCuenta.getContentPane().add(btnCrearCuenta);
		
		JButton button = new JButton("<- Atras");
		button.setBackground(new Color(176, 224, 230));
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				VentanaPedido ventanapedido = new VentanaPedido();
				ventanapedido.frmVentanaDePedidos.setVisible(true);
				frmNuevaCuenta.setVisible(false);
			}
		});
		button.setBounds(186, 221, 89, 23);
		frmNuevaCuenta.getContentPane().add(button);
	}

	public static void setVisible(boolean visible) {
		// TODO Apéndice de método generado automáticamente
		frmNuevaCuenta.setVisible(visible);
	}
}
