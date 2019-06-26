package edu.usal.main;

import java.io.IOException;

import edu.usal.controlador.consola.ControladorEmpleado;
import edu.usal.controlador.consola.ControladorEmpresa;
import edu.usal.vista.consola.VistaEmpleado;
import edu.usal.vista.consola.VistaEmpresa;
import Ejercicio1.Log;

public class Principal {
	public static void main(String[] args) throws IOException {

		VistaEmpleado vista = new VistaEmpleado();
		ControladorEmpleado controladorEmp = new ControladorEmpleado(vista);
		
		controladorEmp.MostrarMenu();
		
		VistaEmpresa vista2 = new VistaEmpresa();
		ControladorEmpresa controladorEmpresa = new ControladorEmpresa(vista2);
		
		controladorEmpresa.MostrarMenu();
		
		Ejercicio1.Log.escribir();
	}

}