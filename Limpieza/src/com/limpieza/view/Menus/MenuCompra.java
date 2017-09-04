package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;

public class MenuCompra {

	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Compra(Conexion conexion, Scanner scanner) throws SQLException {

		int entrada;

		System.out.println("     MENÚ COMPRA    ");
		System.out.println("----------------------");
		System.out.println("1. Proveedor");
		System.out.println("2. Producto");
		System.out.println("3. Categoría");
		System.out.println("4. Detalle de la compra");

		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			MenuProveedor.Proveedor(conexion, scanner);
			break;
		case 2:
			MenuProducto.Producto(conexion, scanner);
			break;
		case 3:
			MenuCategoria.Categoria(conexion, scanner);
			break;
		case 4:
			MenuDetalleCompra.Detalle(conexion, scanner);
			break;
		}
	}

}
