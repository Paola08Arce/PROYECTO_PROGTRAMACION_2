package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.Cliente;

public class ClienteCtrl implements Control<Cliente> {
	private Conexion conexion;

	public ClienteCtrl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Cliente> list() throws Throwable {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ResultSet rs;
		String NIT;
		String nombre;
		int telefono;

		conexion.SQL("Select * from cliente");

		rs = conexion.resultSet();

		while (rs.next()) {
			NIT = rs.getString("NIT");
			nombre = rs.getString("nombre");
			telefono = rs.getInt("telefono");
			clientes.add(new Cliente(NIT, nombre, telefono));
		}

		return clientes;

	}

	public void insert(Cliente cliente) throws Throwable {

		conexion.SQL("Insert into cliente(NIT,nombre, telefono) VALUES(?,?,?)");

		conexion.preparedStatement().setString(1, cliente.getNIT());
		conexion.preparedStatement().setString(2, cliente.getNombre());
		conexion.preparedStatement().setInt(3, cliente.getTelefono());
		conexion.CUD();

	}

	public void search(Cliente cliente) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from cliente where NIT=?");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			cliente.setNombre(rs.getString("nombre"));
			cliente.setTelefono(rs.getInt("telefono"));
		}

		rs.close();

	}

	public void update(Cliente cliente) throws Throwable {
		String nombre;
		String NIT;
		int telefono;
		if (cliente != null) {
			nombre = cliente.getNombre();
			NIT = cliente.getNIT();
			telefono = cliente.getTelefono();

			conexion.SQL("Update cliente set nombre = ?, telefono=? where NIT=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setInt(2, telefono);
			conexion.preparedStatement().setString(3, NIT);
			conexion.CUD();
		}
	}

}
