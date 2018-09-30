package sv.com.jvides.models.services;

import java.util.List;
import sv.com.jvides.models.entities.Pacientes;

public interface IPacienteService {
		
	public List<Pacientes> findAll();
	
	public void save(Pacientes pacientes);
	
	public Pacientes findOne(Long id);
	
	public void delete(Long id);
	 
}
