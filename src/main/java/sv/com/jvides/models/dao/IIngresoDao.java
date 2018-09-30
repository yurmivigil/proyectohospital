package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Ingresos;

public interface IIngresoDao extends CrudRepository<Ingresos, Long>{
}
