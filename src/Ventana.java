import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ventana {

	private static JFrame frmInicio;
	VentanaPedido ventanapedido;

	/**
	 * Lanza la app
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ventana();
					Ventana.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setTitle("Inicio");
		frmInicio.setIconImage(Toolkit.getDefaultToolkit().getImage("../App/src/55335.png"));
		frmInicio.getContentPane().setBackground(Color.ORANGE);
		frmInicio.setBounds(100, 100, 450, 320);
		frmInicio.getContentPane().setLayout(null);
		
		JButton btnAdministracin = new JButton("Administraci\u00F3n");
		btnAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaAdmin();
				VentanaAdmin.frmAdministracin.setVisible(true);
				frmInicio.setVisible(false);
		
			}
		});
		btnAdministracin.setFont(new Font("Calibri", Font.BOLD, 15));
		btnAdministracin.setBounds(10, 214, 414, 56);
		frmInicio.getContentPane().add(btnAdministracin);
		
		JButton btnComandas = new JButton("Comandas");
		btnComandas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VentanaPedido();
				VentanaPedido.frmVentanaDePedidos.setVisible(true);
				frmInicio.setVisible(false);
				
			}
		});
		btnComandas.setFont(new Font("Calibri", Font.BOLD, 15));
		btnComandas.setBounds(10, 36, 414, 167);
		frmInicio.getContentPane().add(btnComandas);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setFont(new Font("Calibri", Font.BOLD, 15));
		lblOpciones.setBounds(194, 11, 78, 14);
		frmInicio.getContentPane().add(lblOpciones);
	}

	public static void setVisible(boolean visible) {
		frmInicio.setVisible(visible);
	}

	
}
