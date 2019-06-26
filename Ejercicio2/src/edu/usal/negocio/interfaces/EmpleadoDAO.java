package edu.usal.negocio.interfaces;


import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Empleado;

public interface EmpleadoDAO{

	public void AgregarEmpleado(Empleado empleado) throws IOException;
		
	List<Empleado> GetAll() throws IOException;
	
	void ModificarEmpleado(Empleado empleado);

	boolean EliminarEmpleado(String dni) throws IOException;

	List<String> BuscarEmpleado(String categoria)throws IOException;




	
}
