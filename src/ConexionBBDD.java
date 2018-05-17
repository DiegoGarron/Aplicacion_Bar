import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;


public class ConexionBBDD {

	private String url;
	private String usr;
	private String pwd;
	private String esquema;
	private Connection conexion;
	

	public ConexionBBDD()  {
		
		FicheroINI();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public DefaultTableModel ConsultaTablaProductos() {
		String [] columnas={"Id_Producto", "Nombre", "Precio", "Categoria"};
		String [] registro=new String[4];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "select p.ID_PRODUCTO, p.NOMBRE, p.PRECIO, c.TIPO from "+ esquema +".PRODUCTOS p,"+ esquema +".CATEGORIA c where p.ID_CATEGORIA=c.ID_CATEGORIA order by p.ID_PRODUCTO";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Id_Producto");
		         registro[1]=rset.getString("Nombre");
		         registro[2]=rset.getString("Precio");
		         registro[3]=rset.getString("Tipo");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}

	public int ConsultaActualizaProducto(Producto p) {
		String Id_Producto = p.getId_Producto();
		int resultado =0;
		
		String query = "UPDATE "+ esquema +".productos SET NOMBRE='"+p.getNombre()+"', PRECIO="+p.getPrecio()+" WHERE Id_Producto='"+Id_Producto+"'";
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return resultado;
	}
	
	public int ConsultaBorrarProducto(Producto p) {
		String Id_Producto = p.getId_Producto();

		int resultado = 0;
		
		String query = "DELETE FROM "+ esquema +".productos WHERE Id_Producto='"+ Id_Producto+"'";
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public int ConsultaAñadirProducto(Producto p) {
		
		int resultado = 0;
		
		String query = "INSERT INTO "+ esquema +".productos VALUES ("+p.getId_Producto()+",'"+p.getNombre()+"',"+p.getPrecio()+","+p.getCategoria()+")";
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return resultado;
		
	}
    
    public void FicheroINI() {
    	 Properties properties = new Properties();
		 InputStream entrada = null;
		 try {
		    	File miFichero = new File("src/app.ini");
		    	if(miFichero.exists()) {
		    		entrada = new FileInputStream(miFichero);
		    		properties.load(entrada);
		    		url = properties.getProperty("dbhost");
		    		usr = properties.getProperty("dbuser");
		    		pwd = properties.getProperty("dbpassword");
		    		esquema = properties.getProperty("dbname");
		    	}
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    } finally {
		        if (entrada != null) {
		            try {
		            	entrada.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
    	}
    
    public DefaultTableModel ConsultaMostrarDatosCuentaMesa() {
		String [] columnas={"Id_Cuenta", "Precio_Total", "Total_Productos", "Id_Mesa"};
		String [] registro=new String[4];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		
		String query = "select c.ID_CUENTA, c.PRECIO_TOTAL, c.TOTAL_PRODUCTOS, c.ID_MESA from "+ esquema +".CUENTA c,"+ esquema +".MESA m where c.ID_MESA=m.ID_MESA order by ID_CUENTA";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Id_Cuenta");
		         registro[1]=rset.getString("Precio_Total");
		         registro[2]=rset.getString("Total_Productos");
		         registro[3]=rset.getString("Id_Mesa");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
    
   
    
	}