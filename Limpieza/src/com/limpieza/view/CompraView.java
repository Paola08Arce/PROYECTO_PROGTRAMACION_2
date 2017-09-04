package com.limpieza.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.limpieza.control.CompraCtrl;
import com.limpieza.control.Conexion;
import com.limpieza.entity.Compra;

public class CompraView {

	private Scanner scanner;
	private Compra compra;
	private CompraCtrl compraCtrl;

	public CompraView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		compraCtrl = new CompraCtrl(conexion);

	}

	public void insertar() {

		String NIT;
		Date fecha;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del proveedor: ");
		fecha = new Date();

		compra = new Compra(fecha, NIT);

		try {
			compraCtrl.insert(compra);
			System.out.println("Compra realizada con exito!!");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Compra> compras;

		try {
			compras = compraCtrl.list();
			for (int i = 0; i < compras.size(); i++) {
				System.out.println(compras.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar(int codigo) {

		compra = new Compra(codigo);
		try {
			compraCtrl.search(compra);
			System.out.println(compra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
