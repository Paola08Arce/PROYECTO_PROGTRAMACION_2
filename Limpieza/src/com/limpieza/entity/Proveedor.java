package com.limpieza.entity;

public class Proveedor {

	private int codigo;
	private String NIT;
	private String empresa;
	private String nombre;
	private int telefono;

	public Proveedor(int codigo, String NIT, String empresa, String nombre, int telefono) {

		this.codigo = codigo;
		this.NIT = NIT;
		this.empresa = empresa;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Proveedor(String NIT, String empresa, String nombre, int telefono) {

		this.NIT = NIT;
		this.empresa = empresa;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Proveedor(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [Código:" + codigo + ", NIT: " + NIT + ", Empresa: " + empresa + ", Nombre: " + nombre
				+ ", Teléfono:" + telefono + "]";
	}

}
