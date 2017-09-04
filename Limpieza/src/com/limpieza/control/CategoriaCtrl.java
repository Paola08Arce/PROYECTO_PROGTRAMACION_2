package com.limpieza.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.limpieza.entity.Categoria;

public class CategoriaCtrl {

	private Conexion conexion;

	public CategoriaCtrl(Conexion conexion) {

		this.conexion = conexion;
	}

	public ArrayList<Categoria> list() throws Throwable {

		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		ResultSet rs;
		int codigo;
		String nombre;
		String descripcion = null;

		conexion.SQL("Select * from categoria");
		rs = conexion.resultSet();

		while (rs.next()) {

			codigo = rs.getInt("codigo");
			nombre = rs.getString("nombre");
			descripcion = rs.getString("descripcion");
			categorias.add(new Categoria(codigo, nombre, descripcion));
		}
		return categorias;
	}

	public void insert(Categoria categoria) throws Throwable {

		conexion.SQL("Insert into categoria(nombre, descripcion) VALUES(?,?)");

		conexion.preparedStatement().setString(1, categoria.getNombre());
		conexion.preparedStatement().setString(2, categoria.getDescripcion());
		conexion.CUD();

	}

	public void search(Categoria categoria) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from categoria where categoria.codigo =?");

		conexion.preparedStatement().setInt(1, categoria.getCodigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			categoria.setNombre(rs.getString("nombre"));
			categoria.setDescripcion(rs.getString("descripcion"));
		}
		rs.close();
	}

	public void update(Categoria categoria) throws Throwable {

		String nombre;
		String descripcion;
		int codigo;

		if (categoria != null) {
			nombre = categoria.getNombre();
			descripcion = categoria.getDescripcion();
			codigo = categoria.getCodigo();

			conexion.SQL("Update categoria set nombre = ?, descripcion=? where codigo=?");

			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, descripcion);
			conexion.preparedStatement().setInt(3, codigo);
			conexion.CUD();
		}
	}
}
