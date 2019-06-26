package edu.usal.dao.implementacion;

import java.io.*;
import java.util.*;

import edu.usal.negocio.dominio.Empleado;
import edu.usal.negocio.interfaces.EmpleadoDAO;

public class EmpleadoDAOimplArchivo implements EmpleadoDAO {
	
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferedWriter;
	private BufferedReader archivoBufferedReader;


	public EmpleadoDAOimplArchivo() throws IOException {
		archivo = new File("empleados.txt");
	}

	@Override
	public void AgregarEmpleado(Empleado empleado) throws IOException {


		archivoWriter = new FileWriter(archivo, true);
		archivoBufferedWriter = new BufferedWriter(archivoWriter);

		
		String str = SaveEmpleado(empleado);
		
		archivoBufferedWriter.write(str);
		archivoBufferedWriter.flush();
		archivoBufferedWriter.close();

			
	}
	
	private String SaveEmpleado(Empleado empleado){
		
		return empleado.getNombre() + ";" + empleado.getApellido() + ";" +
				empleado.getDni() + ";" + empleado.getLegajo() + ";" + empleado.getCategoria() + ";" + 
				empleado.getDireccion() + ";" + empleado.getNacionalidad() + ";" +
				empleado.getSueldoBruto() + ";" + "\n";
		
	}
	
	@Override
	public List<String> BuscarEmpleado(String categoria) throws IOException {
		archivo = new File("empleados.txt");
		archivoReader = new FileReader(archivo );
		archivoBufferedReader = new BufferedReader(archivoReader);
		List<String> Lista = new ArrayList<String>();

		String linea = archivoBufferedReader.readLine();
		
		while (linea!= null){
			
			String[] lineaArray  =  linea.split(";");
			String CategoriaActual = lineaArray[4];
			
			if(categoria.equals(CategoriaActual)){
					Lista.add(CategoriaActual);
			}
		}
			
		return Lista;
	
	}
	
	@Override
	public boolean EliminarEmpleado(String dni) throws IOException {
		archivo = new File("empleados.txt");

		archivoReader = new FileReader(archivo );
		archivoBufferedReader = new BufferedReader(archivoReader);
		
		archivoWriter = new FileWriter("tempFile.txt", false);
		archivoBufferedWriter = new BufferedWriter(archivoWriter);

		String linea = archivoBufferedReader.readLine();

		boolean encontrado = false;
		while (linea!= null){
			
			String[] lineaArray  =  linea.split(";");
			String dniActual = lineaArray[2];

			if(dni.equals(dniActual)){
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
			archivoReader = new FileReader("tempFile.txt" );
			archivoBufferedReader = new BufferedReader(archivoReader);


			archivoWriter = new FileWriter("empleados.txt", false);
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
	public List<Empleado> GetAll() throws IOException{

		archivo = new File("empleados.txt");

		archivoReader = new FileReader(archivo);
		archivoBufferedReader = new BufferedReader(archivoReader);



		String linea;
		List<Empleado> listadoEmpleado = new ArrayList<Empleado>();
		
		while((linea = archivoBufferedReader.readLine()) != null) {
			
			listadoEmpleado.add(ParseEmpleado(linea));
			
		}
		
			return listadoEmpleado;

	}
	
	private Empleado ParseEmpleado(String linea){
		String[] atributos = linea.split(";");
		
		Empleado empleado = new Empleado();
		empleado.setNombre(atributos[0]);
		empleado.setApellido(atributos[1]);
		empleado.setDni(atributos[2]);
		empleado.setLegajo(atributos[3]);
		empleado.setCategoria(atributos[4]);
		empleado.setDireccion(atributos[5]);
		empleado.setNacionalidad(atributos[6]);
		Double Parseo1 = Double.parseDouble(atributos[7]);
		empleado.setSueldoBruto(Parseo1);
		
		

		return empleado;

	}
	
	@Override
	public void ModificarEmpleado(Empleado empleado) {

	}

	
	
	
}