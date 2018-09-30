package sv.com.jvides.models.dao;

import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Medicamento;

public interface MedicamentoDao  extends CrudRepository<Medicamento, Long>{

}
