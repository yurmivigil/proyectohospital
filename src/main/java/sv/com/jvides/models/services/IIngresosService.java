package sv.com.jvides.models.services;

import java.util.List;

import sv.com.jvides.models.entities.Ingresos;

public interface IIngresosService {

	public List<Ingresos> findAll();
	
	public void save(Ingresos ingresos);
	
	public Ingresos findOne(Long id);
	
	public void delete(Long id);
}
