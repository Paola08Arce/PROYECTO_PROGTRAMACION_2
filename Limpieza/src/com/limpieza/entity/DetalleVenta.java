package com.limpieza.entity;

public class DetalleVenta {

	private int codigo;
	private int codigoVenta;
	private int codigoProducto;
	private int cantidad;
	

	public DetalleVenta(int codigo, int codigoVenta, int codigoProducto, int cantidad) {
		super();
		this.codigo = codigo;
		this.codigoVenta = codigoVenta;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
	}

	public DetalleVenta(int codigo) {
		this.codigo = codigo;
	}

	public DetalleVenta(int codigoProducto, int cantidad) {
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetalleVenta [Código: " + codigo + ", Código de Venta: " + codigoVenta + ", Código de Producto: " + codigoProducto
				+ ", Cantidad:" + cantidad + "]";
	}
}
