package edu.usal.negocio.interfaces;


import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Empresa;

public interface EmpresaDAO{

	public void AgregarEmpresa(Empresa empresa) throws IOException;
		
	List<Empresa> GetAll() throws IOException;
	
	void ModificarEmpresa(Empresa empresa);

	boolean EliminarEmpresa(String cuit) throws IOException;


	
}
