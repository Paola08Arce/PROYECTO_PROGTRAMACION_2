package com.limpieza.entity;

public class Producto {

	private int codigo;
	private String nombre;
	private String marca;
	private double precio;
	private int codigoCategoria;
	private int stock;

	public Producto(int codigo, String nombre, String marca, double precio, int codigoCategoria, int stock) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.codigoCategoria = codigoCategoria;
		this.stock = stock;
	}

	public Producto(int codigo) {
		this.codigo = codigo;
	}

	public Producto(String nombre, String marca, double precio, int codigoCategoria, int stock) {

		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.codigoCategoria = codigoCategoria;
		this.stock = stock;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public int getStock() {

		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [Código: " + codigo + ", Nombre: " + nombre + ", Marca: " + marca + ", Precio: " + precio
				+ ", Codigo Categoria: " + codigoCategoria + ", Stock: " + stock + "]";
	}

}
