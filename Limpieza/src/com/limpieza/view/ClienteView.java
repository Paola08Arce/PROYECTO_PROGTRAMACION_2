package com.limpieza.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.limpieza.control.ClienteCtrl;
import com.limpieza.control.Conexion;
import com.limpieza.control.Repetido;
import com.limpieza.entity.Cliente;
import com.limpieza.view.Menus.MenusCliente;

public class ClienteView {

	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;

	public ClienteView(Conexion conexion, Scanner scanner) {

		this.scanner = scanner;
		clienteCtrl = new ClienteCtrl(conexion);

	}

	public void insertar() throws SQLException {
		String NIT;
		String nombre;
		int telefono;
		boolean rep;
		String instruccionSQL;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a verificar: ");
		instruccionSQL = "SELECT * FROM cliente where cliente.NIT = '" + NIT + "' ";
		rep = Repetido.verificar(instruccionSQL);
		if (rep = Repetido.verificar(instruccionSQL)) {
			System.out.println("El NIT ingresado ya fue registrado!");

		} else {
			System.out.println("El cliente no fue registrado aún");
			System.out.println("Ingrese los datos para el registro: ");

			nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre Personal o de la Empresa: ");
			telefono = ReadTypes.leerEntero(scanner, "Ingrese el número telefónico: ");

			cliente = new Cliente(NIT, nombre, telefono);

			try {
				clienteCtrl.insert(cliente);
				System.out.println("Registro de cliente exitosamente!");
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void listar() {
		ArrayList<Cliente> clientes;

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println(clientes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar() {
		String NIT;
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente que desea buscar:  ");

		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
			System.out.println("Cliente encontrado...!");
			System.out.println(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		String NIT;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar: ");

		cliente = new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCliente.menuModificar(scanner, cliente);

		try {
			clienteCtrl.update(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
