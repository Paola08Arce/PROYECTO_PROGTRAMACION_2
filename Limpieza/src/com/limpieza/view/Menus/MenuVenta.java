package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;

public class MenuVenta {

	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Vent(Conexion conexion, Scanner scanner) throws SQLException {

		int entrada;

		System.out.println("     MENÚ VENTA    ");
		System.out.println("----------------------");
		System.out.println("1. Cliente");
		System.out.println("2. Producto");
		System.out.println("3. Categoría");
		System.out.println("4. Detalles de Venta");
		entrada = scanner.nextInt();

		switch (entrada) {
		case 1:
			MenuCliente.Cliente(conexion, scanner);
			break;
		case 2:
			MenuProducto.Producto(conexion, scanner);
			break;
		case 3:
			MenuCategoria.Categoria(conexion, scanner);
			break;
		case 4:
			MenuDetalleVenta.DetalleVenta(conexion, scanner);
			break;

		}
	}

}
