package edu.usal.vista.consola;


import java.util.List;


import edu.usal.negocio.dominio.Empresa;
import edu.usal.util.IOGeneral;

public class VistaEmpresa {
	public VistaEmpresa(){


	}
	public int menu() {
		System.out.println("");
		System.out.println("1-Agregar Empresa");
		System.out.println("2-Todos Los Empresa");
		System.out.println("3-Eliminar Empresa");
		System.out.println("4-Salir");
		return IOGeneral.leerInt("Ingrese una opcion", "Solo numeros");

	}
	
	
	
	public Empresa AltaEmpresa() {
		
		
		
		Empresa empresa= new Empresa();
		
		empresa.setNombredeEmpresa(IOGeneral.leerLinea("Ingresar nombre empresa: "));
		empresa.setRazonSocial(IOGeneral.leerLinea("Ingrese raazon ssocial: "));
		empresa.setCuit("");
		while (!(empresa.getCuit().matches("[3]{1}[0]+") ||empresa.getCuit().matches("[3]{1}[1]+") || 
				empresa.getCuit().matches("[3]{1}[3]+"))) {
		empresa.setCuit(IOGeneral.leerLinea("Ingrese cuit: (debe comenzar con 30/31/33)"));
		}
		
		empresa.setDireccion(IOGeneral.leerLinea("Ingrese direccion: "));
		empresa.setLocalidad(IOGeneral.leerLinea("Ingrese localidad: "));
		empresa.setCodigoPostal(IOGeneral.leerLinea("Ingrese codigo postal: "));
		empresa.setTelefono(IOGeneral.leerLinea("Ingrese telefono: "));
		empresa.setActividad(IOGeneral.leerLinea("Ingrese actividad: "));
		
		
		return empresa;
		
		
		
	}

	public String eliminarEmpresa() {


		String cuit  =  IOGeneral.leerLinea("Ingrese el cuit del empleado que desea eliminar: (´back´ para volver)");

return cuit ;

	}


	public void imprimirTodos(List<Empresa> listado) {

		for(Empresa empresa : listado) {
			
			System.out.println(
			"Nombre empresa: "+ empresa.getNombredeEmpresa() +
			"Razon social: " + empresa.getRazonSocial() +
			"Cuit: " + empresa.getCuit() +
			"Direccion: " + empresa.getDireccion() +
			"Localidad: " + empresa.getLocalidad() +
			"Codigo posta: " + empresa.getCodigoPostal() + 
			"Telefono: " + empresa.getTelefono() +
			"Actividad: " + empresa.getActividad() 
			+ " || "	);
			
		}
		
	}


	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
