package com.limpieza.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.control.DetalleVentaCtrl;
import com.limpieza.entity.DetalleVenta;

public class DetalleVentaView {

	private Scanner scanner;
	private DetalleVenta detalleVenta;
	private DetalleVentaCtrl detalleVentaCtrl;

	public DetalleVentaView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		detalleVentaCtrl = new DetalleVentaCtrl(conexion);

	}

	public void insertar() {

		int codigoProducto;
		int cantidad;

		codigoProducto = ReadTypes.leerEntero(scanner, "Ingrese el codigo del producto: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");

		detalleVenta = new DetalleVenta(codigoProducto, cantidad);

		try {
			detalleVentaCtrl.insert(detalleVenta);
			System.out.println("Producto ingresado exitosamente! :)");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<DetalleVenta> detallesVenta;

		try {

			detallesVenta = detalleVentaCtrl.list();
			for (int i = 0; i < detallesVenta.size(); i++) {
				if (detallesVenta.size() != 0) {
					System.out.println(detallesVenta.get(i));
				} else {
					System.out.println("No existe nungun registro de detalle de venta");
					System.out.println("Por favor ingrese uno: ");
					this.insertar();
				}
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {

		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del producto que desea buscar: ");

		detalleVenta = new DetalleVenta(codigo);
		try {
			detalleVentaCtrl.search(detalleVenta);
			System.out.println(detalleVenta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
