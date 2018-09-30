package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Camas;

public interface ICamasDao  extends CrudRepository<Camas, Long> {

}
