package catProds;

public class Producto {

	public Producto(String color, int precio) {
		super();
		this.color = color;
		this.precio = precio;
	}

	private String color = "";
	private int precio = 0;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
