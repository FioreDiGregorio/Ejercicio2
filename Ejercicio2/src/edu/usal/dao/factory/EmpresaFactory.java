package edu.usal.dao.factory;

import edu.usal.negocio.interfaces.EmpresaDAO;

import java.io.IOException;

import edu.usal.dao.implementacion.*;

	public class EmpresaFactory {

	public static EmpresaDAO GetImplementation(String source) throws IOException{
		
		if (source.equals("Archivo")) {
			return new EmpresaDAOimpArchivo();
		}
		else if(source.equals("Serializacion")) {
			
			return new EmpresaDAOimpSerializacion();
		}
		return null;
	}
	 
	
}