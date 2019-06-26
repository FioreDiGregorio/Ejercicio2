package edu.usal.controlador.consola;

import java.io.IOException;

import edu.usal.dao.factory.EmpresaFactory;
import edu.usal.vista.consola.VistaEmpresa;
import edu.usal.negocio.interfaces.EmpresaDAO;

public class ControladorEmpresa {

	private VistaEmpresa vista;
	private EmpresaDAO empresaDAO;
	
	public ControladorEmpresa(VistaEmpresa vista) throws IOException {
		super();
		this.vista = vista;
		this.empresaDAO = EmpresaFactory.GetImplementation("Archivo");
		
	}
	
	public void AgregarEmpresa() throws IOException{
		
		this.empresaDAO.AgregarEmpresa(vista.AltaEmpresa());
	}
	public boolean EliminarEmpresa() throws IOException{
		String Cuit = vista.eliminarEmpresa();
		if(Cuit.equals("back")){
			return false;

		}
	boolean encontrado = this.empresaDAO.EliminarEmpresa(Cuit);
	if(encontrado == true){
		vista.mensaje("Se elimino el Empresa con cuit " + Cuit + "\n");
		Todos();
	}
	else{
		vista.mensaje("no se encontro");


	}
	return encontrado;

	}
	
	public void Todos() throws IOException{
		vista.imprimirTodos(this.empresaDAO.GetAll());
	}
	
	public void MostrarMenu() throws IOException {
		boolean fin = false;
		while(!fin) {
			
			int opcion = vista.menu();
			
			switch(opcion){
			case 1:
				this.AgregarEmpresa();
			break;
			
			case 2:
				this.Todos();
				break;

			case 3:

				this.EliminarEmpresa();
				break;


				case 4:
					fin = true;
					break;

			default:
				System.out.println("Opcion no valida.");
			}
			
		}
		
	}}
	
