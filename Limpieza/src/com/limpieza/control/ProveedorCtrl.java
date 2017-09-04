package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.Proveedor;

public class ProveedorCtrl implements Control<Proveedor> {
	private Conexion conexion;

	public ProveedorCtrl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Proveedor> list() throws Throwable {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		ResultSet rs;

		String NIT;
		String nombre;
		int telefono;
		String empresa;

		conexion.SQL("Select * from proveedor");

		rs = conexion.resultSet();

		while (rs.next()) {

			NIT = rs.getString("NIT");
			empresa = rs.getString("Empresa");
			nombre = rs.getString("nombre");
			telefono = rs.getInt("telefono");
			proveedores.add(new Proveedor(NIT, empresa, nombre, telefono));
		}

		return proveedores;

	}

	public void insert(Proveedor proveedor) throws Throwable {

		conexion.SQL("Insert into proveedor(NIT, empresa, nombre, telefono) VALUES(?,?,?,?)");

		conexion.preparedStatement().setString(1, proveedor.getNIT());
		conexion.preparedStatement().setString(2, proveedor.getEmpresa());
		conexion.preparedStatement().setString(3, proveedor.getNombre());
		conexion.preparedStatement().setInt(4, proveedor.getTelefono());
		conexion.CUD();

	}

	public void search(Proveedor proveedor) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from proveedor where Codigo=?");
		conexion.preparedStatement().setInt(1, proveedor.getCodigo());
		rs = conexion.resultSet();
			while (rs.next()) {
				proveedor.setNIT(rs.getString("NIT"));
				proveedor.setEmpresa(rs.getString("Empresa"));
				proveedor.setNombre(rs.getString("nombre"));
				proveedor.setTelefono(rs.getInt("telefono"));
		}

		rs.close();

	}

	public void update(Proveedor proveedor) throws Throwable {
		String NIT;
		String nombre;
		String empresa;
		int telefono;
		if (proveedor != null) {
			NIT = proveedor.getNIT();
			nombre = proveedor.getNombre();
			empresa = proveedor.getEmpresa();
			telefono = proveedor.getTelefono();

			conexion.SQL("Update proveedor set NIT = ?, empresa=?, nombre = ?, telefono=? where codigo=?");

			conexion.preparedStatement().setString(1, NIT);
			conexion.preparedStatement().setString(2, empresa);
			conexion.preparedStatement().setString(3, nombre);
			conexion.preparedStatement().setInt(4, telefono);
			conexion.CUD();
		}
	}

}
