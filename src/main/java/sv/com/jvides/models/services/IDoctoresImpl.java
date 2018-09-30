package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.IDoctoresDao;
import sv.com.jvides.models.entities.Doctores;


@Service
public class IDoctoresImpl implements IDoctoresService {


	@Autowired
	private IDoctoresDao doctoresDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Doctores> findAll() {		
		return (List<Doctores>) doctoresDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Doctores findOne(Long id) {		
		return doctoresDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Doctores doctores) {
		doctoresDao.save(doctores);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		doctoresDao.deleteById(id);
	}

	

	
}
