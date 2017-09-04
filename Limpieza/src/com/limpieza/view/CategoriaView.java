package com.limpieza.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.CategoriaCtrl;
import com.limpieza.control.Conexion;
import com.limpieza.entity.Categoria;
import com.limpieza.view.Menus.MenusCategoria;

public class CategoriaView {

	private Scanner scanner;
	private Categoria categoria;
	private CategoriaCtrl categoriaCtrl;

	public CategoriaView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		categoriaCtrl = new CategoriaCtrl(conexion);

	}

	public void insertar() {

		String nombre;
		String descripcion = null;

		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripcion: ");

		categoria = new Categoria(nombre, descripcion);

		try {
			categoriaCtrl.insert(categoria);
			System.out.println("Ingresado con exito!");
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Categoria> categorias;

		try {
			categorias = categoriaCtrl.list();
			for (int i = 0; i < categorias.size(); i++) {
				System.out.println(categorias.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {
		int codigo;
		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la categoría que desea buscar: ");
		categoria = new Categoria(codigo);
		try {
			categoriaCtrl.search(categoria);
			System.out.println(categoria);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		int codigo;

		codigo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la categoría a modificar; ");

		categoria = new Categoria(codigo);
		try {
			categoriaCtrl.search(categoria);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCategoria.menuModificar(scanner, categoria);

		try {
			categoriaCtrl.update(categoria);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
