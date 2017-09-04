package com.limpieza.entity;

import java.util.Date;

public class Compra {

	private int codigo;
	private Date fecha;
	private String NIT;

	public Compra(int codigo, Date fecha, String NIT) {

		this.codigo = codigo;
		this.fecha = fecha;
		this.NIT = NIT;
	}

	public Compra(int codigo) {
		this.codigo = codigo;
	}

	public Compra(Date fecha, String NIT) {
		this.fecha = fecha;
		this.NIT = NIT;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	@Override
	public String toString() {
		return "Compra [Código: " + codigo + ", Fecha: " + fecha + ", NIT: " + NIT + "]";
	}
}
