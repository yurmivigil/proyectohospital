package sv.com.jvides.models.services;

import java.util.List;
import sv.com.jvides.models.entities.Receta;

public interface RecetaService {

	public List<Receta> findAll();
	
	public void save(Receta Receta);
	
	public Receta findOne(Long id);
	
	public void delete(Long id);
}
