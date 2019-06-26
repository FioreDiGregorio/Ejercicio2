package edu.usal.vista.consola;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import edu.usal.negocio.dominio.Empleado;
import edu.usal.util.IOGeneral;

public class VistaEmpleado {
	
	
	public VistaEmpleado(){


	}
	public int menu() {
		System.out.println("");
		System.out.println("1-Agregar Empleado");
		System.out.println("2-Todos Los Empelado");
		System.out.println("3-Eliminar Empleado");
		System.out.println("4-Continuar con el ABM de empresas ");
		System.out.println("5-Buscar Empleado");
		return IOGeneral.leerInt("Ingrese una opcion", "Solo numeros");

	}
	
	
	
	public Empleado AltaEmpleado() throws FileNotFoundException, IOException {
		
		Empleado empleado = new Empleado();
		
		empleado.setNombre(IOGeneral.leerLinea("Ingrese nombre: "));
		empleado.setApellido(IOGeneral.leerLinea("Ingrese apellido: "));
		empleado.setCategoria(IOGeneral.leerLinea("Ingrese categoria: "));

		empleado.setDireccion(IOGeneral.leerLinea("Ingrese direccion: "));
		empleado.setDni(IOGeneral.leerLinea("Ingrese Dni: "));
		empleado.setLegajo(IOGeneral.leerLinea("Ingrese Legajo: "));
		empleado.setNacionalidad(IOGeneral.leerLinea("Ingrese Nacionalidad: "));
		empleado.setSueldoBruto(IOGeneral.leerDouble("Ingrese Sueldo bruto: ", "error"));

		
		return empleado;
		
		
		
	}

	public String eliminarEmpleado() {


		String dni  =  IOGeneral.leerLinea("Ingrese el dni del empleado que desea eliminar: (´back´ para volver)");

return dni ;

	}

	public String buscarEmpleado() {
		String categoria  =  IOGeneral.leerLinea("Ingrese categoria: (´back´ para volver)");
		return categoria;
	}
	
	

	public void imprimirTodos(List<Empleado> listado) {

		for(Empleado empleado : listado) {
			
			System.out.println(
			"Nombre: "+ empleado.getNombre() +
			", Apellido: " + empleado.getApellido() +
			", Dni: " + empleado.getDni()
			+ " || "	);
			
		}
		
	}


	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
