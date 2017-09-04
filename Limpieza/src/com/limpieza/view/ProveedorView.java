package com.limpieza.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.Conexion;
import com.limpieza.control.ProveedorCtrl;
import com.limpieza.entity.Proveedor;
import com.limpieza.view.Menus.MenusProveedor;

public class ProveedorView {

	private Scanner scanner;
	private Proveedor proveedor;
	private ProveedorCtrl proveedorCtrl;

	public ProveedorView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		proveedorCtrl = new ProveedorCtrl(conexion);

	}

	public void insertar() {
		
		String NIT;
		String empresa;
		String nombre;
		int telefono;
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		empresa = ReadTypes.leerCadena(scanner, "Ingrese la empresa : ");
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		telefono = ReadTypes.leerEntero(scanner, "Ingrese el numero telefonico: ");
		proveedor = new Proveedor(NIT, empresa, nombre, telefono);

		try {
			proveedorCtrl.insert(proveedor);
			System.out.println("Proveedor registrado con éxito!");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Proveedor> proveedores;

		try {
			proveedores = proveedorCtrl.list();
			for (int i = 0; i < proveedores.size(); i++) {
				System.out.println(proveedores.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {

		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del proveedor que desea buscar: ");

		proveedor = new Proveedor(codigo);
		try {
			proveedorCtrl.search(proveedor);
			System.out.println(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {

		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del proveedor a modificar: ");

		proveedor = new Proveedor(codigo);
		try {
			proveedorCtrl.search(proveedor);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusProveedor.menuModificar(scanner, proveedor);

		try {
			proveedorCtrl.update(proveedor);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
