package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Pacientes;

public interface IPacientesDao  extends CrudRepository<Pacientes, Long> {

}
