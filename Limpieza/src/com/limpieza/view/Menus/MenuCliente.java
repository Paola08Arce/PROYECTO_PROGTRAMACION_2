package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.limpieza.control.Conexion;

import com.limpieza.view.ClienteView;

public class MenuCliente {
	
	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Cliente(Conexion conexion, Scanner scanner) throws SQLException {

		int entrada;
		ClienteView clienteView = new ClienteView(conexion, scanner);

		System.out.println("     MENÚ CLIENTE     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar Cliente");
		System.out.println("2. Busca Cliente");
		System.out.println("3. Actualizar Cliente");
		System.out.println("4. Listar Cliente");
		
		entrada = scanner.nextInt();
		scanner.nextLine();
		
		switch (entrada) {
		case 1:
			clienteView.insertar();
			break;

		case 2:
			clienteView.buscar();
			break;
		case 3:
			clienteView.actualizar();
			break;
		case 4:
			clienteView.listar();
			break;
		default:
			break;
			
		}
	}

}
