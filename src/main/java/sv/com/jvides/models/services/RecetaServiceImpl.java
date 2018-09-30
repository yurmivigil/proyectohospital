package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.RecetaDao;
import sv.com.jvides.models.entities.Receta;


@Service
public class RecetaServiceImpl implements RecetaService {


	@Autowired
	private RecetaDao recetasDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Receta> findAll() {		
		return (List<Receta>) recetasDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Receta findOne(Long id) {		
		return recetasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Receta Receta) {
		recetasDao.save(Receta);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		recetasDao.deleteById(id);
	}

	

	
}