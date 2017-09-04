package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.view.CategoriaView;

public class MenuCategoria {
	
	Scanner scanner = new Scanner(System.in);
	Conexion conexion = new Conexion();

	public static void Categoria(Conexion conexion, Scanner scanner) throws SQLException {
		
		CategoriaView categoriaView = new CategoriaView(conexion, scanner);
		
		int entrada;
		
		System.out.println("     MEN� CATEGOR�A:     ");
		System.out.println("----------------------");
		System.out.println("1. Insertar categor�a: ");
		System.out.println("2. Busca categor�a: ");
		System.out.println("3. Actualizar categor�a: ");
		System.out.println("4. Listar categor�a: ");
		
		entrada = scanner.nextInt();
		scanner.nextLine();

		switch (entrada) {
		case 1:
			categoriaView.insertar();
			break;

		case 2:
			categoriaView.buscar();
			break;
		case 3:
			categoriaView.actualizar();
			break;
		case 4:
			categoriaView.listar();
			break;
			
		default:
			break;

		}
	}


}
