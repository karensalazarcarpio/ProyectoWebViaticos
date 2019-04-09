package bo.com.cognos.java.proyecto.services;

import java.util.Date;
import java.util.List;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.XXXModel;

public interface XXXService<T extends XXXModel, ID extends Number> {

	T obtener(ID id) throws ProyectoException;
	List<T> buscar(String filtro)throws ProyectoException;
	List<T> buscar(String filtro, Date fechaInicial, 
			Date fechaFinal)throws ProyectoException;
	void borrar(ID id) throws ProyectoException;
	T guardar(T obj) throws ProyectoException;

	
}
