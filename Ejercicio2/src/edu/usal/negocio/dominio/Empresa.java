package edu.usal.negocio.dominio;

public class Empresa {

	public String getNombredeEmpresa() {
		return NombredeEmpresa;
	}

	public void setNombredeEmpresa(String nombredeEmpresa) {
		NombredeEmpresa = nombredeEmpresa;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getCuit() {
		return Cuit;
	}

	public void setCuit(String cuit) {
		Cuit = cuit;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	String NombredeEmpresa, RazonSocial, Cuit, Direccion, Localidad, CodigoPostal,Telefono,Actividad;
}
