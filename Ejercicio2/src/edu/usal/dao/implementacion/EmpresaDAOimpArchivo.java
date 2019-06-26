package edu.usal.dao.implementacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dominio.Empresa;
import edu.usal.negocio.interfaces.*;

public class EmpresaDAOimpArchivo implements EmpresaDAO {
	
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferedWriter;
	private BufferedReader archivoBufferedReader;

	
	public EmpresaDAOimpArchivo() throws IOException {
		archivo = new File("empresa.txt");
	}
	
	@Override
	public void AgregarEmpresa(Empresa empresa) throws IOException {
		
	
		archivoWriter = new FileWriter(archivo, true);
		archivoBufferedWriter = new BufferedWriter(archivoWriter);
		
		String str = SaveEmpresa(empresa);
		
		archivoBufferedWriter.write(str);
		archivoBufferedWriter.close();
		archivoWriter.close();
			
	}
	
	private String SaveEmpresa(Empresa empresa){
		
		return empresa.getNombredeEmpresa() + ";" + empresa.getRazonSocial() +
				";"+ empresa.getCuit()+
				";"+empresa.getDireccion()+";"+empresa.getLocalidad()+
				";"+ empresa.getCodigoPostal() +";"+ empresa.getTelefono() +";"+ 
				empresa.getActividad()+ ";"+ "\n" ;
		
		
	}

	@Override
	public boolean EliminarEmpresa(String cuit) throws IOException {
		archivo = new File("empresa.txt");

		archivoReader = new FileReader(archivo );
		archivoBufferedReader = new BufferedReader(archivoReader);


		archivoWriter = new FileWriter("tempFile.txt", false);
		archivoBufferedWriter = new BufferedWriter(archivoWriter);

		String linea = archivoBufferedReader.readLine();

		boolean encontrado = false;
		while (linea!= null){

			String[] lineaArray  =  linea.split(";");
			String cuitActual = lineaArray[1];

			if(cuit.equals(cuitActual)){
					encontrado= true;
			}
			else{
				archivoBufferedWriter.write(linea);
				archivoBufferedWriter.newLine();
			}

			linea = archivoBufferedReader.readLine();
		}
		archivoBufferedWriter.flush();
		archivoBufferedWriter.close();

		if(encontrado== true){
			archivoReader = new FileReader("tempFile2.txt" );
			archivoBufferedReader = new BufferedReader(archivoReader);


			archivoWriter = new FileWriter("empresa.txt", false);
			archivoBufferedWriter = new BufferedWriter(archivoWriter);

			String linea2 = archivoBufferedReader.readLine();


			while (linea2!= null){

				archivoBufferedWriter.write(linea2);
				archivoBufferedWriter.newLine();


				linea2 = archivoBufferedReader.readLine();
			}
			archivoBufferedWriter.flush();
			archivoBufferedWriter.close();
		}




	return encontrado;
	}
	
	@Override
	public List<Empresa> GetAll() throws IOException{
		
		
		archivo = new File("empresa.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferedReader = new BufferedReader(archivoReader);
		
		String linea;
		List<Empresa> listadoEmpresa = new ArrayList<Empresa>();
		
		while((linea = archivoBufferedReader.readLine()) != null) {
			
			listadoEmpresa.add(ParseEmpresa(linea));
			
		}
		
			return listadoEmpresa;

	}
	
	private Empresa ParseEmpresa(String linea) {
		String[] atributos = linea.split(";");
		
		Empresa empresa = new Empresa();
		empresa.setNombredeEmpresa(atributos[0]);
		empresa.setRazonSocial(atributos[1]);
		empresa.setCuit(atributos[2]);
		empresa.setDireccion(atributos[3]);
		empresa.setLocalidad(atributos[4]);
		empresa.setCodigoPostal(atributos[5]);
		empresa.setLocalidad(atributos[6]);
		empresa.setActividad(atributos[7]);
		
		
		
		
		
		return empresa;
		


	}
	
	@Override
	public void ModificarEmpresa(Empresa empresa) {}

	
}
