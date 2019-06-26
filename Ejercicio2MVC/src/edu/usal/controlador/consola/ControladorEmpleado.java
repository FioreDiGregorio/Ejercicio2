package edu.usal.controlador.consola;

import java.io.IOException;
import java.util.List;

import edu.usal.dao.factory.EmpleadoFactory;
import edu.usal.vista.consola.VistaEmpleado;
import edu.usal.negocio.interfaces.EmpleadoDAO;

public class ControladorEmpleado {

	private VistaEmpleado vista;
	private EmpleadoDAO empleadoDAO;
	
	public ControladorEmpleado(VistaEmpleado vista) throws IOException {
		super();
		this.vista = vista;
		this.empleadoDAO = EmpleadoFactory.GetImplementation("Archivo");
		
	}

	
	public void AgregarEmpleado() throws IOException{
		
		this.empleadoDAO.AgregarEmpleado(vista.AltaEmpleado());
		
	}
	
	 public void BuscarEmpleado() throws IOException{
		 String categoria =vista.buscarEmpleado();
		 if(categoria.equals("back")) {	
			 
		return;
		
		 }

		 else{
			List<String> Lista = this.empleadoDAO.BuscarEmpleado(categoria);

				vista.mensaje("Empleado encontrado en categoria " + categoria + "\n");
				for(int i=0;i<Lista.size();i++) {
				vista.mensaje(Lista.get(i));
				
				}return;
		 }}
 

	public boolean EliminarEmpleado() throws IOException{
		String Dni = vista.eliminarEmpleado();
		if(Dni.equals("back")){
			return false;

		}
	boolean encontrado = this.empleadoDAO.EliminarEmpleado(Dni);
	if(encontrado == true){
		vista.mensaje("Se elimino el Empleado con DNI " + Dni + "\n");
		Todos();
	}
	else{
		vista.mensaje("no se encontro");


	}
	return encontrado;

	}
	
	public void Todos() throws IOException{
		vista.imprimirTodos(this.empleadoDAO.GetAll());
	}
	
	public void MostrarMenu() throws IOException {
		boolean fin = false;
		while(!fin) {
			
			int opcion = vista.menu();
			
			switch(opcion){
			case 1:
				this.AgregarEmpleado();
			break;
			
			case 2:
				this.Todos();
				break;

			case 3:

				this.EliminarEmpleado();
				break;


				case 4:
					fin = true;
					break;

			case 5:
					this.BuscarEmpleado();
					break; 	
					
					
			default:
				System.out.println("Opcion no valida.");
			}
			
		}
		
	}
	
	
}