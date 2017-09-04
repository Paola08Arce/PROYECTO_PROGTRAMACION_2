package com.limpieza.entity;

public class Categoria {
	
	private int codigo;
	private String nombre;
	private String descripcion;
	
	public Categoria(int codigo, String nombre, String descripcion) {
	
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Categoria(int codigo) {
		this.codigo=codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Categoria [C�digo: " + codigo + ", Nombre: " + nombre + ", Descripci�n: " + descripcion + "]";
	}

}
