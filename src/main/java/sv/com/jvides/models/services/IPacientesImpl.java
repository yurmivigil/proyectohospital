package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.jvides.models.dao.IDoctoresDao;
import sv.com.jvides.models.dao.IPacientesDao;
import sv.com.jvides.models.entities.Doctores;
import sv.com.jvides.models.entities.Pacientes;

@Service
public class IPacientesImpl implements IPacienteService{

	@Autowired
	private IPacientesDao pacientesDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Pacientes> findAll() {		
		return (List<Pacientes>) pacientesDao.findAll();
	}
	

	@Override
	@Transactional
	public void delete(Long id) {
		pacientesDao.deleteById(id);
	}

	@Override
	public void save(Pacientes pacientes) {
		pacientesDao.save(pacientes);		
	}

	@Override
	public Pacientes findOne(Long id) {
		return pacientesDao.findById(id).orElse(null);
	}

}
