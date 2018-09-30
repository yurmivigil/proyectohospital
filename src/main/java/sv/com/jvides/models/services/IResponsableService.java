package sv.com.jvides.models.services;

import java.util.List;

import sv.com.jvides.models.entities.Responsable;

public interface IResponsableService {
	public List<Responsable> findAll();
	
	public void save(Responsable responsable);
	
	public Responsable findOne(Long id);
	
	public void delete(Long id);

}
