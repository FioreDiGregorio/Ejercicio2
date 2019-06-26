package edu.usal.dao.implementacion;

import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Empresa;
import edu.usal.negocio.interfaces.EmpresaDAO;

public class EmpresaDAOimpSerializacion implements EmpresaDAO {

	@Override
	public void AgregarEmpresa(Empresa empresa) throws IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Empresa> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ModificarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public boolean EliminarEmpresa(String cuit) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}