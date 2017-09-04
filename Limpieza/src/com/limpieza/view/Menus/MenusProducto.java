package com.limpieza.view.Menus;

import java.util.Scanner;

import com.limpieza.entity.Producto;
import com.limpieza.view.ReadTypes;

public class MenusProducto {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar Nombre");
				System.out.println("2. Actualizar precio");
				System.out.println("3. Actualizar codigo de categoria");
				System.out.println("4. Actualizar stock");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void menuModificar(Scanner scanner, Producto producto) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(producto.getNombre());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo valor de nombre: ");
				producto.setNombre(nombre);
				break;
			case 2:
				System.out.print("Precio anterior: ");
				System.out.println(producto.getPrecio());
				double precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio: ");
				producto.setPrecio(precio);
				break;
			case 3:
				System.out.println("Codigo de categoria");
				System.out.println(producto.getCodigoCategoria());
				int codigoCategoria = ReadTypes.leerEntero(scanner, "Ingrese el nuevo codigo de categoria");
				producto.setCodigoCategoria(codigoCategoria);
				break;
			case 4:
				System.out.println("Stock anterior");
				System.out.println(producto.getStock());
				int stock = ReadTypes.leerEntero(scanner, "Ingrese el nuevo stock disponible");
				producto.setStock(stock);
				break;

			}
		}
	}
}
