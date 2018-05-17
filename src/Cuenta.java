
public class Cuenta {

	public String Id_Cuenta;
	public String Precio_Total;
	public String Total_Productos;
	public String Mesa;
	
	public Cuenta(String id_Cuenta, String precio_Total, String total_Productos, String mesa) {
		super();
		Id_Cuenta = id_Cuenta;
		Precio_Total = precio_Total;
		Total_Productos = total_Productos;
		Mesa = mesa;
	}

	public String getId_Cuenta() {
		return Id_Cuenta;
	}

	public void setId_Cuenta(String id_Cuenta) {
		Id_Cuenta = id_Cuenta;
	}

	public String getPrecio_Total() {
		return Precio_Total;
	}

	public void setPrecio_Total(String precio_Total) {
		Precio_Total = precio_Total;
	}

	public String getTotal_Productos() {
		return Total_Productos;
	}

	public void setTotal_Productos(String total_Productos) {
		Total_Productos = total_Productos;
	}

	public String getMesa() {
		return Mesa;
	}

	public void setMesa(String mesa) {
		Mesa = mesa;
	}
	
	
}
