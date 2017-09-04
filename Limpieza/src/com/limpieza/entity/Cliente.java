package com.limpieza.entity;

public class Cliente {

	private String NIT;
	private String nombre;
	private int telefono;

	public Cliente(String NIT, String nombre, int telefono) {
		
		this.NIT = NIT;
		this.nombre = nombre;
		this.telefono = telefono;

	}

	public Cliente(String NIT) {
		this.NIT = NIT;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
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
		return "Cliente [NIT: " + NIT + 
				", Nombre: " + nombre + 
				", Teléfono: " + telefono + "]";
	}
}
