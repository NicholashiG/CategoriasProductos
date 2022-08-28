package catProds;

import java.util.ArrayList;

public class Empresa {

	public Empresa(String nombre, ArrayList<Categoria> listaCategorias) {
		super();
		this.nombre = nombre;
		this.listaCategorias = listaCategorias;
	}

	private String nombre = "";
	private ArrayList<Categoria> listaCategorias = new ArrayList<>();

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

	public boolean encontrarProductoColor(String color, Categoria cat, int i, int j) {

		// Sacar los valores que tiene esa categoría sin ver si tiene más categorías.
		// Ya, se mira luego si tiene más categorías y en caso de que tenga, se ingresa
		// a la primera categoría y se hace lo mismo del principio.
		// Cuando no hayan más categorías bajo de esa, se sigue recorriendo la siguiente
		// categoría del nivel anterior, es decir, si estaba en la categoría cero, pasa
		// a la categoría 1
		// -------------------------------------

		System.out.println("Valor de i: " + i);
		System.out.println("Valor de j: " + j);

		if (cat.getListaProductos() != null) {
			if (j <= cat.getListaProductos().size() - 1) {

				if (cat.getListaProductos().get(j).getColor().equals(color)) {
					System.out.println("Entra al producto " + j);
					return true;
				}

				else {
					System.out.println("Entra al producto " + (j + 1));
					boolean a = encontrarProductoColor(color, cat, i, j + 1);
					if (a) {
						return true;
					}
				}
			}
		}

		if (cat.getListaCategorias() != null) {
			j = 0;
			int tam = cat.getListaCategorias().size();
			System.out.println("Tiene subcategorías: " + tam);

			if (i <= (tam - 1)) {
				System.out.println("Entra a la categoría " + i);
				if (encontrarProductoColor(color, cat.getListaCategorias().get(i), i, j)) {
					System.out.println("La categoría no tiene hermanas");
					return true;
				} else {
					if (i + 1 <= (tam - 1)) {
						System.out.println("Entra a la categoría " + (i + 1));
						if (encontrarProductoColor(color, cat.getListaCategorias().get(i + 1), i, j)) {
							System.out.println("La categoría tiene hermanas");
							return true;
						}

					}
				}

			}

		}

		// -------------------------------------

		/*
		 * 
		 * j = 0; Categoria subCat; subCat = cat.getListaCategorias().get(i);
		 * System.out.println(subCat.getNombre()); boolean a =
		 * encontrarProductoColor(color, subCat, i+1, j); if (a) { return true; } else {
		 * a = encontrarProductoColor(color, subCat, i+2, j); if (a) { return true; } }
		 * 
		 * 
		 * 
		 * 
		 * Categoria categ;
		 * 
		 * boolean x = false;
		 * 
		 * System.out.println("Valor de i: " + i); System.out.println("Valor de j: " +
		 * j);
		 * 
		 * if (cat.getListaCategorias() != null) {
		 * 
		 * if (i <= cat.getListaCategorias().size() - 1) {
		 * 
		 * if (j <= cat.getListaProductos().size() - 1) {
		 * 
		 * if (cat.getListaProductos().get(j).getColor().equals(color)) {
		 * System.out.println("Entra al producto x " + j);
		 * 
		 * return true; }
		 * 
		 * else { System.out.println("Entra al producto xx" + (j + 1)); x =
		 * encontrarProductoColor(color, cat, i, j + 1); if (x == true) { return true; }
		 * } }
		 * 
		 * j = 0;
		 * 
		 * categ = cat.getListaCategorias().get(i);
		 * System.out.println("Entra en la categoria " + i);
		 * 
		 * if (categ.getListaProductos() != null) {
		 * 
		 * if (i <= categ.getListaProductos().size() - 1) {
		 * 
		 * if (categ.getListaProductos().get(j).getColor().equals(color)) {
		 * System.out.println("Entra al producto " + j); return true;
		 * 
		 * }
		 * 
		 * else {
		 * 
		 * System.out.println("Entra al producto dentro de la categoria " + (i));
		 * 
		 * x = encontrarProductoColor(color, categ, i, j + 1); if (x == true) { return
		 * true; } else { System.out.println("Entra al hijo" + (i + 1));
		 * encontrarProductoColor(color, cat, i + 1, 0); } }
		 * 
		 * } }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * else {
		 *
		 * System.out.
		 * println("Entra a los productos porque no hay más categorías dentro");
		 * 
		 * if (j <= cat.getListaProductos().size() - 1) {
		 * 
		 * if (cat.getListaProductos().get(j).getColor().equals(color)) {
		 * System.out.println("Entra al producto x " + j);
		 * 
		 * return true; }
		 * 
		 * else { System.out.println("Entra al producto xx" + (j + 1)); x =
		 * encontrarProductoColor(color, cat, i, j + 1); if (x == true) { return true; }
		 * } } } System.out.println("Retorna falso y no entra a ninguna condición");
		 * return x;
		 */
		return false;

	}

	public void encontrarPrecioMayorA(int precio, Categoria cat) {

	}

}
