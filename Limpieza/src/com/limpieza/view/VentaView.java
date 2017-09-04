package com.limpieza.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.control.VentaCtrl;
import com.limpieza.entity.Venta;

public class VentaView {

	private Scanner scanner;
	private Venta venta;
	private VentaCtrl ventaCtrl;

	public VentaView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		ventaCtrl = new VentaCtrl(conexion);

	}

	public void insertar() {

		String NIT;
		Date fecha;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		fecha = new Date();

		venta = new Venta(NIT, fecha);

		try {
			ventaCtrl.insert(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Venta> Ventas;

		try {
			Ventas = ventaCtrl.list();
			for (int i = 0; i < Ventas.size(); i++) {
				System.out.println(Ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {
		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la venta que desea buscar: ");

		venta.setCodigo(codigo);
		try {
			ventaCtrl.search(venta);
			System.out.println(venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
