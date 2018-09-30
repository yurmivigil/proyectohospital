package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.IResponsableDao;
import sv.com.jvides.models.entities.Responsable;
@Service
public class IResponsableImpl implements IResponsableService {

	@Autowired
	private IResponsableDao responsableDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Responsable> findAll() {
		return (List<Responsable>) responsableDao.findAll();
	}

	@Override
	@Transactional
	public void save(Responsable responsable) {
		responsableDao.save(responsable);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Responsable findOne(Long id) {
		return responsableDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		responsableDao.deleteById(id);		
	}

}
