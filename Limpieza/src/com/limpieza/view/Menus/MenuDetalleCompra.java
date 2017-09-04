package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.view.DetalleCompraView;

public class MenuDetalleCompra {

	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Detalle(Conexion conexion, Scanner scanner) throws SQLException {

		DetalleCompraView detalleCompraView = new DetalleCompraView(conexion, scanner);

		int entrada;

		System.out.println("     DETALLE DE COMPRAS REALIZADAS:     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar detalle: ");
		System.out.println("2. Busca detalle: ");
		System.out.println("3. Listar detalle: ");
		
		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			detalleCompraView.insertar();
			break;

		case 2:
			detalleCompraView.buscar();
			break;
		
		case 3:
			detalleCompraView.listar();
			break;
		default:
			break;

		}
	}

}
