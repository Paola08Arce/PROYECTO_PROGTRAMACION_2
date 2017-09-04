package com.limpieza.view.Menus;

import java.util.Scanner;

import com.limpieza.entity.Proveedor;
import com.limpieza.view.ReadTypes;

public class MenusProveedor {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar numero telefonico");
				System.out.println("3. Actualizar empresa");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 3) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void menuModificar(Scanner scanner, Proveedor proveedor) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(proveedor.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				proveedor.setNombre(nombre);
				break;
			case 2:
				System.out.print("Numero anterior: ");
				System.out.println(proveedor.getTelefono());
				int telefono = ReadTypes.leerEntero(scanner, "Ingrese el nuevo numero telefonico: ");
				proveedor.setTelefono(telefono);
				break;
			case 3:
				System.out.print("Empresa anterior: ");
				System.out.println(proveedor.getEmpresa());
				String empresa = ReadTypes.leerCadena(scanner, "Ingrese la nueva empresa: ");
				proveedor.setEmpresa(empresa);
				break;
			}
		}
	}
}
