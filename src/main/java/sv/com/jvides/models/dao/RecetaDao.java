package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Receta;


public interface RecetaDao extends CrudRepository<Receta, Long> {
	

}