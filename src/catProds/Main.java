package catProds;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Productos Envasados:
		Producto prod1 = new Producto("Verde", 2000);
		Producto prod2 = new Producto("Azul", 5000);
		Producto prod3 = new Producto("Gris", 10000);
		Producto prod4 = new Producto("Negro", 2);
		Producto prod5 = new Producto("Rojo", 1000);
		Producto prod6 = new Producto("Amarillo", 19000);
		Producto prod7 = new Producto("Verde", 100);
		Producto prod8 = new Producto("Amarillo", 1000);
		Producto prod9 = new Producto("Rojo", 500);

		// Productos Congelados:
		Producto prod10 = new Producto("Lila", 10000);

		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		ArrayList<Producto> productos2 = new ArrayList<Producto>();
		ArrayList<Producto> productos3 = new ArrayList<Producto>();
		ArrayList<Producto> productos4 = new ArrayList<Producto>();
		ArrayList<Producto> productos5 = new ArrayList<Producto>();

		// LOS GENERALES SIGNIFICA QUE NO TIENEN UNA SUBCATEGORÍA
		// Productos Envasados Generales:
		productos1.add(prod1);
		productos1.add(prod2);

		// Productos Envasados Nacionales Generales:
		productos2.add(prod3);
		productos2.add(prod4);

		// Productos Envasados Importados Generales:
		productos3.add(prod5);
		productos3.add(prod6);

		// Productos Envasados Importados Europeos:
		productos4.add(prod7);
		productos4.add(prod8);
		productos4.add(prod9);

		// Productos Congelados Generales:
		productos5.add(prod10);

		// PARA LEER: LAS PARTES QUE TIENEN PARÉNTESIS EN ESTE MENSAJE SIGNIFICAN EL
		// NIVEL DE LA CATEGORÍA
		// ENTRE MÁS ALTO, MENOS NIVEL TIENE
		// Los arraylists de productos de 1 a 4 pertenecen a la categoría de envasados
		// Más a fondo, productos1 pertenece a la general de envasados; productos2
		// pertenece a la subcategoría(1) de nacionales;
		// productos3 pertenece a la general de la subcategoría (1) de importados,
		// mientras que productos 4 pertenece a la
		// subcategoría (2), es decir dentro de catImportados, donde están los europeos;
		// ya, finalizando por productos5, está en la
		// general de la categoría de los congelados, el cual está en el mismo nivel de
		// la categoría envasados.

		ArrayList<Categoria> catEnvasados = new ArrayList<Categoria>();
		ArrayList<Categoria> catCongelados = new ArrayList<Categoria>();
		ArrayList<Categoria> catImportados = new ArrayList<Categoria>();

		Categoria subCat3 = new Categoria("Europeos", null, productos4);

		catImportados.add(subCat3);

		Categoria subCat1 = new Categoria("Nacionales", null, productos2);
		Categoria subCat2 = new Categoria("Importados", catImportados, productos3);

		catEnvasados.add(subCat1);
		catEnvasados.add(subCat2);

		Categoria envasados = new Categoria("Envasados", catEnvasados, productos1);
		Categoria congelados = new Categoria("Congelados", null, productos5);

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		categorias.add(congelados);
		categorias.add(envasados);

		Empresa empresa = new Empresa("ACME", categorias);

		// TANTO LA FUNCIÓN DE ENCONTRAR EL PRODUCTO CON TAL COLOR Y SABER LA
		// CANTIDAD DE PRODUCTOS CON UN COLOR
		// SOLO FUNCIONAN CON UNA CATEGORÍA EN ESPECÍFICO, YA TOCARÍA HACER UN FOR PARA
		// RECORRER LAS DOS CATEGORÍAS
		// DENTRO DE LA EMPRESA, MIENTRAS SE QUEDA ASÍ

		String color = JOptionPane.showInputDialog("Ingrese el color a saber");

		Boolean colorExists = (empresa.encontrarProductoColor(color, envasados, 0, 0));
		if (colorExists) {

			JOptionPane.showMessageDialog(null, "El color " + color.toLowerCase() + " existe dentro del inventario");

		} else {

			JOptionPane.showMessageDialog(null, "El color " + color.toLowerCase() + " NO existe dentro del inventario");

		}

		int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio a saber"));

		int cantProductosMayorExists = (empresa.encontrarProductoMayorA(precio, envasados, 0, 0, 0));

		if (cantProductosMayorExists > 0) {

			if (cantProductosMayorExists == 1) {

				JOptionPane.showMessageDialog(null,
						"Hay " + cantProductosMayorExists + " producto con precio mayor o igual a $" + precio);

			} else {

				JOptionPane.showMessageDialog(null,
						"Hay " + cantProductosMayorExists + " productos con precio mayor o igual a $" + precio);

			}
		} else {

			JOptionPane.showMessageDialog(null, "No hay productos mayores o iguales a $" + precio);

		}

	}

}
