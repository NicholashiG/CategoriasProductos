package catProds;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Producto prod1 = new Producto("Verde", 12000);
		Producto prod2 = new Producto("Verde", 1000);
		Producto prod3 = new Producto("Gris", 5000);
		Producto prod4 = new Producto("Negro", 17000);
		Producto prod5 = new Producto("Rojo", 8000);
		Producto prod6 = new Producto("Amarillo", 9000);
		Producto prod7 = new Producto("Verde", 3000);
		Producto prod8 = new Producto("Amarillo", 1000);
		Producto prod9 = new Producto("Rojo", 500);

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
		productos5.add(prod9);

		ArrayList<Categoria> catEnvasados = new ArrayList<Categoria>();
		ArrayList<Categoria> catCongelados = new ArrayList<Categoria>();
		ArrayList<Categoria> catImportados = new ArrayList<Categoria>();

		Categoria subCat3 = new Categoria("Europeos", null, productos3);

		catImportados.add(subCat3);

		Categoria subCat1 = new Categoria("Nacionales", null, productos2);
		Categoria subCat2 = new Categoria("Importados", catImportados, null);

		catEnvasados.add(subCat1);
		catEnvasados.add(subCat2);

		Categoria envasados = new Categoria("Envasados", catEnvasados, productos1);
		Categoria congelados = new Categoria("Congelados", null, productos5);

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		categorias.add(congelados);
		categorias.add(envasados);

		Empresa empresa = new Empresa("ACME", categorias);
				
		System.out.println(empresa.encontrarProductoColor("Amarillo", envasados, 0, 0));
		

	}

}
