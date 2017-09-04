package com.limpieza.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.control.DetalleCompraCtrl;
import com.limpieza.entity.DetalleCompra;

public class DetalleCompraView {

	private Scanner scanner;
	private DetalleCompra detalleCompra;
	private DetalleCompraCtrl detalleCompraCtrl;

	public DetalleCompraView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		detalleCompraCtrl = new DetalleCompraCtrl(conexion);

	}

	public void insertar() {

		String nombreProducto;
		int cantidad;

		nombreProducto = ReadTypes.leerCadena(scanner, "Ingrese nombre del producto: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese la cantidad: ");
		detalleCompra = new DetalleCompra(nombreProducto, cantidad);

		try {
			detalleCompraCtrl.insert(detalleCompra);
			System.out.println("Detalle registrado exitosamente! ");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
	
		ArrayList<DetalleCompra> detalleCompras;

		try {
			detalleCompras = detalleCompraCtrl.list();
			for (int i = 0; i < detalleCompras.size(); i++) {
				if(detalleCompras.size() != 0){
					System.out.println(detalleCompras.get(i));
				} else{
					System.out.println("No existen detalles de compras");
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
		
		codigo= ReadTypes.leerEntero(scanner, "Ingrese código del producto: ");

		detalleCompra = new DetalleCompra(codigo);
		try {
			detalleCompraCtrl.search(detalleCompra);
			System.out.println(detalleCompra);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
