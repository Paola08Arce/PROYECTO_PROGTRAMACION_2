package com.limpieza.view.Menus;

import java.util.Scanner;

import com.limpieza.entity.Cliente;
import com.limpieza.view.ReadTypes;

public class MenusCliente {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar numero telefónico");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 2) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void menuModificar(Scanner scanner, Cliente cliente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(cliente.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				cliente.setNombre(nombre);
				break;
			case 2:
				System.out.print("Numero anterior: ");
				System.out.println(cliente.getTelefono());
				int telefono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo numero telefonico: ");
				cliente.setTelefono(telefono);
				break;
			}
		}
	}

}
