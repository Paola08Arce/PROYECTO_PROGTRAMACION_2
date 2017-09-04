package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.Producto;

public class ProductoCtrl implements Control<Producto> {
	private Conexion conexion;

	public ProductoCtrl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Producto> list() throws Throwable {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ResultSet rs;
		int codigo;
		String nombre;
		String marca;
		double precio;
		int codigoCategoria;
		int stock;

		conexion.SQL("select* from producto ");

		rs = conexion.resultSet();

		while (rs.next()) {
			codigo = rs.getInt("codigo");
			nombre = rs.getString("nombre");
			marca = rs.getString("marca");
			precio = rs.getDouble("precio");
			stock = rs.getInt("stock");
			codigoCategoria = rs.getInt("codigoCategoria");

			productos.add(new Producto(codigo, nombre, marca, precio, codigoCategoria, stock));
		}

		return productos;

	}

	public void insert(Producto producto) throws Throwable {

		conexion.SQL("Insert into producto(nombre, marca, precio, codigoCategoria, stock) VALUES(?,?,?,?,?)");

		conexion.preparedStatement().setString(1, producto.getNombre());
		conexion.preparedStatement().setString(2, producto.getMarca());
		conexion.preparedStatement().setDouble(3, producto.getPrecio());
		conexion.preparedStatement().setInt(4, producto.getCodigoCategoria());
		conexion.preparedStatement().setInt(5, producto.getStock());
		conexion.CUD();

	}

	public void search(Producto producto) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from producto where codigo=?");
		conexion.preparedStatement().setInt(1, producto.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			producto.setNombre(rs.getString("nombre"));
			producto.setMarca(rs.getString("marca"));
			producto.setPrecio(rs.getInt("precio"));
			producto.setCodigoCategoria(rs.getInt("codigo"));
			producto.setStock(rs.getInt("Stock"));

		}

		rs.close();

	}

	public void update(Producto producto) throws Throwable {

		int codigo;
		String nombre;
		String marca;
		double precio;
		int codigoCategoria;
		int stock;

		if (producto != null) {
			nombre = producto.getNombre();
			marca = producto.getMarca();
			codigo = producto.getCodigo();
			precio = producto.getPrecio();
			stock = producto.getStock();

			codigoCategoria = producto.getCodigoCategoria();

			conexion.SQL(
					"Update cliente set nombre = ?, marca = ?,  precio=?, codigoCategoria=?, stock=? where codigo=?");

			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, marca);
			conexion.preparedStatement().setDouble(3, precio);
			conexion.preparedStatement().setInt(4, codigoCategoria);
			conexion.preparedStatement().setInt(5, stock);
			conexion.preparedStatement().setInt(6, codigo);
			conexion.CUD();
		}
	}

}
