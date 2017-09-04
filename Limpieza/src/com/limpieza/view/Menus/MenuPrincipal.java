package com.limpieza.view.Menus;

import java.sql.SQLException;
import java.util.Scanner;
import com.limpieza.control.Conexion;
import com.limpieza.control.Pantalla;

public class MenuPrincipal {

	private int seleccion;

	private boolean ciclo = true;

	Scanner scanner = new Scanner(System.in);

	Conexion conexion;

	public void Principal() throws SQLException {

		do {
			try {
				conexion = new Conexion();
			} catch (Exception e) {
				System.out.println("Error conectando la base de datos");
				break;
			}
			System.out.println("MENU PRINCIPAL");
			System.out.println("Seleccione una opcion");
			System.out.println("-------------------------");
			System.out.println("1 - Compra");
			System.out.println("2- Venta");
			System.out.println("3- Salir");

			seleccion = scanner.nextInt();

			switch (seleccion) {

			case 1:
				MenuCompra.Compra(conexion, scanner);
				break;
			case 2:
				MenuVenta.Vent(conexion, scanner);
				break;
			case 3:
				this.salir();
				break;

			default:

			}

		} while (ciclo == true);
		Pantalla.bol = true;

	}

	private void salir() {
		scanner.close();
		System.out.println("Saliendo del programa");
		System.out.println("Vuelva pronto!");
		System.exit(0);
	}
}
