package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.DetalleVenta;

public class DetalleVentaCtrl implements Control<DetalleVenta> {
	private Conexion conexion;

	public DetalleVentaCtrl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<DetalleVenta> list() throws Throwable {
		ArrayList<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>();
		
		ResultSet rs;
		
		int codigo;
		int codigoVenta;
		int codigoProducto;
		int cantidad;
		
		conexion.SQL("SELECT *  from detalleventa ");
		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
			codigoVenta = rs.getInt("codigo de Venta");
			codigoProducto = rs.getInt("codigo de producto");
			cantidad = rs.getInt("Cantidad");
			detalleVentas.add(new DetalleVenta(codigo, codigoVenta, codigoProducto, cantidad));
		}

		return detalleVentas;

	}

	public void insert(DetalleVenta detalleVenta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select codigoVenta from venta ORDER BY venta.codigo DESC limit 1;");
		
		rs = conexion.resultSet();
		
		int codigoVenta;
		rs.next();
		
		codigoVenta = rs.getInt("venta.codigo");
		rs.close();

		conexion.SQL("Insert into detalleVenta(codigoVenta, codigoProducto, cantidad) VALUES(?,?,?)");
		int codigo = detalleVenta.getCodigo();
		int cantidad = detalleVenta.getCantidad();

		conexion.preparedStatement().setInt(1, codigoVenta);
		conexion.preparedStatement().setInt(2, detalleVenta.getCodigoProducto());
		conexion.preparedStatement().setInt(3, detalleVenta.getCantidad());

		conexion.CUD();

		conexion.SQL("Select * from producto where codigo = ?;");
		conexion.preparedStatement().setInt(1, detalleVenta.getCodigoProducto());
		rs = conexion.resultSet();

		int dato;
		rs.next();
		dato = rs.getInt("stock");
		

		rs.close();

		conexion.SQL("Update detalleVenta set cantidad = ? where codigo = ?;");
		conexion.preparedStatement().setInt(1, cantidad);
		conexion.preparedStatement().setInt(2, codigo);
		conexion.CUD();

		conexion.SQL("Update producto set stock = ? where codigo = ?");
		conexion.preparedStatement().setInt(1, (dato - cantidad));
		conexion.preparedStatement().setInt(2, detalleVenta.getCodigoProducto());

		conexion.CUD();

	}

	public void search(DetalleVenta detalleVenta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalleVenta where codigo=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setCodigoVenta(rs.getInt("codigo de venta"));
			detalleVenta.setCodigoProducto(rs.getInt("codigo de producto"));
			detalleVenta.setCantidad(rs.getInt("cantidad"));
		}

		rs.close();

	}

	@Override
	public void update(DetalleVenta detalleVenta) throws Throwable {

	}

}
