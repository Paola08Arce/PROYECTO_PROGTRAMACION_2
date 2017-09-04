package com.limpieza.entity;

public class DetalleCompra {

	private int codigo;
	private int codigoCompra;
	private int codigoProducto;
	private String nombreProducto;
	private int cantidad;

	public DetalleCompra(int codigo, int codigoCompra, int codigoProducto, String nombreProducto, int cantidad) {

		this.codigo = codigo;
		this.codigoCompra = codigoCompra;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;

	}

	public DetalleCompra(int codigo) {
		this.codigo = codigo;
	}

	public DetalleCompra(String nombreProducto, int cantidad) {

		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	@Override
	public String toString() {
		return "DetalleCompra [Código: " + codigo + ", Código de compra: " + codigoCompra + ", Código de Producto: "
				+ codigoProducto + ", Nombre de producto: " + nombreProducto + ", Cantidad: " + cantidad + "]";
	}

}
