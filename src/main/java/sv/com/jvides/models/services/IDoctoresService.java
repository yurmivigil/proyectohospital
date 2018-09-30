package sv.com.jvides.models.services;

import java.util.List;
import sv.com.jvides.models.entities.Doctores;

public interface IDoctoresService {

	public List<Doctores> findAll();
	
	public void save(Doctores doctores);
	
	public Doctores findOne(Long id);
	
	public void delete(Long id);
}
