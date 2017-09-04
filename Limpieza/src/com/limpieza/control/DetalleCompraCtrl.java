package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.DetalleCompra;

public class DetalleCompraCtrl implements Control<DetalleCompra> {

	private Conexion conexion;

	public DetalleCompraCtrl(Conexion conexion) {

		this.conexion = conexion;
	}

	public ArrayList<DetalleCompra> list() throws Throwable {

		ArrayList<DetalleCompra> detalleCompras = new ArrayList<DetalleCompra>();

		ResultSet rs;

		int codigo;
		int codigoCompra;
		int codigoProducto;
		String nombreProducto;
		int cantidad;

		conexion.SQL("Select * from detalleCompra");

		rs = conexion.resultSet();

		while (rs.next()) {

			codigo = rs.getInt("codigo");
			codigoCompra = rs.getInt("codigoCompra");
			codigoProducto = rs.getInt("codigoProducto");
			nombreProducto = rs.getString("nombreProducto");
			cantidad = rs.getInt("cantidad");

			detalleCompras.add(new DetalleCompra(codigo, codigoCompra, codigoProducto, nombreProducto, cantidad));
		}

		return detalleCompras;

	}

	public void insert(DetalleCompra detalleCompra) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select codigoCompra from compra ORDER BY compra.codigo DESC limit 1;");
		rs = conexion.resultSet();

		int codigoCompra;
		rs.next();
		codigoCompra = rs.getInt("compra.codigo");
		rs.close();

		conexion.SQL(
				"Insert into detalleCompra(codigoCompra, codigoProducto, nombreProducto, cantidad) VALUES(?,?,?,?);");

		int codigo = detalleCompra.getCodigo();
		int cantidad = detalleCompra.getCantidad();

		conexion.preparedStatement().setInt(1, codigoCompra);
		conexion.preparedStatement().setInt(2, detalleCompra.getCodigoProducto());
		conexion.preparedStatement().setString(3, detalleCompra.getNombreProducto());
		conexion.preparedStatement().setInt(4, detalleCompra.getCantidad());
		conexion.CUD();

		conexion.SQL("Select * from producto where codigo = ?;");
		conexion.preparedStatement().setInt(1, detalleCompra.getCodigo());

		rs = conexion.resultSet();

		int reserva;
		rs.next();
		reserva = rs.getInt("stock");
		rs.close();

		conexion.SQL("Update detalleCompra set cantidad = ? where codigo = ?;");

		conexion.preparedStatement().setInt(1, cantidad);
		conexion.preparedStatement().setInt(2, codigo);
		conexion.CUD();

		conexion.SQL("Update producto set stock = ? where codigo = ?");
		conexion.preparedStatement().setInt(1, (reserva + cantidad));
		conexion.preparedStatement().setString(2, detalleCompra.getNombreProducto());
		conexion.CUD();

	}

	public void search(DetalleCompra detalleCompra) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalleCompra where codigo=?");
		conexion.preparedStatement().setInt(1, detalleCompra.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleCompra.setCodigoCompra(rs.getInt("Código de Compra"));
			detalleCompra.setCodigoProducto(rs.getInt("codigoProducto"));
			detalleCompra.setNombreProducto(rs.getString("Nombre de producto"));
			detalleCompra.setCantidad(rs.getInt("Cantidad"));
		}

		rs.close();

	}

	@Override
	public void update(DetalleCompra detalleCompra) throws Throwable {

	}

}
