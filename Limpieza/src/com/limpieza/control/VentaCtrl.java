package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.limpieza.entity.Venta;

public class VentaCtrl implements Control<Venta> {
	private Conexion conexion;

	public VentaCtrl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		int codigo;
		Date fecha;
		String NIT;
		conexion.SQL("Select * from venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
			fecha = rs.getDate("fecha");
			NIT = rs.getString("NIT");
			ventas.add(new Venta(codigo, NIT, fecha));
		}

		return ventas;

	}

	public void insert(Venta venta) throws Throwable {

		conexion.SQL("Insert into venta(NIT, fecha) VALUES(?,?)");

		conexion.preparedStatement().setString(1, venta.getNIT());
		conexion.preparedStatement().setDate(2, new java.sql.Date(venta.getFecha().getTime()));

		conexion.CUD();
	}

	public void search(Venta venta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from venta where codigo=?");
		conexion.preparedStatement().setInt(1, venta.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			venta.setFecha(rs.getDate("fecha"));
			venta.setNIT(rs.getString("NIT"));
		}

		rs.close();
	}

	@Override
	public void update(Venta venta) throws Throwable {

	}

}
