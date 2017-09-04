package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.limpieza.entity.Compra;

public class CompraCtrl implements Control<Compra> {

	private Conexion conexion;

	public CompraCtrl(Conexion conexion) {

		this.conexion = conexion;
	}

	public ArrayList<Compra> list() throws Throwable {

		ArrayList<Compra> compras = new ArrayList<Compra>();
		
		ResultSet rs;
		int codigo;
		String NIT;
		Date fecha;

		conexion.SQL("Select * from compra");

		rs = conexion.resultSet();

		while (rs.next()) {

			codigo = rs.getInt("codigo");
			fecha = rs.getDate("stock");
			NIT = rs.getString("NIT");
			compras.add(new Compra(codigo, fecha, NIT));
		}
		return compras;
	}

	public void insert(Compra compra) throws Throwable {

		conexion.SQL("Insert into compra(NIT, fecha) VALUES(?,?)");

		conexion.preparedStatement().setString(1, compra.getNIT());
		conexion.preparedStatement().setDate(2, new java.sql.Date(compra.getFecha().getTime()));

		conexion.CUD();

	}

	public void search(Compra compra) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from compra where codigo=?");

		conexion.preparedStatement().setInt(1, compra.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			compra.setFecha(rs.getDate("fecha"));
			compra.setNIT(rs.getString("NIT"));

		}

		rs.close();
	}

	@Override
	public void update(Compra compra) throws Throwable {
	}

}
