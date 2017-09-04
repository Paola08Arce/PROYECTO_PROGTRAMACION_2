package com.limpieza.entity;

import java.util.Date;

public class Venta {

	private int codigo;
	private String NIT;
	private Date fecha;

	public Venta(int codigo, String NIT, Date fecha) {

		this.codigo = codigo;
		this.NIT = NIT;
		this.fecha = fecha;
	}

	public Venta(int codigo) {
		this.codigo = codigo;
	}

	public Venta(String NIT, Date fecha) {
		this.NIT = NIT;
		this.fecha = fecha;
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

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Venta [Código: " + codigo + ", NIT: " + NIT + ", Fecha: " + fecha + "]";
	}

}
