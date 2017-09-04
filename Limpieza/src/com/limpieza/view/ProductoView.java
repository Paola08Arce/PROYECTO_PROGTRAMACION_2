package com.limpieza.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.control.ProductoCtrl;
import com.limpieza.entity.Producto;
import com.limpieza.view.Menus.MenusProducto;

public class ProductoView {

	private Scanner scanner;
	private Producto producto;
	private ProductoCtrl productoCtrl;

	public ProductoView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		productoCtrl = new ProductoCtrl(conexion);

	}

	public void insertar() {

		String nombre;
		String marca;
		double precio;
		int codigoCategoria;
		int stock;
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		marca = ReadTypes.leerCadena(scanner, "Ingrese la marca del producto: ");
		precio = ReadTypes.leerEntero(scanner, "Ingrese el precio: ");
		codigoCategoria = ReadTypes.leerEntero(scanner, "Ingrese codigo de categoría: ");
		stock = ReadTypes.leerEntero(scanner, " Ingrese el stock: ");
		producto = new Producto(nombre, marca, precio, codigoCategoria, stock);

		try {
			productoCtrl.insert(producto);
			System.out.println("Producto ingresado con exito!");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		ArrayList<Producto> productos;

		try {
			productos = productoCtrl.list();
			for (int i = 0; i < productos.size(); i++) {
				System.out.println(productos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {
		
		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del producto que desea buscar:  ");

		producto = new Producto(codigo);
		try {
			productoCtrl.search(producto);
			System.out.println(producto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		int codigo;

		codigo = ReadTypes.leerEntero(scanner, "Ingrese codigo del producto a modificar; ");

		producto = new Producto(codigo);
		try {
			productoCtrl.search(producto);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusProducto.menuModificar(scanner, producto);

		try {
			productoCtrl.update(producto);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
