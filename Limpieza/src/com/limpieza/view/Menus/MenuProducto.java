package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;
import com.limpieza.view.ProductoView;

public class MenuProducto {

	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Producto(Conexion conexion, Scanner scanner) throws SQLException {
		
		ProductoView productoView = new ProductoView(conexion, scanner);
		int entrada;
		System.out.println("     MENÚ PRODUCTO     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar producto: ");
		System.out.println("2. Busca producto: ");
		System.out.println("3. Actualizar producto: ");
		System.out.println("4. Listar producto: ");
		
		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			productoView.insertar();
			break;

		case 2:
			productoView.buscar();
			break;
		case 3:
			productoView.actualizar();
			break;
		case 4:
			productoView.listar();
			break;
		default:
			break;

		}
	}

}
