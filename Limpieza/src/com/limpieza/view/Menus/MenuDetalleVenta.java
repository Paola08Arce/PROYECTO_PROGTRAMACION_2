package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;
import com.limpieza.view.DetalleVentaView;

public class MenuDetalleVenta {
	
	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void DetalleVenta(Conexion conexion, Scanner scanner) throws SQLException {

		DetalleVentaView detalleVentaView = new DetalleVentaView(conexion, scanner);

		int entrada;

		System.out.println("     DETALLE DE VENTAS REALIZADAS:     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar detalle: ");
		System.out.println("2. Busca detalle: ");
		System.out.println("3. Listar detalle: ");
		
		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			detalleVentaView.insertar();
			break;

		case 2:
			detalleVentaView.buscar();
			break;
		
		case 3:
			detalleVentaView.listar();
			break;
		default:
			break;

		}
	}


}
