package edu.usal.dao.factory;

import edu.usal.negocio.interfaces.EmpleadoDAO;

import java.io.IOException;

import edu.usal.dao.implementacion.*;

public class EmpleadoFactory {

	public static EmpleadoDAO GetImplementation(String source) throws IOException {
		
		if (source.equals("Archivo")) {
			return new EmpleadoDAOimplArchivo();
		}
		else if(source.equals("Serializacion")) {
			
			return new EmpleadoDAOimpSerializacion();
		}
		return null;
	}
	 
	
}