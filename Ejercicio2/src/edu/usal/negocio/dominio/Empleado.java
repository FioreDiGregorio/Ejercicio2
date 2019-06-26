package edu.usal.negocio.dominio;

public class Empleado {
	
	
	String Nombre, Apellido, Dni, Legajo,Categoria, Direccion, Nacionalidad;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getLegajo() {
		return Legajo;
	}
	public void setLegajo(String legajo) {
		Legajo = legajo;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public Double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(Double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	Double sueldoBruto;
	
}
