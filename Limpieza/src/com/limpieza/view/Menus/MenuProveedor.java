package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;
import com.limpieza.view.ProveedorView;

public class MenuProveedor {

	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Proveedor(Conexion conexion, Scanner scanner) throws SQLException {

		ProveedorView proveedorView = new ProveedorView(conexion, scanner);
		int entrada;
		System.out.println("     MENÚ PROVEEDOR     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar Proveedor");
		System.out.println("2. Busca Proveedor");
		System.out.println("3. Actualizar Proveedor");
		System.out.println("4. Listar Proveedor");
		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			proveedorView.insertar();
			break;

		case 2:
			proveedorView.buscar();
			break;
		case 3:
			proveedorView.actualizar();
			break;
		case 4:
			proveedorView.listar();
			break;
		default:
			break;

		}
	}
}
