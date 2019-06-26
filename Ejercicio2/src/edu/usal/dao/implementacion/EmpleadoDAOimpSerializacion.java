package edu.usal.dao.implementacion;

import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Empleado;
import edu.usal.negocio.interfaces.EmpleadoDAO;

public class EmpleadoDAOimpSerializacion implements EmpleadoDAO {

	@Override
	public void AgregarEmpleado(Empleado empleado) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Empleado> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ModificarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean EliminarEmpleado(String dni) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<String> BuscarEmpleado(String categoria) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
