
public class Producto {

	private String Id_Producto;
	private String Nombre;
	private String Precio;
	private String Categoria;
	
	public Producto(String id_producto, String nombre, String precio, String categoria) {
		super();
		Id_Producto = id_producto;
		Nombre = nombre;
		Precio = precio;
		Categoria = categoria;
	}
   public String getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(String string) {
		Id_Producto = string;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String string) {
		Precio = string;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String string) {
		Categoria = string;
	}
	
	
}
