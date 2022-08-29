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

	// ---------------------------------------------------------------------
	// AQUÍ EMPIEZA LA LÓGICA

	public boolean encontrarProductoColor(String color, Categoria cat, int i, int j) {

		// ESTA ES LA LÓGICA PARA UNA CATEGORÍA EN ESPECÍFICO SIN TOMAR EN
		// CUENTA LAS OTRAS CATEGORÍAS, SOLO LOS PRODUCTOS
		if (cat.getListaProductos() != null) {
			// Revisa si tiene productos dentro
			if (j <= cat.getListaProductos().size() - 1) {
				// Compara a j para que no se desborde con el arraylist de productos
				if (cat.getListaProductos().get(j).getColor().equals(color)) {
					// Entra al producto j;
					return true;
				}

				else {
					// Entra al producto siguiente en caso de no encontrarlo
					boolean a = encontrarProductoColor(color, cat, i, j + 1);
					if (a) {
						// Si devuelve verdadero, que retorne verdadero
						return true;
					}
				}
			}
		}

		// AQUÍ EMPIEZA LA LÓGICA PARA RECORRER LAS CATEGORÍAS INTERNAS
		// EN CASO TAL DE QUE TENGA
		if (cat.getListaCategorias() != null) {
			// Mira si la lista de categorías no sea nula
			j = 0; // Se debe reiniciar j porque es una nueva categoría
			int tam = cat.getListaCategorias().size();
			// Tiene subcategorías de tamaño tam;

			if (i <= (tam - 1)) {
				// Compara que la i no se desborde del arraylist
				// Entra a la categoría i
				if (encontrarProductoColor(color, cat.getListaCategorias().get(i), i, j)) {
					// La categoría no tiene hermanas
					return true;
				} else {
					if (i + 1 <= (tam - 1)) {
						// Compara que exista una siguiente categoría
						// Entra a la categoría siguiente en caso de tener;
						if (encontrarProductoColor(color, cat.getListaCategorias().get(i + 1), i, j)) {
							// La categoría tiene hermanas
							return true;
						}

					}
				}

			}

		}

		// En caso de no encontrar ningún producto con tal color, devuelve falso
		return false;

	}

	public int encontrarProductoMayorA(int precio, Categoria cat, int i, int j, int cantidad) {

		// Esto es la cantidad acumulada de productos con precios mayores o iguales al
		// precio solicitado
		int cant = cantidad;

		// ESTA ES LA LÓGICA PARA UNA CATEGORÍA EN ESPECÍFICO SIN TOMAR EN
		// CUENTA LAS OTRAS CATEGORÍAS, SOLO LOS PRODUCTOS
		if (cat.getListaProductos() != null) {
			// Mira si la lista de los productos no es nula
			if (j <= cat.getListaProductos().size() - 1) {
				// Compara a j para que no se desborde con el arraylist de productos
				if (cat.getListaProductos().get(j).getPrecio() >= (precio)) {
					// Entra al producto j
					return ((cant + 1) + encontrarProductoMayorA(precio, cat, i, j + 1, cant));
					// Retorna la cantidad más uno en caso de que la condición se cumpla, y
					// adicionalmente se pasa
					// al siguiente producto y lo suma a la cantidad anterior
				}
			}

		}

		// AQUÍ EMPIEZA LA LÓGICA PARA RECORRER LAS CATEGORÍAS INTERNAS
		// EN CASO TAL DE QUE TENGA
		if (cat.getListaCategorias() != null) {
			j = 0; // Se debe reiniciar j porque es una nueva categoría
			int tam = cat.getListaCategorias().size();
			// Tiene subcategorías de tamaño tam;

			if (i <= (tam - 1)) {
				// Compara que la i no se desborde del arraylist
				// Entra a la categoría i

				int val = cant; // Es una variable local para sumar en caso de que tenga o no más categorías
								// En caso de que sí tenga, se le suma a val la cantidad retornada por la
								// función
				val = encontrarProductoMayorA(precio, cat.getListaCategorias().get(i), i, j, cant);
				if (i + 1 <= (tam - 1)) {
					// Compara que exista una siguiente categoría
					// Entra a la categoría siguiente en caso de tener;
					val += encontrarProductoMayorA(precio, cat.getListaCategorias().get(i + 1), i, j, cant);
					return val; // Retorna val en caso de que sí hayan categorías hermanas
				} else {
					return val; // Retorna val en caso de que no hayan categorías hermanas, porque si no,
								// queda sin sumarse ese valor
				}

			}

		}

		// Retorna la cantidad final en caso de no entrar a ninguna condición
		return cant;

	}
}

// ---------------------------------------------------------------------------------
// | Esta es la lógica en la cual me basé para solucionar el problema:			   |
// |-------------------------------------------------------------------------------|
// | Sacar los valores que tiene esa categoría sin ver si tiene más categorías.    |
// | Ya, se mira luego si tiene más categorías y en caso de que tenga, se ingresa  |
// | a la primera categoría y se hace lo mismo del principio.                      |
// | Cuando no hayan más categorías bajo de esa, se sigue recorriendo la siguiente |
// | categoría del nivel anterior, es decir, si estaba en la categoría cero, pasa  |
// | a la categoría 1                         									   |
// ---------------------------------------------------------------------------------
