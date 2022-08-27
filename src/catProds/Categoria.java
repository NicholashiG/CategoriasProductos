package catProds;

import java.util.ArrayList;

public class Categoria {

	public Categoria(String nombre, ArrayList<Categoria> listaCategorias, ArrayList<Producto> listaProductos) {
		super();
		this.nombre = nombre;
		this.listaCategorias = listaCategorias;
		this.listaProductos = listaProductos;
	}

	private String nombre = "";
	private ArrayList<Categoria> listaCategorias = new ArrayList<>();
	private ArrayList<Producto> listaProductos = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
