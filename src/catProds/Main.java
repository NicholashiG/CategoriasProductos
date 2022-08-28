package catProds;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Producto prod1 = new Producto("Verde", 12000);
		Producto prod2 = new Producto("Azul", 1000);
		Producto prod3 = new Producto("Gris", 5000);
		Producto prod4 = new Producto("Negro", 17000);
		Producto prod5 = new Producto("Rojo", 8000);
		Producto prod6 = new Producto("Amarillo", 9000);
		Producto prod7 = new Producto("Verde", 3000);
		Producto prod8 = new Producto("Amarillo", 1000);
		Producto prod9 = new Producto("Rojo", 500);
		Producto prod10 = new Producto("Lila", 100);


		// Hay 2 productos mayores a 10000

		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		ArrayList<Producto> productos2 = new ArrayList<Producto>();
		ArrayList<Producto> productos3 = new ArrayList<Producto>();
		ArrayList<Producto> productos4 = new ArrayList<Producto>();
		ArrayList<Producto> productos5 = new ArrayList<Producto>();

		productos1.add(prod1);
		productos1.add(prod2);
		productos2.add(prod3);
		productos2.add(prod4);
		productos3.add(prod5);
		productos3.add(prod6);
		productos4.add(prod7);
		productos4.add(prod8);
		productos4.add(prod9);
		productos5.add(prod10);		

		ArrayList<Categoria> catEnvasados = new ArrayList<Categoria>();
		ArrayList<Categoria> catCongelados = new ArrayList<Categoria>();
		ArrayList<Categoria> catImportados = new ArrayList<Categoria>();


		Categoria subCat3 = new Categoria("Europeos", null, productos3);


		catImportados.add(subCat3);

		Categoria subCat1 = new Categoria("Nacionales", null, productos2);
		Categoria subCat2 = new Categoria("Importados", catImportados, productos5);

		catEnvasados.add(subCat1);
		catEnvasados.add(subCat2);

		Categoria envasados = new Categoria("Envasados", catEnvasados, productos1);
		Categoria congelados = new Categoria("Congelados", null, productos4);

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		categorias.add(congelados);
		categorias.add(envasados);

		Empresa empresa = new Empresa("ACME", categorias);
				
		Boolean colorExists = (empresa.encontrarProductoColor("Lila", envasados, 0, 0));
		if (colorExists) {
			System.out.println("El color solicitado existe dentro del inventario");
		}
		else {
			System.out.println("El color solicitado NO existe dentro del inventario");

		}
		

	}

}
